package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbCategoryDropdownTest {
    //Kullanıcı https://www.glbtrader.com/ adresine gittiğinde
    //All Categories dropdown elementinde Furniture seçeneğinin bulunduğunu doğrulayın.
    //Join Now butonuna tiklasin.
    //Adım 1: Page objelerini oluşturmak için GlbHomePage'i kullanabilirsiniz.
    //Adım 2: Test class'ı oluşturun GlbCategoryDropdownTest

    @Test
    public void glbCategoryDropdownTest(){


        Driver.getDriver().get(ConfigReader.getProperty("glbtraderCom"));

        GlbHomePage glbHomePage = new GlbHomePage(); // object olusturduk

        Select options = new Select(glbHomePage.allCategoriesDropDown);

        //All Categories dropdown elementinde Furniture seçeneğinin bulunduğunu doğrulayın.
        // for each loop ile karsilastirma yapiyoruz.
        boolean flag = false;
        for (WebElement option: options.getOptions()){
               if(option.getText().equals("Furniture")){
                System.out.println("DROPDOWN'DA FURTNITURE VARDIR");
                flag=true;
                break;
            }
        }
        Assert.assertTrue(flag); //Eger flag true ise Assert PASS olacak...

        //Join Now butonuna tiklasin.
        glbHomePage.joinNowLink.click();

         Driver.closeDriver();
    }
}
