package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignInNegativeTest {
    //Test Case-Homework Global Trader Sign In Test.
    // Kullanici https://www.glbtrader.com/login.html sayfasina gitsin.
    // Sayfaya yanlis veriler girerek sign in ozelligini test etsin.
    // 1. pages  paketinin altina bir page class olusturun : GlbHomePage
    // a. Page objelerini(webelement) bulun.
    // 2. smoketest  paketinin altina iki tane test classi olusturun :
    // ● PositiveTestGlbSignIn
    // ● NegativeTestGlbSignIn
    // =====Page Object Model kullanin======

    @Test
    public void methodNegative(){

        Driver.getDriver().get(ConfigReader.getProperty("glbtraderCom"));

        GlbSignInPage glbHomePage = new GlbSignInPage();

        glbHomePage.signIn.click();
        glbHomePage.signIn.click();
        glbHomePage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("gecersiz_test_email"));
        glbHomePage.login.click();

        Assert.assertTrue(glbHomePage.mesaj.getText().equals("Sorry!"));

        Driver.closeDriver();

    }

}
