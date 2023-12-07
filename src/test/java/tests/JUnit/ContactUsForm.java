package tests.JUnit;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ContactUsForm {

    //Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully

    //4. Click on 'Contact Us' button
    //5. Verify 'GET IN TOUCH' is visible

    //6. Enter name, email, subject and message
    //7. Upload file
    //8. Click 'Submit' button
    //9. Click OK button
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

    static WebDriver driver;

    @AfterClass
    public static void teardown() {
        driver.quit();
    }


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01() {
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("(//img[@class='girl img-responsive'])[1]"));
        Assert.assertTrue(homePage.isDisplayed());
    }

    @Test
    public void test02() {
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getIn = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getIn.isDisplayed());

    }

    @Test
    public void test03() throws InterruptedException {
        //6. Enter name, email, subject and message
        //input[@class='form-control']
        ReusableMethods.bekle(3);
        driver.findElement(By.xpath("(//input[@class='form-control'])[1]"))
                .sendKeys("Deniz");
        driver.findElement(By.xpath("(//input[@class='form-control'])[2]"))
                .sendKeys("dnzdnz@gmail.com");
        driver.findElement(By.xpath("(//input[@class='form-control'])[3]"))
                .sendKeys("hello world");
        driver.findElement(By.xpath("//textarea[@class='form-control']"))
                .sendKeys("İyi akşamlar");

        /*7. Upload file
        driver.findElement(By.xpath("(//input[@class='form-control'])[5]")).click();
        Thread.sleep(5000); */

        //8. Click 'Submit' button
        driver.findElement(By.name("submit")).click();
        Thread.sleep(2000);

        //9. Click OK button
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        WebElement actualMessage = driver.findElement(By.xpath("//div [@class='status alert alert-success']"));
        String expectedMessage = "Success! Your details have been submitted successfully.";
        String actualMessageStr = actualMessage.getText();
        Assert.assertTrue(expectedMessage.contains(actualMessageStr));

    }
}
