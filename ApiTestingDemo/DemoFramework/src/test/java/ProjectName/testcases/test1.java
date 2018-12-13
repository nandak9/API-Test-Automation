package ProjectName.testcases;

import ProjectName.apphelpers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by piyush on 6/3/17.
 */
public class test1 extends Driver {


     @Test(priority = 1)

             public void testmethod() {


         driver.get("http://www.google.com");
     }
    }


