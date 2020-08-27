package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day11Soft_Hard_Assertion {

    //Class name : Soft_Hard_Assertion
    //http://a.testaddressbook.com/sign_in adresine gidin.
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra assertions kullanarak testtechproed@gmail.com kullanıcı kimliğinin(userID) doğrulayın

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }
    @Test
    public void login(){
        WebElement emailBox = driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        driver.manage().window().maximize();
    }
    @Test(dependsOnMethods = "login")
    public void homePage(){

        //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
        System.out.println(welcomeMessage.getText());
        Assert.assertTrue(welcomeMessage.isDisplayed());  //HARD ASSERT  //pass
        System.out.println("Hard assert fail olursa bu satir calismayacak.");

        //SOFT ASSERT
        //1.Adim : create object
        SoftAssert softAssert = new SoftAssert();
        //2.Adim: assretion icin kullanidigimiz objecti kullan!
        softAssert.assertTrue(welcomeMessage.isDisplayed());
        //3.Adim: softAssert.assertAll();
        //softAssert.assertAll();==> asagidaki gorev ile ilgil' softAssert.assertAll(); kullanildigindan ve
                    //method'ta bir tane softAssert.assertAll(); yeterli oldugundan burada command ettik

        //Daha sonra assertions kullanarak testtechproed@gmail.com kullanıcı kimliğinin(userID) doğrulayın
        WebElement userID = driver.findElement(By.className("navbar-text"));
        String actualID = userID.getText();
        String expectedID = "testtechproed@gmail.com";
        Assert.assertEquals(actualID,expectedID); //Hard assert

        //SOFT ASSERT
        //yukarda object creat ettigimizden burada tekrar yapmaya gerek yok
        softAssert.assertEquals(actualID,expectedID);
        //3.Adim: softAssert.assertAll();
        softAssert.assertAll();//Bu satir cok onemli
                            //assertAll(), gercek assertion'i yapar.
                            //assertAll() yazilmazsa test fail olmasi gerektiginde de pass olur

    }
}
// "Hard Assert" kullandigimizda bir fail/hata alinca geriye kalani test etmez.
// Eger biz bir hata oldugunda hemen sonucu ogrenmek istiyorsak bunu kullaniriz.
// "Soft Assert" ise hata bulsa da sonuna kadar devam eder hepsini test eder ve
// sonuc olarak daha ayrintili rapor verir.
// "Soft Assert"  icin ilk once obje olusturmak zorundayiz. (SoftAssert class'inda)
// 1.Adim SoftAssert softAssert = new SoftAssert();
// 2.Adim softAssert.assertTrue();
// 3.Adim softAssert.assertAll(); asil test yapan kisim.
