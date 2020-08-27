package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14UploadFile extends TestBase {

    //1. Tests packagenin altina bir class oluşturun : UploadFile
    //2. Bir metod oluşturun : uploadFileMethod
    //3. https://the-internet.herokuapp.com/upload gidin
    //4. Yuklemek istediginiz dosyayi secin.
    //Upload butonuna basin.
    //“File Uploaded!” textinin goruntulendigini dogrulayin.

    @Test
    public void uploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butununu bulalim
        WebElement chooseFileButon =driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secin!
        String filepath = "C:\\Users\\Administrator\\Downloads\\prog.PNG"; //**** dosyanin path'ini kopyalayip,
                                                    // *** sonuna ismini ve uzantisini ekliyoruz (prog.PNG)
                                                    // ***** Dosyanin path'i olmadan yuklemez! *****

        // sendKeys() kullanabilmek icin choose file elementinin **** tag = input ve type="file" olmali ****
        chooseFileButon.sendKeys(filepath);

        // ==== *****  UploadFile  **** ====
        //Choose file butonunun isnpect'ini alabilmek icin ve sendKeys() kullanabilmek icin;
        //                                  1) Tag'inin ==> "input",
        //                                  2) Entribute'nin "type", value'nin "file" olmasi gerekir.

        //Ubload butonuna basin
        WebElement ubloadButon = driver.findElement(By.id("file-submit"));
        ubloadButon.click();

        //“File Uploaded!” textinin goruntulendigini dogrulayin.
                                                    // Direk asagidaki sekilde de assert edilebilir
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");




    }

}
