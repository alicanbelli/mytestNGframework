package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    // ****** public class Day12HandlingAlerts extends Day13TestBase ==> class'ina extend yaptim ve
            // public abstract class Day13TestBase ==> abstract yaptim;
            // Dolayisiyla bu class'ta buluna  @BeforeClass () methodu ve  @AfterClass methodunun asagidaki ozellikleri:

            //@BeforeClass
             //    public  void setup(){
             //        WebDriverManager.chromedriver().setup();
             //        driver = new ChromeDriver();
             //        driver.manage().window().maximize();
             //        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //
            //@AfterClass
            //    public void tearDown(){
            //        driver.close();

            //Day12HandlingAlerts class'inda olmamasina ragmen orada problem olmada kullanabildim.

    public WebDriver driver; // protected access modifier'da yapilabilir
                             // protected WebDriver driver; ==> Bu sekilde de olabilir
    protected Actions actions; //Bu class'a extends olan tum classlarda actions class'inin ozelliklerinin kulllanilabilir
 // public 'de olabilir!
    @BeforeClass
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);

    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
