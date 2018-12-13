/**
 * Created by bhanu_prakash on 23/11/15.
 */


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.config.HttpClientConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.client.params.CookiePolicy;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.config.RestAssuredConfig.config;
import static org.hamcrest.CoreMatchers.equalTo;

public class RenderDashboard {

    public static String jsonAsString1;
    public  Response response1;
    public String reposeString;


    public  String jsonAsString;
    public  Response response;
    public  String ID;
    public  String jsessionid;
    public  String remebermeID;

    //@Parameters({"username","password","rememberMe"})
    @Test
    public void try18() {



            response =
                    given().

                            header("Host", "10.0.0.52").

                            param("j_username", "abc@xyz.com").
                            param("j_password", "jaa@20").
                            param("_spring_security_remember_me", "1").
                            param("customerId", "").
                            param("districtId", "").
                            param("classCode", "").

                            when().

                            post("http://10.0.0.52/mobile/login").

                            then().

                            //contentType(ContentType.JSON).

                             extract().response(); // extract the response

            // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
            jsonAsString = response.asString();


            jsessionid = response.getCookie("JSESSIONID");
            remebermeID = response.getCookie("SPRING_SECURITY_REMEMBER_ME_COOKIE");

            List<String> info=new ArrayList<String>();
            info.add(jsessionid);
            info.add(remebermeID);

            System.out.println(jsonAsString);
            System.out.println(jsessionid);
            System.out.println(remebermeID);

            Boolean b2 = jsonAsString.contains("firstName");
            Assert.assertTrue(b2,"does not contain");

// Login Ends
//-----------------------------------------------------------------------
// Rendered dashboard starts




        System.out.println("checkkkkk"+jsessionid);
        //RestAssured.config = config().httpClient(new HttpClientConfig().setParam("http.protocol.cookie-policy", CookiePolicy.IGNORE_COOKIES));

        response1 =
                given().
                        //sessionId(jsessionid).
                        header("Host", "10.0.0.52").
                        header("Cookie", "JSESSIONID=" + jsessionid + ";SPRING_SECURITY_REMEMBER_ME_COOKIE=" +remebermeID).
                        header("Referer", "http://10.0.0.52/").

                        // header("Cookie", "JSESSIONID=" + obj.remebermeID).


                        param("subject", "").
                        param("grade", "").


                        when().

                        post("http://10.0.0.52/secure/renderInstructorDashBoard").

                        then().

                        //contentType(ContentType.JSON).

                           extract().response(); // extract the response

        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'

        jsonAsString1 = response1.asString();
        reposeString = response.body().asString();

        System.out.println(jsonAsString);
        System.out.println("I am here" + reposeString);

        //System.out.println(response);
       // System.out.println(obj.jsessionid);

        Boolean b = jsonAsString1.contains("grade");
        Assert.assertTrue(b, "does not contain");

        Boolean b1 = reposeString.contains("interim");
        Assert.assertTrue(b, "does not contain interim");


    }



    }
