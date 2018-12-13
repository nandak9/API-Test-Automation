package ProjectName.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by piyush on 22/3/17.
 */
public class Loginpage {

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "next")
    public WebElement next;

    @FindBy(id = "Passwd")
    public WebElement password;

    @FindBy(id = "signIn")
    public WebElement loginbtn;

}