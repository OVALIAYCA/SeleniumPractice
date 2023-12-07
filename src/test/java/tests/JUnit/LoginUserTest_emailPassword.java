package tests.JUnit;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginUserTest_emailPassword extends TestBase {

   @Test
    public void loginUserTest()
   {

   //1. Launch browser
   //2. Navigate to url 'https://automationexercise.com'
       driver.get("https://automationexercise.com");

   //3. Verify that home page is visible successfully
       String expectedTitle = "Automation Exercise";
       String actualTitle = driver.getTitle();
       Assert.assertEquals(expectedTitle,actualTitle);

   //4. Click on 'Signup / Login' button
       driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

   //5. Verify 'Login to your account' is visible
       WebElement login = driver.findElement(By.xpath("(//h2)[1]"));
       Assert.assertEquals("Login to your account",login.getText());

       //String expectedLogin = "Login to your account";
       //String actualLogin = login.getText();



   //6. Enter correct email address and password
       driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("dkdk@dkdk.com");
       driver.findElement(By.xpath("//*[@name='password']")).sendKeys("kola");

   //7. Click 'login' button
       driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();

   //8. Verify that 'Logged in as username' is visible
       
       Assert.assertEquals("Logged in as dkdkdk",driver.findElement(By.xpath("//*[text()=' Logged in as ']")).getText());

   //9. Click 'Delete Account' button

       driver.findElement(By.xpath(" //*[text()=' Delete Account']")).click();

   //10. Verify that 'ACCOUNT DELETED!' is visible
       WebElement deletedYazi = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
       String expectedYazi = "ACCOUNT DELETED!";
       String actualYazi = deletedYazi.getText();
       Assert.assertEquals(expectedYazi,actualYazi);


   }
}


