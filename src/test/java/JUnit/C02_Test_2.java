package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Test_2 {

        /**
BeforeClass ile driver'i oluşturun ve class icinde static yapin
Maximize edin ve 10 sn bekletin
http://www.babayigit.net/testdocs adresine gidin
1-arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin
4-arama kutusuna "3 idiots" yaz ip, cikan sonuc şayisini yazdirin
AfterClass ile kapatin.
     */
    static WebDriver driver;
    WebElement searchbox;
    String filmName;


    @BeforeClass
    public static void setUP(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Before
    public void before(){
        driver.get("http://www.babayigit.net/testdocs");
        searchbox=driver.findElement(By.xpath("//input[@id='search']"));
    }

    @After
    public void after(){
        System.out.println(filmName+" Sonuç Sayısı: "+driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
        System.out.println("Window Handle : "+driver.getWindowHandle());

    }

    @Test
    public void test01(){
        filmName="12 Angry Men";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    @Test
    public void test02(){
        filmName="Vizontele";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    @Test
    public void test03(){
        filmName="Saving private er ryan";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    @Test
    public void test04(){
        filmName="3 idiots";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }
}
