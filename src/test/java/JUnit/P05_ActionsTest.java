package JUnit;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P05_ActionsTest extends TestBase {

    @Test
    public void actionsTest()
    {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
        WebElement dragMeElementi = driver.findElement(By.id("draggable"));

        WebElement dropHereElementi = driver.findElement(By.id("droppable"));
        ReusableMethods.bekle(2);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();
        ReusableMethods.bekle(2);
        //actions sonlarına perform eklemeyi unutma!


        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin
        WebElement droppedTextElementi = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedText = "Dropped!";
        String actualText = droppedTextElementi.getText();
        Assert.assertEquals(expectedText,actualText);

    }
}
