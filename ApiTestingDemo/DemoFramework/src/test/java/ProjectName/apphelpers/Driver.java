package ProjectName.apphelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by piyush on 6/3/17.
 */
public class Driver {

    public  static WebDriver driver;



    @BeforeMethod
    public void beforemethod(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void aftermethod(){

        //driver.quit();

    }

}
