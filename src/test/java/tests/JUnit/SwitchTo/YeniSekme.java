package tests.JUnit.SwitchTo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YeniSekme {




              /*
        1- www.google.com adresine gidilir
        2- sayfanın title ve Url değerleri yazdırılır
        3- yeni bir sekme açılarak www.wisequarter.com adresine gidilir
        4- gidilen sayfanın title ve url değerleri yazdırılır
        5- ilk sekmeye geçilip, burada www.testotomasyonu.com adresine gidilir
        6- gidilen sayfanın title ve url değerleri yazdırılır
        7- açılan pencere kapatılır.

         */
        static WebDriver driver;
        @BeforeClass
        public static void setup()
        {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}

        @AfterClass
        public static void teardown()
        {
            driver.quit();
        }

        @Test
        public void test() throws InterruptedException {
        String ht="https://www.";


        //   1- www.google.com adresine gidilir
        driver.get(ht+"google.com");

        //sayfanın title ve Url değerleri yazdırılır
        System.out.println("1.Site URL= "+driver.getCurrentUrl());
        System.out.println("1.Site Title= "+driver.getTitle());
        System.out.println("1. Site Handle: " + driver.getWindowHandle());//4F5F7F3B0ADC65D9405FC64A1475E58E
        String handle= driver.getWindowHandle(); //ilk açılan sekmenin handle degerini bir variable yaptık

        driver.navigate().refresh();
        System.out.println("1. Site Refresh Sonrası Handle(2): " + driver.getWindowHandle()); //Pencerenin handle numarasıdır.
        //Her pencere açışta değişir.


        //yeni bir sekme açılarak www.wisequarter.com adresine gidilir
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(ht+"wisequarter.com");

        //gidilen sayfanın title ve url değerleri yazdırılır
        System.out.println("2.Site URL= "+driver.getCurrentUrl());
        System.out.println("2.Site Title= "+driver.getTitle());
        System.out.println("2. Sekme Handle = " + driver.getWindowHandle());
        String handle2= driver.getWindowHandle();
        System.out.println("Tüm Sekmeler: "+driver.getWindowHandles());
                Thread.sleep(3000);
        //İlk sekmeye dönmek için o sekmenin handle variable'ı kullanılır.BURASI ÖNEMLİ!
        driver.switchTo().window(handle);
        driver.get(ht+"testotomasyonu.com");
        System.out.println("3.Site URL= "+driver.getCurrentUrl());
        System.out.println("3.Site Title= "+driver.getTitle());
        System.out.println("3. Siteyi açtığımız (ilk) Sekme Handle = " + driver.getWindowHandle());
        Thread.sleep(3000);
        //2. sekmeye dönmek için 2. sekmenin handle degeri kullanılır
        driver.switchTo().window(handle2);
        driver.get("http://www.babayigit.net");

        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni bir pencere açıp orada işlem yapıyor.
        System.out.println("Sekme Handle = " + driver.getWindowHandle());
                Thread.sleep(3000);
        driver.get(ht+"wisequarter.com");
        driver.switchTo().window(handle);
                Thread.sleep(3000);
        driver.navigate().to(ht+"amazon.com");
        System.out.println("Sekme Handle = " + driver.getWindowHandle());


        Thread.sleep(2000);


        }


}

