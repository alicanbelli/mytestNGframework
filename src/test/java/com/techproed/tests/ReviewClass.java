package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReviewClass {

//    https://www.airbnb.co.in/ adresine git
//Sayfa basligini(title) al ve konsolda yazdir.
//Sayfanin mevcut url’ ini (current url) al
//Sayfanin source(page source) ‘u al.

    @Test
    public void airbnbTest() throws InterruptedException {

        Driver.getDriver().get("https://www.airbnb.co.in/");
        Thread.sleep(3000);
        System.out.println(Driver.getDriver().getTitle());
        System.out.println(Driver.getDriver().getCurrentUrl());

        String pageSource = Driver.getDriver().getPageSource();
        System.out.println(pageSource);

    }

    @Test
    public void ebayTest() throws InterruptedException {
// https://www.ebay.com/ adresine git
//Search box’a “Selenium” yaz
//Search butonuna tikla
//Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
//Sayfa basligini(title) al ve konsolda yazdir.
//Sayfanin mevcut url’ini (current url) al
//Sayfanin source(page source) ‘u al.

        Driver.getDriver().get("https://www.ebay.com/");

        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys("Selenium"+ Keys.ENTER);

        WebElement resultSelenium = Driver.getDriver().findElement(By.xpath("//span[.='1,425']"));
        System.out.println(resultSelenium.getText());

        String title = Driver.getDriver().getTitle();
        System.out.println(title);

        String url = Driver.getDriver().getCurrentUrl();
        System.out.println(url);

        String pageSource = Driver.getDriver().getPageSource();
        System.out.println(pageSource);




    }

}
