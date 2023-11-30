package JUnit.Cookies;

import Utilities.TestBase;
import org.junit.Test;

public class Cookies extends TestBase
{
    @Test
    public void cookiesTesti()

    {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        driver.manage().getCookies();

    }
}
