


import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.config.HttpClientConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.config.RestAssuredConfig.config;
import org.apache.http.client.params.CookiePolicy;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class htpPost {

    public  String jsonAsString;
    public  Response response;
    public  String ID;
    public  String jsessionid;
    public  String remebermeID;


@Test
    public  List<String> try17() {

        response =
        given().

                header("Host", "10.0.0.52").

                param("j_username", "abc@xyz.com").
                param("j_password", "ja@20").
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

        Boolean b = jsonAsString.contains("firstName");
        Assert.assertTrue(b,"does not contain");

//-----------------------------------------------------------------------

     return  info;


    }


}