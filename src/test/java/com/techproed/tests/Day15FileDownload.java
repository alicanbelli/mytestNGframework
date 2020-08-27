package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day15FileDownload extends TestBase {

    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.

    @Test
    public void isExist(){
       String mevcutKlasor = System.getProperty("user.dir"); // *** user.dir :bulunulan klasorun path'ini verir
        System.out.println("MEVCUT KLASOR : " + mevcutKlasor);
                            // mevcutKlasor ===>  C:\Users\Administrator\IdeaProjects\mytestNGframework

       String userKlasor = System.getProperty("user.home"); // *** user.home : Kullanici klasorunu verir
                        // userKlasor ==> bilgisayarimdaki Users/Administrator klasorudur
        System.out.println("USER KLASOR : " + userKlasor); // ===> C:\Users\Administrator

       String filePath = userKlasor + "/Downloads/prog.PNG";
    // String filePath = "C:\\Users\\Administrator\\Downloads\\prog.PNG";  ==>  Bir yukaridaki satir ile ayni

        //   *** Files.exists(Paths.get(filePath)); ==> Bilgisayarda dosyanin olup olmadigini kontrol eder.
        //  Indirilen bir dosyanin indirme klasorumuzde(Download) olup olmadigini kontrol etmek icin kullanilir
        boolean isFileExist =  Files.exists(Paths.get(filePath)); //boolean
        Assert.assertTrue(isFileExist); //Eger dosya varsa(file exist) true ve pass, yoksa false / fail olur.

    }

    @Test
    public void downloadTest() throws InterruptedException {

        //1.https://the-internet.herokuapp.com/download adresine gidin;
        driver.get("https://the-internet.herokuapp.com/download");

        //2.image1.jpg dosyasını indir;
        WebElement image1 = driver.findElement(By.linkText("image1.jpg"));
        image1.click();

        //3.Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın;

        //Bunu iki yol ile yapabiliriz;

        // 1.Yol  ===> Direk path'ini yazarak
        String filePath = "C:/Users/Administrator/Downloads/image1.jpg";

        // 2.Yol  ===> Kullanici klasorunu olusturarak;
     // String userKlasor = System.getProperty("user.home");
     // String filePath = userKlasor + "/Downloads/image1.jpg";

        //Dosya var mi yok mu kontrol ediyoruz
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);//Dosya yuklendiyse PASS, degilse FAIL



    }
}
