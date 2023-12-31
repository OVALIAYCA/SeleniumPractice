package tests.JUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01_Test_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        1. “https://www.saucedemo.com” Adresine gidin
        2. Username kutusuna “standard_user” yazdirin
        3. Password kutusuna “secret_sauce” yazdirin
        4. Login tusuna basin
        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        6. Add to Cart butonuna basin
        7. Alisveris sepetine tiklayin
        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        9. Sayfayi kapatin
         */

        driver.get("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]"));
        String ilkUrunIsim = ilkUrun.getText();
        System.out.println("ilk ürün : " + ilkUrunIsim);
        ilkUrun.click();
        //Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Thread.sleep(2000);

        driver.findElement(By.className("shopping_cart_link")).click();
        //Thread.sleep(2000);

        WebElement sepeteEklenen = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue(sepeteEklenen.isDisplayed());

        //sepeteEklenen.isDisplayed();
        //System.out.println("Ürün sepete eklendi mi ? : " + sepeteEklenen.isDisplayed());
        //Thread.sleep(2000);

        driver.quit();

    }
}
