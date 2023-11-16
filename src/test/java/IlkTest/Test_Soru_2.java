package IlkTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Soru_2 {

    public static void main(String[] args) throws InterruptedException {


        /*
         ...Exercise3...
      Navigate to  https://testpages.herokuapp.com/styled/index.html
      Click on  Calculater under Micro Apps
      Type any number in the first input
      Type any number in the second input
      Click on Calculate
      Get the result
      Print the result
         */

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //genel ayarlar. mutlaka yapılmalı, sağlıklı test için.


    driver.get("https://testpages.herokuapp.com/styled/index.html");
    Thread.sleep(2000);
    //verilen adrese gittik

    //driver.findElement(By.id("calculatetest")).click();
    driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
    //bu ikisi aynı işlemi yapacak.Locate alındı.

    driver.findElement(By.id("number1")).sendKeys("136");
    //birinci kutuya değer gönderdik

    driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("123");
    //ikinci kutuya değer gönderdik

    driver.findElement(By.id("calculate")).click();
    //hesapla butonuna bastık

    WebElement answer = driver.findElement(By.id("answer"));
    //sonucu bir webelemente atadık

    System.out.println("İşlem Sonucu : " + answer.getText());

    //System.out.println("İşlem Sonucu : " + driver.findElement(By.id("answer")).getText());
        //Bu da webelemente atama ve yazdırma işlemini tek basamakta yapar, aynı sonucu verir.
    //sonucu yazdırmak için .getText() yapılmalı. Yoksa referans yazdırır.


    //kapamayı unutma.
    driver.quit();




    }
}
