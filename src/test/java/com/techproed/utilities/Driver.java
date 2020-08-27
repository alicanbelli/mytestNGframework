package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
//    Driver class, driver intance'i baslatmak icin kullanilir. (Singleton Driver = tek bir tane)
//    Ihtiyacimiz oldugunda driver'i kurmak ve baslatmak icin kullaniyoruz.
//    Drevir null oldugunda create edip baslatacagiz. (if driver == null == driver henuz olusturulmamis)//
//    Driver class'i farkli browser'lar ile de kullanacagimiz seklinde olusturacagiz

    private Driver(){ //Constructor
        //Baska obje olusturulmasini istemedigimiz icin private create ediyoruz.

    }

    // driver instance olusturalim
    static WebDriver driver; // ==> diger class'lardan kullanabilmek icin statik yaptik

    public static WebDriver getDriver(){ // driver'i baslatmak icin static bir method olusturulalim.
        if (driver==null){ //Eger driver henuz olusturulmadiysa olustur diyoruz.
            switch (ConfigReader.getProperty("browser")){  // ConfigReader class'indan value'leri
                case "chrome":                                                          // alip, okuyoruz
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        return driver; //driver'i return edilmeli
    }

    public static void closeDriver(){
        if (driver!= null){ // eger driver chrome'u isaret ediyorsa driver'i kapat
            driver.quit();
            driver=null; // driver'in null oldugyundan emin olmak icin tekrar null olarak atayalim.
        }                // boylelikle driver'i tekrar baslatabilirim.
    }                    // Multi Browser Test(chrome, firefox,ie, vb.) yaparken bu onemli!
}                        //yukardaki aciklama neden null yapiyoruz? sorusunun cevabi...


// *****  driver'i diger class'larda kullanabilmek icin ==> driver.getDriver() <== method'u kullanilmali.