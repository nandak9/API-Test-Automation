package ProjectName.apphelpers;

import ProjectName.pagefactory.composeEmail;
import org.jdom2.JDOMException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by piyush on 20/3/17.
 */
public class CreateEmail extends Driver {

    public void composeEmail(int dataIndex) {
        composeEmail create = PageFactory.initElements(driver,composeEmail.class);

        try {
            String emailTo = ReadTestData.readDataByTagName("emailTo", Integer.toString(1));
            String subject = ReadTestData.readDataByTagName("subject", Integer.toString(1));

            create.compose.click();
            create.emailTo.sendKeys(emailTo);
            create.subject.sendKeys(subject);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
