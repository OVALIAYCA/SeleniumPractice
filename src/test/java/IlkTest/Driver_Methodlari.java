package IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver_Methodlari {

    public static void main(String[] args) {


        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        driver.get("https://www.wisequarter.com");

        driver.navigate().to("https://www.amazon.com");


        driver.quit();

    }
}
