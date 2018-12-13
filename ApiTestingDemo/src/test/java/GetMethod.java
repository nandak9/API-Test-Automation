
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetMethod {

    public static String jsonAsString;
    public  static Response response;

    @Test
    public void try19() {

               /* given().
                        header("Host", "10.0.0.52").

                        param("targetUrl", "http://10.0.0.52/").
                        param("_", "1448343923209").*/


                        response =
                        when().

                        get("http://stagingapi.bizom.in/orders/listordersapi?access_token=a25f4768905472f6e58634d4cdcc7e5fdee3214d&responseType=XML&fromdate=2017-04-01&todate=2017-05-01&startseq=0&endseq=1&dateType=modified").

                        then().

                        //contentType(ContentType.ANY).

                                extract().response(); // extract the response
        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
        jsonAsString = response.asString();

        System.out.println(jsonAsString);
        System.out.println("I am here");
        System.out.println(response);
        Boolean b = jsonAsString.contains("Orders");
        Assert.assertTrue(b,"does not contain");
    }
}