package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCLoginNegativeTest extends TestBase {
    //fhctrip uygulamasının oturum açma işlevselliğini test edin.
    // http://www.fhctrip.com/Account/Logon
    //Iki ayri class olusturun (package:smoketest) : PositiveTest ve NegativeTest
    //Positive Test : her ikisi de geçerli username ve password
    //Negative test :
    //             1. geçerli  username fakat geçersiz password
    //             2. geçerli password  fakat geçersiz username
    //             3. her ikisi de geçersiz username ve password.
    //Username : manager2
    //password : Man1ager2!

    @Test(groups = "group test1")
    public void gecersizUserName(){

        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys("manager");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButon.click();

        //wait problemi yasaniyorsa wait object create ediyoruz
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                                            ("//span[.='Try again please']")));     // A. errorMesaj locate'i
        Assert.assertTrue(tryAgain.isDisplayed());  // A

        // Assert.assertTrue(fhcLoginPage.errorMesaj.isDisplayed());    // B
        //       yukaridaki satir     =     asagidaki satir ===> ayni isi yapiyor
      //Assert.assertTrue(fhcLoginPage.errorMesaj.getText().contains("Try again please"));  // C
        //  A  /    B   /   C ayni islevi yapiyor. Ancak B ve C'nin calismasi icin wait object gerekmez.

    }

    @Test(groups = "group test1")
    public void gecersizPassword(){

        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Manageee");
        fhcLoginPage.loginButon.click();

        Assert.assertTrue(fhcLoginPage.errorMesaj.getText().contains("Try again please"));

    }

    @Test
    public void gecersizUserNamePass(){


        Driver.getDriver().get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys("manager12");
        fhcLoginPage.password.sendKeys("Manageee");
        fhcLoginPage.loginButon.click();

        Assert.assertTrue(fhcLoginPage.errorMesaj.isDisplayed());

    }


}
