package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateHotel extends TestBase {
    //1.Tests packagenin altina class olusturun: CreateHotel
    //2.Bir method olusturun: createHotel
    //3.http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
    //4.Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //5.Login butonuna basin.
    //6.Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //7.Save butonuna basin.
    //8.“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //9.OK butonuna tiklayin.

    @Test
    public void createHotel(){
        driver.get("http://www.fhctrip.com/admin/HotelAdmin/Create");

        //4.Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
        //Username : manager2
        //Password : Man1ager2!
        WebElement userNameBox = driver.findElement(By.id("UserName"));
        userNameBox.sendKeys("manager2");

        WebElement passwordBox = driver.findElement(By.id("Password"));
        passwordBox.sendKeys("Man1ager2!");

        //5.Login butonuna basin.
        WebElement loginButon = driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button"));
        loginButon.click();

        //6.Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
        driver.findElement(By.id("Code")).sendKeys("Butik");
        driver.findElement(By.id("Name")).sendKeys("Sunset");
        driver.findElement(By.id("Address")).sendKeys("Frankfurt");
        driver.findElement(By.id("Phone")).sendKeys("0515423456");
        driver.findElement(By.id("Email")).sendKeys("ramfrttfa@gmail.com");

        WebElement IDGroup = driver.findElement(By.id("IDGroup"));
        Select select = new Select(IDGroup);
        select.selectByIndex(1);

        //7.Save butonuna basin.
        WebElement saveButon = driver.findElement(By.id("btnSubmit"));
        saveButon.click();

//  ***** 8.madde PASS olmadigi icin wait yapmamiz gerekiyor.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),
                                                                    "Hotel was inserted successfully")));
        // ==> Burada textToBe() kullandik = "text bu olmali" manasinda

        //8.“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='bootbox-body']")).isDisplayed());
        //Bu satir sagidaki a ve b satirlarinin gorevini yapiyor

       // a. WebElement hotelText = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
       // b. Assert.assertTrue(hotelText.isDisplayed());


        //9.OK butonuna tiklayin.
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        // OK butonu locate edildikten sonra olusan objeye click'te yapabiliriz.

    }
}
