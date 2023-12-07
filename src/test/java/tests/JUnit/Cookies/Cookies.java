package tests.JUnit.Cookies;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Cookies extends TestBase
{
    @Test
    public void cookiesTesti()

    {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti= driver.manage().getCookies();
        //System.out.print(cookieSeti);
        //kaç cookie olduğunu bu şekilde anlamak zor.
        //foreachloop ile cookie sıralama-yazdırma daha anlaşılır.
        int siraNo = 1;
        for (Cookie each:cookieSeti
             )
        {
            System.out.println(siraNo +". " +each);
            siraNo++;
        }

        //3-Sayfaki cookie sayısının 5'ten büyük olduğunu test edin.
        int expectedCookie = 5;
        int actualCookie = cookieSeti.size();
        Assert.assertTrue(actualCookie>expectedCookie);

        //4-İsmi i18n-prefs olan cookie değerinin USD olduğunu test edin.
        String expectedValue = "USD";
        String actualCookiValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(expectedValue,actualCookiValue);

        //5-İsmi 'en sevdiğim cookie' ve değeri 'çikolatalı'olan bir
        //cookie oluşturun ve sayfaya ekleyin.
        Cookie yeniCookie = new Cookie("en sevdiğim cookie","çikolatalı");
        driver.manage().addCookie(yeniCookie);


        //6- Eklediğiniz cooki'nin sayfaya eklendiğini test edin.

        cookieSeti = driver.manage().getCookies();
        Assert.assertTrue(cookieSeti.contains(yeniCookie));

        //siraNo = 1;
        // for (Cookie each:cookieSeti
        // )
        //{
        // System.out.println(siraNo +". " +each);
        //siraNo++;
        // }

        /*if (cookieSeti.contains(yeniCookie)){
            System.out.println("yeni cookie eklendi");
        }else {
            System.out.println("yeni cookie eklenmedi.");
        }*/



        //boolean yeniCookieEklendiMi = false;










    }
}
