package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreation extends TestBase {
    //1.Tests packagenin altina class olusturun: HotelRoomCreation
    //2.Bir method olusturun:  RoomCreateTest()
    //3.http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
    //4.Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //5.Login butonuna basin.
    //6.Add Hotel room butonuna tiklayin
    //6.Acilan sayfadaki butun textboxlara istediginiz verileri girin
    //7.Save butonuna basin.
    //8.“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
    //9.OK butonuna tiklayin.
    //10.Hotel rooms linkine tiklayin.
    //11."LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.

    @Test
    public void roomCreateTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");

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

        //6.ADD HOTELROOM butonuna tiklayin
        WebElement addHotelRoom = driver.findElement(By.className("hidden-480"));
        addHotelRoom.click();

        //6.Acilan sayfadaki butun textboxlara istediginiz verileri girin
        WebElement selectHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(selectHotel);
        select.selectByVisibleText("Stuttgart King Hotel");

        driver.findElement(By.id("Code")).sendKeys("King");
        driver.findElement(By.id("Name")).sendKeys("112");
        driver.findElement(By.id("Location")).sendKeys("Stadtteil");
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Orman manzarali");



        // **** Prise ****
        //kaynak'tan hedef'e tasimamiz gerekiyor
        WebElement kaynak = driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement hedef = driver.findElement(By.id("Price"));
        actions.dragAndDrop(kaynak,hedef).perform(); //actions extends class'ta var. onu kullandim
         // *** dragAndDrop() actions class'tan == kaynak'tan ==> hedef'e tasir

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(roomType);
        select1.selectByIndex(6);
        WebElement adultCount=driver.findElement(By.id("MaxAdultCount"));
        adultCount.sendKeys("2");
        WebElement childCount=driver.findElement(By.id("MaxChildCount"));
        childCount.sendKeys("4");

        driver.findElement(By.xpath("//*[@id=\"edit-form\"]/div[1]/div[10]/label")).click();

        //7.Save butonuna basin.
        driver.findElement(By.id("btnSubmit")).click();

        //8.“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
                 //sayfa biraz gec acildigindan driver'in metni algilamasi icin wait yapmamiz gerekiyor
        WebDriverWait wait1 = new WebDriverWait(driver,20);
        boolean isTrue = wait1.until(ExpectedConditions.textToBe((By.xpath("//div[@class='bootbox-body']")),
                                                           "HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);

        //9.OK butonuna tiklayin.
        driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();

        //10.Hotel rooms linkine tiklayin.
        WebElement hotelRoomsLink = wait1.until(ExpectedConditions.elementToBeClickable
                                  (driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
       actions.doubleClick(hotelRoomsLink).perform(); // **** doubleClick() ile burasi PASS oldu!

        //11."LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.
        WebElement listOfHotel = driver.findElement(By.xpath("//span[.='List Of Hotelrooms']"));
        Assert.assertTrue(listOfHotel.isDisplayed());

//         driver.findElement(By.xpath("//span[.='List Of Hotelrooms']")).isDisplayed();
//     ==> Bu satir yukardaki iki satir ile ayni gorevi yapiyor.





    }

}
