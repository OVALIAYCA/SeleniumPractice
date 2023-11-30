package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P06_DosyaYuklemeTest extends TestBase
{
    @Test
    public void dosyaYukleme()
    {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //Bilgisayarımızdaki herhangi bir dosyayı buraya yükleyelim
        WebElement chooseFile= driver.findElement(By.id("file-upload"));

        //WebElement chooseFile= driver.findElement(By.id("drag-drop-upload"));

        String dosyaYolu="/Users/aycaergunovali/Downloads/logo.png";
        chooseFile.sendKeys(dosyaYolu);
        ReusableMethods.bekle(3);

        driver.findElement(By.id("file-submit")).click();

        WebElement fileUploaded= driver.findElement(By.xpath("(//h3)[1]"));

        Assert.assertTrue("File Uploaded",fileUploaded.isDisplayed());
        ReusableMethods.bekle(3);

    }
}
