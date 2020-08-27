package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor {

//    ========== JAVA SCRIPT EXECUTOR =========

//Bazen Selenium ile web elementlerinin kontrollerini sağlarken selenium komutları yetersiz kalabiliyor
// istediğimiz performansı sağlamayabiliyor ve sorunlarla karşılaşabiliyoruz.
// Bu durumlarda alternatif olarak üstesinden gelmek için JavaScriptExecutor sınıfını dahil ediyoruz.
// JavaScript HTML ve DOM’a direk erişip yönetebilen bir script dili olduğundan bize çok fazla kolaylık sağlar.
// Testimizin performansını arttırır ve normal javascript dilinde kodlamamıza imkan tanır.

//Nasıl sorunlarla karşılaşıyoruz?
//Örnek verecek olursak, en basitinden click() tıklama komutu tıklamadı ama bize bir hata mesajı da vermedi.
// Burada kaçış yolu olarak JavaScriptExecutor’a başvururuz ve düzgün çalışır.

    @Test
    public void javascriptExecuterTest(){

        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("btnSubmit"));
        //clickElementByJS(loginButton);   1.
                                            // asagidaki methodun icine locate elementi(loginButton) koyduk

        WebElement createButton = Driver.getDriver().findElement(By.id("btnSubmit"));
//        clickElementByJS(createButton);
//        System.out.println(getTitleByJS());
//        crollDownByJS();
        WebElement intagram = Driver.getDriver().findElement(By.xpath("//*[.='Instagram']"));
//        scrollInToViewJS(intagram); ==> belirlenen elemente kadar sayfayi kaydirma Down

        WebElement arabayaKadar = Driver.getDriver().findElement(By.xpath("(//a[@class='blog-img mr-4'])[1]"));
//        scrollInToViewJS(arabayaKadar); ==> belirlenen elemente kadar sayfayi kaydirma Down

//        flash(loginButton); // asagida flash() method ==> login Button renk degistirme

        generateAlert("Sayfada bir bug bulundu.."); // ==> web ekrana Alert mesaji gonderme
    }

//    Bu method bir parametre alir(WebElement element)
//    elementi bu methodun icine yazdigimizda JavaScript bu elemente tiklar
    public void clickElementByJS(WebElement element){
//      syntax'i
        JavascriptExecutor jsExecutor = ((JavascriptExecutor)Driver.getDriver()); // ==> syntax

        jsExecutor.executeScript("arguments[0].click();", element);

    }

//    Sayfa basligini(Title) JavaScript ile alma methodu
public String getTitleByJS(){
    JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
    String title = jsExecutor.executeScript("return document.title;").toString();
    return title;
}

    //Scroll down (asagi kaydirma)
    public void scrollDownByJS(){
        JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

//    JS ile belirlenen elemente kADAR kaydirma
public void scrollInToViewJS(WebElement element){
    JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
    jsExecutor.executeScript("arguments[0].scrollIntoView(true);",element);

}

//secilen elementin background rendini degistirmek icin kullandigimiz yontem
    public void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0", element);
            changeColor(bgColor, element);
        }
    }

    public void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    Gerektiginde bir uyari(alert) olusturma

    public void generateAlert(String message){
        JavascriptExecutor jsExecutor =((JavascriptExecutor)Driver.getDriver());
        jsExecutor.executeScript("alert('"+ message + "')");
    }

}
