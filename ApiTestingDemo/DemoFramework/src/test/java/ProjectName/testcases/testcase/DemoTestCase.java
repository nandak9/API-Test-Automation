package ProjectName.testcases.testcase;

import ProjectName.apphelpers.CreateEmail;
import ProjectName.apphelpers.Driver;
import ProjectName.apphelpers.Login;
import org.testng.annotations.Test;

/**
 * Created by piyush on 15/3/17.
 */
public class DemoTestCase extends Driver  {

   @Test
  public void homepage(){

     try {
         System.out.println("Test Starts");
         new Login().login();
         new CreateEmail().composeEmail(1);

     }
     catch (Exception e){

         System.out.println(e.getStackTrace());


     }



  }




}
