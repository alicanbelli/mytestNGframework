package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import com.techproed.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestConfigReader extends TestBase {
    @Test(groups = "group test1")
    public void gecersizUserName(){
//                                                      key
        driver.get(ConfigReader.getProperty("fhc_login_url")); //configuration.properties'ten key'i aldim
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButon.click();

        Assert.assertTrue(fhcLoginPage.errorMesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));

    }

    @Test(groups = "group test1")
    public void gecersizPassword(){

        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gercersiz_password"));
        fhcLoginPage.loginButon.click();

        Assert.assertTrue(fhcLoginPage.errorMesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));

    }

    @Test
    public void gecersizUserNamePass(){


        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.userName.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gercersiz_password"));
        fhcLoginPage.loginButon.click();

        Assert.assertTrue(fhcLoginPage.errorMesaj.isDisplayed());

    }

}
