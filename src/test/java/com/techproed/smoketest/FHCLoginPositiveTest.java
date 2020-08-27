package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPositiveTest extends TestBase {

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

    @Test
    public void pozitiveTestLogin(){

        driver.get("http://www.fhctrip.com/Account/Logon");
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Man1ager2!");
        fhcLoginPage.loginButon.click();

    }
}
