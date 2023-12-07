package tests.JUnit;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_iFrameTest extends TestBase {

    @Test
    public void iframeTest()
    {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 3- "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeYaziElementi = driver.findElement(By.xpath("//h3[1]"));
        if (anIframeYaziElementi.isDisplayed()){
            System.out.println("Yazı Testi PASSED");
            System.out.println(anIframeYaziElementi.getText());
        }else {
            System.out.println("Yazı Görüntülenemedi");
        }

        // 4- Text Box'a "Merhaba Dunya!" yazin.
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement contentAlan =driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        contentAlan.clear();
        contentAlan.sendKeys("Merhaba Dunya!");


        // 5- TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
        //      ve  konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement elementalYazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        if (elementalYazi.isDisplayed()){
            System.out.println("Link Text Görüntülendi. Test PASSED");
            System.out.println(elementalYazi.getText());
        }else {
            System.out.println("Link Text Görüntülenemedi.");
        }
        //String expectedLinkText = "Elemental Selenium";
        //String actualLinkText = elementalYazi.getText();
        //Assert.assertEquals(expectedLinkText,actualLinkText);




    }
}
