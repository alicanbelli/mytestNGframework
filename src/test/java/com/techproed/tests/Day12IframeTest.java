package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12IframeTest {
    //Bir class olusturun: IframeTest
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest
    //“An IFrame containing….” textini konsolda yazdirin.
    //Text Box’a “Merhaba Dunya!” yazin.
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");


    }
    @Test
    //Bir metod olusturun: iframeTest
    public void iframeTest(){
     WebElement iframeTest = driver.findElement(By.xpath("//h3"));
        System.out.println(iframeTest.getText());

        //WebElement texBox = driver.findElement(By.xpath("//p")); //Test FAIL oldu
        //texBox.sendKeys("Merhaba Dunya!"); FAIL oldu. Yazdirmadi

        // ******  Test FAIL olursa ne yapmaliyiz?  ******
        //       1. Locator kontrol edilmeli,
        //       2. Wait(Bekleme) problemi var mi? kontrol edilmeli,
        //       3. Sayfada Iframe var mi yok mu? kontrol edilmeli

        //Bu sayfada Iframe var. Dolayisiyla Iframe switchTo() yapmaliyiz.

        // ***** Bir Iframe switch yapmanin 3 yolu vardir *****;
        //  1. index ile
        //  2. id veya name value ile
        //  3. WebElement ile

        //1.    driver.switchTo().frame(0); // ==> Iframe'de index'ler 0'dan basliyor. ==> 1.Bu index ile gider
        //2.    driver.switchTo().frame("mce_0_ifr");                               ==> 2.Bu id value gider
        WebElement frameElement = driver.findElement(By.id("mce_0_ifr")); //    ==> 3.webElement ile gider
        driver.switchTo().frame(frameElement); //

        //Artik Iframe icindeki elementi bulabiliriz
        WebElement texBox = driver.findElement(By.xpath("//p"));
        texBox.clear(); // ==> Textin icindeki yaziyi sildirir
        texBox.sendKeys("Merhaba Dunya!");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        //***** once iframe'den cikip parentFrame() gelmemiz gerekiyor.
        driver.switchTo().parentFrame();  //parentFrame(); ==> Bir ust page'e(Parent) goturur
     // driver.switchTo().defaultContent(); ==> Bu kod'da yukardaki ile ayni islevi goruyor. Ama en ust page goturur

        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());

        // parentFrame();   ==> Bir ust page'e(Parent) goturur
        // defaultContent();==> en ust page'e goturur. Mesela bulundugumuz sayfa ic ice gecmis 4 sayfadan olusmussa en dis
        // page'e cikmak icin defaultContent(); kullanilir. Ama sadece bir ust page'e cikmak icin parentFrame() yeterli!

    }

}
