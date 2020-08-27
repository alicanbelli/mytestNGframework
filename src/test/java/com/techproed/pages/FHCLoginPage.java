package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCLoginPage {

    WebDriver driver;

    public FHCLoginPage(WebDriver driver){ // <===> Constructor

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginButon;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButon2;

    @FindBy(xpath = "//span[.='Try again please']")
    public WebElement errorMesaj;




    // create login button
    public void login2(){
        userName.sendKeys("manager2");
        password.sendKeys("Man1ager2!");
        loginButon2.click();

//    *** Burada login() method'unu creat ettik. Bununla baska Class'larda login methodunu cagirip, kullanilacak


    }

}
