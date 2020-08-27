package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DenemePage {

    public DenemePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //email textbox,password textbox, ve signin button elementlerini locate edin.
    //Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
    //Username :  testtechproed@gmail.com
    //Password :   Test1234!
    //Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
    //Daha sonra assertions kullanarak testtechproed@gmail.com kullanıcı kimliğinin(userID) doğrulayın

    @FindBy(id = "session_email")
    public WebElement email;

    @FindBy(id = "session_password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//span[@class='navbar-text']")
    public WebElement dogrulama;

    @FindBy(xpath = "//h1[.='Welcome to Address Book']")
    public WebElement hosgeldin;


}
