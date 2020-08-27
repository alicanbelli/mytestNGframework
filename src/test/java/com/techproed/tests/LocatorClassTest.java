package com.techproed.tests;

import com.techproed.pages.LocatorClassPage;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LocatorClassTest {


    @Test
    public void locatorsmethod() throws InterruptedException {

        Driver.getDriver().get("https://library.sydney.edu.au/");

        LocatorClassPage locatorClassPage = new LocatorClassPage();

        Thread.sleep(5000);
        locatorClassPage.searchBox.sendKeys("peace");
        locatorClassPage.searchButton.click();

        Thread.sleep(7000);
        locatorClassPage.kitap1.click();

    }




}
