package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {
    @Test
    public void gecersizPassword(){
//              driver'in alti kirmizi ===> Bunu cozmek icin Day20Driver.getDriver(). kullaniyoruz
//                                      driver ===> Day20Driver.getDriver()
//                                  Day19ConfigReader.getProperty ile run ediyoruz
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.userName.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gercersiz_password"));
        fhcLoginPage.loginButon.click();

        Assert.assertTrue(fhcLoginPage.errorMesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));

    }
}
