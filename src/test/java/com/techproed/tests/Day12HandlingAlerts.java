package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//*** Alerts'ler locate edilmez!!!!
    // Bunun yerine;
//driver.switchTo().alert().accept();
//driver.switchTo().alert().dismiss(); vb switchTo() komutlari kullanilir
//
public class Day12HandlingAlerts extends TestBase {
    //Bir class olusturun: HandlingAlerts
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    // OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.

   @Test
    public void acceptAlert(){
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
       WebElement buton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
       buton1.click(); // butona tıklayın,

       //Alert uzerindeki mesaji konsolda yazdir.
       System.out.println("Alert Mesaji : " +driver.switchTo().alert().getText());

       //uyarıdaki OK butonuna tıklayın
       driver.switchTo().alert().accept();//accept() ==> click OK demektir

       //result mesajının görüntülendiğini doğrulayın.
       WebElement resultMesaj = driver.findElement(By.id("result"));
       Assert.assertTrue(resultMesaj.isDisplayed()); //Hard assert kullandik


   }
   @Test
    public void dismissAlert(){
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2.butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
       WebElement buton2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
       buton2.click(); // ==> 2.butona tıklayın

       driver.switchTo().alert().dismiss(); // ==> uyarıdaki Cancel butonuna tıklayın

       //result mesajının görüntülendiğini doğrulayın.
       WebElement resultCanselMesal = driver.findElement(By.id("result"));
       Assert.assertTrue(resultCanselMesal.isDisplayed());

       System.out.println(resultCanselMesal.getText()); // ==> mesaji console'a yazdirir


   }
   @Test
    public void sendKeysAlert(){
       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
       // OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
       WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
       buton3.click(); // ==> 3. butona tıklayın,

       //uyarıdaki metin kutusuna isminizi yazin,
       driver.switchTo().alert().sendKeys("Resit");
       driver.switchTo().alert().accept();// ==>OK butonuna tıklayın
       //result mesajının görüntülendiğini doğrulayın.
       WebElement resultButton3 = driver.findElement(By.id("result"));
       Assert.assertTrue(resultButton3.isDisplayed()); // Hard Assert ile yaptik, ayrica
                                                    //iki String ile actual ve excepted ile de yapilabilir
   }

}
