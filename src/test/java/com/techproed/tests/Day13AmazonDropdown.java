package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Day13AmazonDropdown extends TestBase {
    // 1.Tests packagenin altinda bir class olusturun: AmazonDropdown
    // 2.https://www.amazon.com/ adresine gidin.
    // 3.Dropdown elementini bulun.
    // 4.İlk seçilen seçeneği(firstSelectedOption)  konsolda yazdırın ve ilk secenegin “All Departments”
    //                                                                     ile esit oldugunu dogrulayin.
    // 5.6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu dogrulayin.
    //                            (Seçtikten sonragetFirstSelectedOption() metodunu kullanmanız gerekir)
    // 6.Butun dropdown seçeneklerini konsolda yazdırın
    // 7.Dropdowndaki eleman sayisini konsolda yazdırın
    // 8.“Electronics” ın dropdownda olup olmadığını kontrol edin.
    // “Electronics” dropdownda bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.
    //
    // NOT: TestBase classini kullanalim. Dogrulama yaparken Assertion kullanalim.
    // Test case’de verilen secenekler sizde farkli olabilir.
    // Sizde gorunen seceneklere gore kodunuzu yazabilirsiniz.

    @Test
    public void amazonDropdown(){
        driver.get("https://www.amazon.com/");

        // 3.Dropdown elementini bulun.
        WebElement dropDownAmazon = driver.findElement(By.id("searchDropdownBox"));
        Select optiondropDownAmazon = new Select(dropDownAmazon);

        // 4.İlk seçilen seçeneği(firstSelectedOption)  konsolda yazdırın ve ilk secenegin “All Departments”
        //                                                                     ile esit oldugunu dogrulayin.
        String firstSelectedOption = optiondropDownAmazon.getFirstSelectedOption().getText();
        System.out.println("FIRST SELECTION OPTION : "+ firstSelectedOption);
        Assert.assertEquals(firstSelectedOption,"All Departments");//“All Departments” dogrulama

        // 5.6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu dogrulayin.
        //   (Seçtikten sonragetFirstSelectedOption() metodunu kullanmanız gerekir)
        optiondropDownAmazon.selectByIndex(5); //6.secenek = 5.index
        String booksOption = optiondropDownAmazon.getFirstSelectedOption().getText();
        Assert.assertEquals(booksOption, "Books");

        // 6.Butun dropdown seçeneklerini konsolda yazdırın
        List<WebElement> allOptions = optiondropDownAmazon.getOptions();
        int first = 1; // ==> Console'da kacinci secenek oldugunu gosterecek! gerekli degil! yazilmayabilir
        for(WebElement w : allOptions){
            System.out.println(first++ +". dropdown option : " + w.getText());
        }

        // 7.Dropdowndaki eleman sayisini konsolda yazdırın
        System.out.println("\nDropdowndaki eleman sayisi : " + allOptions.size());

        // 8.“Electronics” ın dropdownda olup olmadığını kontrol edin.
        // “Electronics” dropdownda bulunuyorsa konsolda True yazdırın. Aksi takdirde False yazdırın.
        boolean flag = false;
        for(WebElement w : allOptions){
            if(w.getText().equals("Electronics")){
                flag = true;
                break;
            }
        }
        System.out.println(flag); //true
     }
}
