package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbHomePage {
    //Kullanıcı https://www.glbtrader.com/ adresine gittiğinde
    //All Categories dropdown elementinde Furniture seçeneğinin bulunduğunu doğrulayın.
    //Join Now butonuna tiklasin.
    //Adım 1: Page objelerini oluşturmak için GlbHomePage'i kullanabilirsiniz.
    //Adım 2: Test class'ı oluşturun GlbCategoryDropdownTest

    public GlbHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "header_search_category")
    public WebElement allCategoriesDropDown;

    @FindBy(linkText = "Join Now")
    public WebElement joinNowLink;


}
