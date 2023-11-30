package JUnit;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.ui.Select;

import javax.print.DocFlavor;
import java.time.Duration;

public class RegisterUserTest {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
   10. Select checkbox 'Sign up for our newsletter!'
   11. Select checkbox 'Receive special offers from our partners!'
   12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
   13. Click 'Create Account button'
   14. Verify that 'ACCOUNT CREATED!' is visible
   15. Click 'Continue' button
   16. Verify that 'Logged in as username' is visible
   17. Click 'Delete Account' button
   18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

  static WebDriver driver;

   @BeforeClass
   public static void setup()
   {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //2. Navigate to url 'http://automationexercise.com'
      driver.navigate().to("http://automationexercise.com");

   }
   @AfterClass
   public static void teardown()
   {
      driver.quit();
   }

   @Test
   public void registerUserTesti()
   {
     Faker faker = new Faker();


     // Verify that home page is visible successfully
      WebElement homePage = driver.findElement(By.xpath("(//img[@class='girl img-responsive'])[1]"));
      Assert.assertTrue(homePage.isDisplayed());

     //Click on 'Signup / Login' button
     driver.findElement(By.partialLinkText("Login")).click();

     //Verify 'New User Signup!' is visible
      WebElement newUserText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
      String expectedYazi = "New User Signup!";
      String actualYazi = newUserText.getText();
      Assert.assertEquals(expectedYazi,actualYazi);

      //Assert.assertTrue(newUserText.isDisplayed());

       //Enter name and email address
       String firstlName = faker.name().firstName();
       String lastName = faker.name().lastName();
       String email = faker.internet().emailAddress();
      driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstlName + " " + lastName);
      driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);
      //dinamik hale geldi fakerclass ile.

     //Click 'Signup' button
     driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")) .click();

     // Verify that 'ENTER ACCOUNT INFORMATION' is visible
      WebElement eaiYazi = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
      String expectedEnterAccountYazi = "ENTER ACCOUNT INFORMATION";
      String actualEnterAccountYazi = eaiYazi.getText();
      Assert.assertEquals(expectedEnterAccountYazi,actualEnterAccountYazi);
      //Assert.assertTrue(eaiYazi.isDisplayed());


     //Fill details: Title, Name, Email, Password, Date of birth
      driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
      driver.findElement(By.xpath("//input[@id='name']")).clear();
      driver.findElement(By.xpath("//input[@id='name']")).sendKeys("İhsan");
      driver.findElement(By.xpath("//input[@id='password']")).sendKeys("kola");

      //Date of birth
       WebElement days = driver.findElement(By.xpath("//*[@id='days']"));
       Select selectDays = new Select(days);
       selectDays.selectByValue("5");

       WebElement months = driver.findElement(By.xpath("//*[@id='months']"));
       Select selectMonths = new Select(months);
       selectMonths.selectByValue("1");

       WebElement years = driver.findElement(By.xpath("//*[@id='years']"));
       Select selectYears = new Select(years);
       selectMonths.selectByValue("1990");

      //driver.findElement(By.xpath("//option[@value='1']")).click();
      //driver.findElement(By.xpath("(//option[@value='5'])[2]")).click();
      //driver.findElement(By.xpath("//option[@value='1990']")).click();


     //Select checkbox 'Sign up for our newsletter!'
      driver.findElement(By.id("newsletter")).click();
     //Select checkbox 'Receive special offers from our partners!'
     driver.findElement(By.id("optin")).click();

     //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
      driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("İhsan");
      driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Altunışık");
      driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Bilgi University");
      driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Istanbul");
      driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(  "Zeytinburnu");
      driver.findElement(By.xpath("//option[text()='United States']")).click();
      driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Marmara");
      driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Istanbul");
      driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("34000");
      driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("5555555555");

      //Click 'Create Account button'
      driver.findElement(By.xpath("//button[text()='Create Account']")).click();

      //Verify that 'ACCOUNT CREATED!' is visible
      WebElement account =driver.findElement(By.xpath("//b[text()='Account Created!']"));
      Assert.assertTrue(account.isDisplayed());

      //Click 'Continue' button
      driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

      //Verify that 'Logged in as username' is visible
      WebElement logged = driver.findElement(By.xpath(" //li[10]"));
      Assert.assertTrue(logged.isDisplayed());

      //Click 'Delete Account' button
       driver.findElement(By.xpath(" //li[5]")).click();

      //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
      WebElement delete = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
       Assert.assertTrue(delete.isDisplayed());

       driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();


   }
}
