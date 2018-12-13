package ProjectName.utility;

import org.apache.http.util.Asserts;
import org.testng.Assert;

/**
 * Created by piyush on 6/3/17.
 */
public class CustomAssert {
    public static void assertEquals(String actual, String expected, String step, String assertMessage) {
        if (actual.equals(expected)) {
            System.out.print(step +"Pass");
           // ReportUtil.log(step, LogDetail, "pass");
        } else {
            //ReportUtil.log(step, assertMessage, "fail");
            Assert.assertEquals(actual, expected,assertMessage);

        }

    }
}
