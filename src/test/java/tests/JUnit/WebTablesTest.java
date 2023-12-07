package tests.JUnit;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesTest extends TestBase
{
        /*
       //1."https://testotomasyonu.com/webtables" adresine gidin
       //2.Web table tum body'sini yazdirin
       //3.Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
       //4.Web table'daki satir sayisinin 5 oldugunu test edin
       //5.Tum satirlari yazdirin
       //6.Web table'daki sutun sayisinin 4 olduğunu test edin
       //7.3.sutunu yazdirin
       //8.Tablodaki basliklari yazdirin
       //10.  4.satirdaki category degerinin "Furniture" oldugunu test edin
     */

    @Test
    public void webTablesTest()
    {
        driver.get("https://testotomasyonu.com/webtables");

        //Web table header ve tum body'sini yazdirin
        WebElement tableHeader = driver.findElement(By.xpath("//table/thead"));
        System.out.println(tableHeader.getText());

        System.out.println("================================================");

        WebElement tableBody = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(tableBody.getText());


        // Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik = "Comfortable Gaming Chair";
        String actualIcerik = tableBody.getText();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        //Web table'daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleri = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 5;
        int actualSatiSayisi = satirElementleri.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatiSayisi);

        //Tum satirlari yazdirin
        for (int i = 0; i < satirElementleri.size(); i++)
        {
            System.out.println(i+1 +".satır elemanları" + satirElementleri.get(i).getText()+"\n");
        }

        //Web table'daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> sutunElementleriList = driver.findElements(By.xpath("//thead/tr/th"));
        int expectedSutunSayisi = 4;
        int actualSutunSayisi = sutunElementleriList.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementList = driver.findElements(By.xpath("//td[3]"));
        for (int i = 0; i < ucuncuSutunElementList.size(); i++) {
            System.out.println(i+1 +".satır 3. sütun elemanı " + ucuncuSutunElementList.get(i).getText());
        }

        //Tablodaki basliklari yazdirin
        List<WebElement> tabloBaslikElementleriList = driver.findElements(By.xpath("//thead/tr/th"));
        System.out.println("Başlık Elementleri :");
        for (int i = 0; i <tabloBaslikElementleriList.size() ; i++) {
            System.out.println(i+1+".eleman" + tabloBaslikElementleriList.get(i).getText());

        }

        // 4.satirdaki category degerinin "Furniture" oldugunu test edin
        System.out.println(hucreDegeriniGetir(4,2));
        String expectedCell = "Furniture";

        String actualCell = hucreDegeriniGetir(4,2);

        Assert.assertEquals(expectedCell,actualCell);

        //bir method oluşturduk ve onu dinamik hale getirdik.






    }

    public String hucreDegeriniGetir(int satir, int sutun)
            //   //tbody/tr[4]/td[2]
    {
        String xpathAddress = "//tbody/tr["+satir+"]/td["+sutun+"]";
        WebElement selectElement = driver.findElement(By.xpath(xpathAddress));

        return selectElement.getText();
    }

}
