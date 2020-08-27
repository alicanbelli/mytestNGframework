package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorDeneme {

    @Test
    public void jsExecutorDenemeMethod(){
        Driver.getDriver().get("https://www.amazon.com/");

        JavascriptExecutor jsExecut = (JavascriptExecutor)Driver.getDriver();

// 1. Click işlemi için:
        WebElement amazonSimge = Driver.getDriver().findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']"));
        jsExecut.executeScript("arguments[0].click;",amazonSimge);

// 2. Scroll Down:
//        WebElement scrDown = Driver.getDriver().findElement(By.xpath("(//*[.='Gifts in Video Games under $30'])[1]"));
//        jsExecut.executeScript("arguments[0].scrollIntoView(true);",scrDown); //locate kadar iner
        jsExecut.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //en asagi kadar iner

// 3. Başka bir sayfaya yönlendirebiliriz:
        jsExecut.executeScript("window.location = 'http://www.google.com/'");

// 4. Sayfa Başlığını alabiliriz:
        String title = jsExecut.executeScript("return document.title;").toString();
        Driver.getDriver().getTitle().equals(title);
        System.out.println(title);

// 5. Sayfanın Url adresini alabiliriz:
        String url = jsExecut.executeScript("return document.URL;").toString();
        Driver.getDriver().getCurrentUrl().equals(url);
        System.out.println(url);

// 6. Sayfayı yenileyebiliriz:
        jsExecut.executeScript("history.go(0)");

// 7. Alert(uyarı) mesajı verebliliriz:
        jsExecut.executeScript("alert('Bu uyari JAVA jsExecutor nedeniyle verilmistir');");

// 8. Elementin içindeki değeri alabiliriz:
//String el1 =  js.executeScript("return document.documentElement.innerText;").toString();

// 9. Karakter dizisi gönderebiliriz:
//js.executeScript("document.getElementById('Elementin Id’si').value='Metin';");






    }
}
