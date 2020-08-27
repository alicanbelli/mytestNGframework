package com.techproed.smoketest;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    @Test
    public void signUpTest() throws InterruptedException {
        // driver olutusmamiz gerekiyor
        Driver.getDriver().get(ConfigReader.getProperty("glb_signup_url"));

        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone"));
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.signUpButton.click();

//        WebDriverWait wait = new WebDriverWait(Day20Driver.getDriver(),10);
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(glbSignUpPage.successMesaj)).isDisplayed());

        System.out.println(glbSignUpPage.successMesaj.getText()); // Success! !
        Assert.assertTrue(glbSignUpPage.successMesaj.getText().equals("Success!"));

//      Test FAIL olacak cunku actual ==> Success! ! fakat expexted Success!

        Driver.closeDriver();

    }

}
