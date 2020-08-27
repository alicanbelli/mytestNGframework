package com.techproed.smoketest;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLoginTest extends TestBase {
    //1. Yeni bir class oluşturun: FaceLoginTest
    //2. Bir test metodu oluşturun: faceLoginTest ()
    //3. Kullanıcı geçersiz kimlik bilgileri girdiğinde,  kullanıcı;
    //“The email or phone number you’ve entered doesn’t match any account.”
    // mesajini görmelidir.
    //4. https://www.facebook.com/
    //5. Username: fakeusername
    //6. Password: fakepassword

    @Test
    public void faceLoginTest (){
        driver.get("https://www.facebook.com/");

        FaceLoginPage faceLoginPage = new FaceLoginPage(driver);
    // ==> Day 18FaceLoginPage class'indan obje create ettim ve
    //  bu obje uzerinden Day18FaceLoginPage class'inin value'lerini kullandim

        faceLoginPage.email.sendKeys("fakeusername");
        faceLoginPage.password.sendKeys("fakepassword");
        faceLoginPage.loginButton.click();

        //Kullanıcı geçersiz kimlik bilgileri girdiğinde,  kullanıcı;
        //“The email or phone number you’ve entered doesn’t match any account.”
        // mesajini görmelidir.

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement errorMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        // FAIL olmamasi icin her ihtimale karsi explicitWait create ediyoruz
        Assert.assertTrue(errorMesaj.isDisplayed());

        // ==>> * Wait problemi olmasaydi yukardaki 3 satir yerine  asagidaki satir yeterliydi.
        //Assert.assertTrue(faceLoginPage.error_Mesaj.isDisplayed());

    }

}
