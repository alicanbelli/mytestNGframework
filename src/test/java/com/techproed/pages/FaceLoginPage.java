package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
//    !!! Day18FaceLoginTest class'indaki bilgilere dayali asagidaki elementleri locate ettik!

    // create driver
    WebDriver driver;

    // constructor kullanarak driver'i baslatalim.
    public FaceLoginPage(WebDriver driver){ // ===> Bu bir constructor

        this.driver = driver;
        // ****  PageFactory.initElements() **** ==> page objelerini(Web element) baslatmak icin kullanilir
        PageFactory.initElements(driver, this);

    }
    // *** @FindBy annotation'i ile asgidaki elementleri locate ettik
    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(id = "u_0_b")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement erroor_mesaj;




}
