package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Day15WaitTest extends TestBase {

    //1.  Bir class olusturun : WaitTest
    //2.  Iki tane metod olusturun :  implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3.  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.  Remove butonuna basin.
    //5.  “It's gone!” mesajinin goruntulendigini dogrulayin.

    @Test
    public void implicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.  Remove butonuna basin.
        WebElement removeButon = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeButon.click();

        // ***** BU METHOD'TA implicitlyWait() KULLANDIK *****

        //5.  “It’s gone!” mesajinin goruntulendigini dogrulayin.

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Mesajin yuklenmesi biraz zaman aldigindan PASS olmasi icin wait kullanmamiz gerekiyor
        //Bu nedenle implicitlyWait() kullandik. Ancak burda pasiv yaptim cunku;
                                // implicitlyWait() parent class'ta var, bu class onu kullanabilir/kullanir
        WebElement mesaj = driver.findElement(By.id("message"));
        Assert.assertEquals(mesaj.getText(),"It's gone!");
        // ***** BU METHOD'TA explicitWait() KULLANDIK *****
        // B- sonra explicitWait() ile bekletiyoruz.

    }

    @Test
    public void explicitWait(){
        // Create WebDriverWait object ==> explicitWait icin muhakkak object creat edilmeli
                                        // A- once object (wait) create ediyoruz
       WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4.  Remove butonuna basin.
        WebElement removeButon = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeButon.click();

        // ***** BU METHOD'TA explicitWait() KULLANDIK *****
                                        // B- sonra explicitWait() ile bekletiyoruz.
        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //5.    “It's gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertEquals(goneMessage.getText(), "It's gone!");

    }
}
