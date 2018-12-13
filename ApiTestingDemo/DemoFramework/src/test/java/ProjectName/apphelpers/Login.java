package ProjectName.apphelpers;

import ProjectName.pagefactory.Loginpage;
import ProjectName.utility.Properties;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by piyush on 14/3/17.
 */
public class Login extends Driver {


    public void login()  {
        try {


            Loginpage signin = PageFactory.initElements(driver, Loginpage.class);
            String currentDir = System.getProperty("user.dir");
            String configFile = currentDir + "/src/test/java/ProjectName/resources/setting.properties";
            Properties.loadPropertiesFile(configFile);
            String url = Properties.getPropertyValue("baseURL");
            System.out.println(url);
            String userName = Properties.getPropertyValue("userName");
            String password = Properties.getPropertyValue("password");

            driver.get(url);
            signin.email.sendKeys(userName);
            signin.next.click();
            signin.password.sendKeys(password);
            signin.loginbtn.click();
            Thread.sleep(5000);

        } catch (Exception e) {

          e.printStackTrace();

            }
    }

}

