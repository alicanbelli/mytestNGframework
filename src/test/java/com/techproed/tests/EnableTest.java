package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTest extends TestBase {
    //1.	Bir class olusturun : EnableTest
    //2.	Bir metod olusturun :  isEnabled()
    //3.	https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4.	Enable butonuna basin.
    //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin.
    //6.	“It’s enabled!” mesajinin goruntulendigini dogrulayin.


    @Test
    public void isEnabled(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButon = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButon.click(); //4.	Enable butonuna basin.

        //6.	“It's enabled!” mesajinin goruntulendigini dogrulayin.
                // explicitlyWait gerekli. Cunku yukleme icin zaman gerekiyor. Ve belirli bir kosul var.
                // wait yapmadim, FAIL verdi. Demek ki wait olusturmam gerekiyor.
                // ve sonra 5. madde calisti ve PASS oldu.

        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enableMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(enableMesaj.getText(),"It's enabled!");

        //5.	Textbox’in etkin olup olmadigini(enabled) dogrulayin. ==> ***** isEnabled() *****
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());// isEnabled() gibi is ile baslayan komutlar,
                                               // Assert ile kontrol edilebilir
        // veya
        // Yukaridaki satir yerine asagidaki iki satirda kullanilabilir.
             // ===>  boolean isEnable = textBox.isEnabled();
             // ===>  Assert.assertTrue(isEnable);

        // isEnabled(); ==> bir elementin etkin olup olmadigini kontrol eder
        //isDisplayed(); ==> bir elementin gorunup gorunmedigini kontrol eder
        //isSelected(); ===> radio button ve checkbox'larin secilmesinde kullaniliyor





    }


}
