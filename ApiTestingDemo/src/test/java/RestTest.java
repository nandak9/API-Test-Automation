/**
 * Created by bhanu_prakash on 23/11/15.
 */


        import static com.jayway.restassured.RestAssured.get;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import com.jayway.restassured.response.Response;

public class RestTest {

    @Test
    public void getRequestFindCapital() throws JSONException {

        //make get request to fetch capital of norway
        Response resp = get("http://10.0.0.52/");

        //Fetching response in JSON
        JSONArray jsonResponse = new JSONArray(resp.asString());

        //Fetching value of capital parameter
        String capital = jsonResponse.getJSONObject(0).getString("capital");

        //Asserting that capital of Norway is Oslo
        Assert.assertEquals(capital, "Oslo");
    }

}

