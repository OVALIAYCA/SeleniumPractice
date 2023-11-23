package JUnit.BeforeAfterClass;

import org.junit.*;

public class Before_AfterClass_1 {

    @BeforeClass
    public  static void setUp(){
        System.out.println("=================Test İşlmleri Başlatıldı===================");
        System.out.println(" ");
        System.out.println(" ");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=================Test İşlmleri Tamamlandı===================");

    }

    @Before
    public void before(){
        System.out.println("------------------Before-----------------------");
        System.out.println("         Yeni Bir Test Çalıştırılıyor          ");
        System.out.println(" ");
    }
    @After
    public void after(){
        System.out.println(" ");
        System.out.println("------------------After-----------------------");
        System.out.println(" ");

    }

    @Test
    public void test01(){
        System.out.println("1 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test02(){
        System.out.println("2 Numaralı Test Çalıştırılıyor");

    }
    @Test
    public void test03(){
        System.out.println("3 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test04(){
        System.out.println("4 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test05(){
        System.out.println("5 Numaralı Test Çalıştırılıyor");
    }

}
