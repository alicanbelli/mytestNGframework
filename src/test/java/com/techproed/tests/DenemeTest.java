package com.techproed.tests;

import com.techproed.pages.DenemePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DenemeTest {
    //Class name : Soft_Hard_Assertion
    //http://a.testaddressbook.com/sign_in adresine gidin.
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra assertions kullanarak testtechproed@gmail.com kullanıcı kimliğinin(userID) doğrulayın

     @Test
    public void testMethod(){

        Driver.getDriver().get(ConfigReader.getProperty("deneme1"));

         DenemePage denemePage = new DenemePage();

         denemePage.email.sendKeys("testtechproed@gmail.com");
         denemePage.password.sendKeys("Test1234!");
         denemePage.signInButton.click();

         Assert.assertTrue(denemePage.hosgeldin.isDisplayed());

         Assert.assertTrue(denemePage.dogrulama.getText().contains("testtechproed@gmail.com"));





    }

    }


