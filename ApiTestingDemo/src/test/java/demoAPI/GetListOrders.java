package bizomapi;

//import com.github.fge.jsonschema.cfg.ValidationConfiguration;
//import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.jdom2.JDOMException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

//import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by piyush on 18/5/17.
 */
public class GetListOrders {
    public static String jsonAsString;
    public  static Response response;

    @BeforeClass

    public static void setupURL()  {
        // here we setup the default URL and API base path to use throughout the tests
        RestAssured.baseURI = "http://stagingapi.bizom.in";
        RestAssured.basePath = "/orders/listordersapi";
    }


    public void listOrders(int dataIndex){
        try {


            String fromdate = ReadTestData.readDataByTagName("fromdate", Integer.toString(dataIndex));
            String todate = ReadTestData.readDataByTagName("todate", Integer.toString(dataIndex));
            String startseq = ReadTestData.readDataByTagName("startseq", Integer.toString(dataIndex));
            String endseq = ReadTestData.readDataByTagName("endseq", Integer.toString(dataIndex));
            String responsetype = ReadTestData.readDataByTagName("responsetype", Integer.toString(dataIndex));
            String dateType = ReadTestData.readDataByTagName("dateType", Integer.toString(dataIndex));
            String access_token = "a25f4768905472f6e58634d4cdcc7e5fdee3214d";
           // JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();

            response =
                    (Response) when().
                            get(basePath + '?' + "access_token=" + access_token + '&' + "responsetype=" + responsetype + '&'
                                    + "fromdate=" + fromdate + '&' + "todate=" + todate + '&' + "startseq=" + startseq + '&'
                                    + "endseq=" + endseq + '&' + "dateType=" + dateType).

                            then().



                            //contentType(ContentType.XML).
                                    extract().response();


            jsonAsString = response.asString();
            System.out.println(jsonAsString);

        }
        catch (Exception e){

            System.out.println(e);
        }



    }

    @Test
    public void getTest() throws JDOMException {


        try {
            setupURL();
            listOrders(1);
            if (response.statusCode() != 200) {
                System.out.println("Status code is: " + response.statusCode());
            }
            String contentType = response.header("Content-Type");
            Assert.assertEquals(contentType, "application/json");


            if (jsonAsString.contains("2017-04-04")) {

                System.out.println("matched");
            }

        }
        catch(Exception e){

         //   System.out.println("Content type is notmatching" + "Actual is" + contentType);
            System.out.println(e);
        }
    }

    @Test

    public void checkForNumberOfOrders()
    {
        setupURL();
        listOrders(1);

        // first we put our 'jsonAsString' into an ArrayList of Maps of type <String, ?>
        ArrayList<Map<String,?>> jsonAsArrayList = from(jsonAsString).get("");
        // now we count the number of entries in the JSON file, each entry is 1 ride
        assertThat(jsonAsArrayList.size(), equalTo(2));
    }


    @Test

    public void jsonschemavalidation() throws IOException {
        setupURL();
        listOrders(1);
       // JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        //String schema = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("/src/test/java/bizomapi/ListOrders-schema.json"));
        System.out.println(jsonAsString);

        //  assertThat(jsonAsString, (Matcher<? super String>) matchesJsonSchemaInClasspath("ListOrders-schema.json").using(settings().with().checkedValidation(false)));


    }


}
