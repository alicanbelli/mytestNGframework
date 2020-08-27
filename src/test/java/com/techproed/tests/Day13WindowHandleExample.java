package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day13WindowHandleExample extends TestBase {   // !!! DIKKAT bu class ====> "extends"

    //Tests package’inda yeni bir class olusturun: WindowHandleExample
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
    //Sayfadaki textin   “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.

    @Test
    public void newWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();//getWindowHandle(); ==> String return eder.
                                                            // ileride ihtiyacim var diye burada tanimliyorum
        System.out.println("PARENT WINDOW HANDLE => "+parentWindowHandle);


        //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        String actualtextElement = driver.findElement(By.xpath("//h3")).getText();
        String expectedtextElement = "Opening a new window";
        Assert.assertEquals(actualtextElement,expectedtextElement);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);

        //Click Here butonuna basın.
        WebElement button = driver.findElement(By.linkText("Click Here"));
        button.click();
        //veya bir asagidaki kod ile de direkt click() yapabilirim.
        // driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
                            // !!!DIKKAT!!!
                            //Yeni sayfa basligi var
                            //Bunu Set<> ile
                            //Bunu yapmazsak driver ilk sayfanin basligini gorecek hep!
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String  childWindwHandle: allWindowHandles){ //for each loop karsilastiriyoruz
            if (!childWindwHandle.equals(parentWindowHandle)){//Ikinci sayfanin Title'si ilk sayfanin Title'sine esit degilse
                driver.switchTo().window(childWindwHandle);     // ikinci sayfanin Title'sini run et! demek
                System.out.println("CHILD WINDOW HANDLE => " +childWindwHandle);
            }
        }
        String actualNewTitle = driver.getTitle();
        Assert.assertEquals(actualNewTitle,"New Window"); //Bu sekilde de olur yada asagidaki sekilde de
            // String expectedNewTitle = "New Window";
            // Assert.assertEquals(actualNewTitle,expectedNewTitle);

        //Sayfadaki textin   “New Window” olduğunu doğrulayın.
        String newWindowText = driver.findElement(By.xpath("//h3")).getText(); //Bu sekilde de locate edilir
        Assert.assertEquals(newWindowText,"New Window");

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
                                                //Sayfanin tekrar parent page'e donmesi gerekiyor. Bunun icin;
        driver.switchTo().window(parentWindowHandle); // ilk basta creat etmistik. Bununla Parent Page'e gectik
        // Assert.assertEquals(actualTitle,expectedTitle); ===> veya asagidaki sekilde yapabiliriz
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }
}
