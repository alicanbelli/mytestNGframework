package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

//            ======== @DataProvider =======

// ***  @DataProvider ==> birden fazla deger gondermeyi sagliyor
// ***  Cucumber'da Scenario Outline'nin yaptigi isi testNG'de @DataProvider yapiyor.
//      Cucumber ===>  Scenario Outline
//      testNG   ===>  @DataProvider
//      Multi Array kullanilir [][]

//  (dataProvider = "getData") <== asagidaki @DataProvide'a name ismi verilmezse getData methot ismi yazilir.
    @Test (dataProvider = "log in data") // icine asagidaki @DataProvider(name = "log in data") ismini yazdik

    public void loginTest(String a, String b){ // Bu parametreler uzerinden getData() method'undaki
                                                     // 3 tane user ve pass sirasiyla girecek
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.userName.sendKeys(a);
        fhcLoginPage.password.sendKeys(b);
        fhcLoginPage.loginButon.click();
        Assert.assertTrue(fhcLoginPage.errorMesaj.isDisplayed());
    }

//  Bizim create ettigimiz data provider methodu
@DataProvider(name = "log in data")
    public Object[][] getData(){
//       {{user1, pass1},
//        {user2, pass2},
//        {user3, pass3}}
        Object[][] data = new Object[3][2];
//        1. siradaki datalar
        data[0][0]="user1";
        data[0][1]="pass1";
//        2. siradaki datalar
        data[1][0]="user2";
        data[1][1]="pass2";
//        3. siradaki datalar
        data[2][0]="user3";
        data[2][1]="pass3";

        return data;
    }

    }

