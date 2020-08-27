package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorClassPage {

    public LocatorClassPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "primoQueryTemp")
    public WebElement searchBox;

    @FindBy(css = "span[class='hidden-xs hidden-sm']")
    public WebElement searchButton;

    @FindBy(xpath = "(//img[@src='custom/61USYD_INST-sydney/img/icon_book.png'])[3]")
    public WebElement kitap1;

}
