package ProjectName.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by piyush on 20/3/17.
 */
public class composeEmail {

    @FindBy(className = "z0")
    public WebElement compose;

    @FindBy(name = "to")
    public WebElement emailTo;

    @FindBy(name = "subjectbox")
    public WebElement subject;


}
