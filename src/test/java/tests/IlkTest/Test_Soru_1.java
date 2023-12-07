package tests.IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Soru_1 {

    public static void main(String[] args) throws InterruptedException {

    /*
     . .Exercise2...
     1-Driver oluşturalim
     2-Java class'imiza chnomedriver.exet i tanitalim
     3-Driver'in tum ekranı kaplamasini saglayalim
     4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
     5-"https://www.otto.de” adresine gidelim
     6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
     7-Title ve url inin "OTTO” kelimesinin içerip icermedigini kontrol edelim
     8-Ardindan "https://wisequarter.com/” adresine gidip
     9-BU adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim
     10-Bir onceki web sayfamiza geri donelim
     11-Sayfayı yenileyelim
     12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim

     */


        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get("https://www.otto.de");
        Thread.sleep(3000);
        String ottoTitle = driver.getTitle(); //başlık getirdi,istersek yazdırabiliriz.
        System.out.println("Tittle  : " + ottoTitle);

        String ottoUrl = driver.getCurrentUrl(); // url getirdi,istersek yazdırabiliriz.
        System.out.println("Url : " + ottoUrl);

        //Title ve url inin "OTTO” kelimesinin içerip icermedigini kontrol edelim
        //bize istek kısmında ve dediği için birlikte kontrol ederiz.Kendi yorumunu katma!

        if (ottoTitle.contains("OTTO")&&ottoUrl.contains("OTTO")){
            System.out.println("Tittle ve URL için içerik testi PASSED");
        }else System.out.println("Tittle ve URL için içerik testi FAILED");


        System.out.println("--------------------------------------------");

        driver.navigate().to("https://wisequarter.com"); //sonrasında diğer siteye git dedik
        Thread.sleep(3000);
        String wqTitle = driver.getTitle(); //başlığı aldık.

        //BU adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim

        boolean kelime = wqTitle.contains("Quarter");
        if (kelime){
            System.out.println("WISE QUARTER TITLE TEST PASSED");
        }else {
            System.out.println("WISE QUARTER TITLE TEST FAILED");
        }

        //Thread.sleep(2000);
        driver.navigate().back(); //bir önceki siteye dön
        //Thread.sleep(2000);
        driver.navigate().refresh(); //sayfayı yenile

        driver.navigate().forward(); // bir sonraki sayfaya git.


        System.out.println("---------Test Tamamlandı");

        driver.quit();
    }
}
