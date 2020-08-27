package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14ActionsClassExample extends TestBase {

    //1.Create  class: ActionsClassExample
    //2.Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //3.https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //4.Dikdörtgen kutu icinde sağa tıklayın.
    //5.Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //6.Alert’te OK ye basin

    @Test(groups = "group test1")
    public void contextClickMethod(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //4.Dikdörtgen kutu icinde sağa tıklayın.
        //create actions()
        WebElement dikdortgen = driver.findElement(By.id("hot-spot")); // ==> once locate ediyoruz
        //Actions actions = new Actions(driver);    ==> Actions Class'i TestBase() class'ina tasidim
                                                    //==> artik actions'u drive gibi kullanabilirim
        actions.contextClick(dikdortgen).perform(); //

        //5.Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
        String actualMesageText = driver.switchTo().alert().getText();
        String expectedMesageText = "You selected a context menu";
        Assert.assertEquals(actualMesageText,expectedMesageText);

        //6.Alert’te OK ye basin
        driver.switchTo().alert().accept();

    }

    //Create  test method : hoverOver() ve aşağıdaki senaryoyu test edin:
    //https://www.amazon.com/  web sitesine gidin.
    //“Your Account” linkine tıklayın.
    //Sayfa basliginin(page title) “Your Account) icerdigini(contains) dogrulayin.

    @Test(groups = "group test1")
    public void hoverOver(){

        //https://www.amazon.com/  web sitesine gidin.
        driver.get("https://www.amazon.com/");

        //“Your Account” linkine tıklayın.
        WebElement helloSignIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(helloSignIn).perform(); // *** moveToElement()
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();

        //Sayfa basliginin(page title) “Your Account" icerdigini(contains) dogrulayin.
        String actualTitle = driver.findElement(By.tagName("h1")).getText();
        Assert.assertTrue(actualTitle.contains("Your Account"));


    }

    @Test(groups = "group test1")
    public void keysUpDown(){
        //https://www.google.com/ adresine gidin.
        //Google text box’a IPHONE (capital) yazdirin
        //( input(giris) => iphone , output => IPHONE)
        //Text box’ta cift tiklayin(double click).

        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));


        //Google text box’a IPHONE (capital) yazdirin
        //( input(giris) => iphone , output => IPHONE)

        // ***** BUYUK HARF icin ****
        // 1.YOL : ===>
       // searchBox.sendKeys(Keys.SHIFT+"iphone");

        // 2.YOL : ===>
        searchBox.sendKeys("iphone".toUpperCase());

        // 3.YOL : ===>
       // actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("iphone").perform();

        actions.
                keyDown(searchBox,Keys.SHIFT).sendKeys("iphone").keyUp(searchBox,Keys.SHIFT).perform();
                                      // Bununla buyuk yazma modundan kucuk yazmaya geciyoruz. keyUp()

        //Text box’ta cift tiklayin(double click).
        actions.doubleClick(searchBox).perform();
    }

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        //Sayfayi asagi dogru kaydirma.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        actions.sendKeys(Keys.ARROW_DOWN).perform(); // ARROW_DOWN'le PAGE_DOWN'a gore Sayfa daha az iniyor
        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_UP); //Ssayfa yukari cikar
        Thread.sleep(3000);

        actions.sendKeys(Keys.ARROW_UP); //Sayfayi PAGE_UP gore daha az yukari kaydirir
        Thread.sleep(3000);

      }

}
