package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.pages.FHCRezervasyonPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCRezervasyonTest extends TestBase {

    @Test
    public void rezervasyonTest() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/RoomReservationAdmin/Create");

        //Day18FHCLoginPage class'inda bulunan login2() metodunu cagirmak icin obje olusturuyoruz
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.login2(); //bu obje ile login2() metodunu cagir

        //Day18FHCRezervasyonPage class'indan obje olusturuyoruz
        FHCRezervasyonPage fhcRezervasyonPage = new FHCRezervasyonPage(driver);

        //fhcRezervasyonPage objesini kullanarak class'taki elementleri cagir
        Select idUserSelect = new Select(fhcRezervasyonPage.idUser); //Bu sayfada dropDown'u locate etmedigim icin
        idUserSelect.selectByIndex(1); //Day18FHCRezervasyonPage class'inda yapilan locate'i obje uzerinden kullaniyorum

        Select idHotelRooRoomSelect = new Select(fhcRezervasyonPage.idHotelRoom); //dropdown (idHotelRoom)
        idHotelRooRoomSelect.selectByIndex(5);

        fhcRezervasyonPage.price.sendKeys("500");
        fhcRezervasyonPage.dateStart.sendKeys("09/14/2021");
        fhcRezervasyonPage.dateEnd.sendKeys("09/17/2021");
        fhcRezervasyonPage.adultAmount.sendKeys("2");
        fhcRezervasyonPage.childrenAmount.sendKeys("4");
        fhcRezervasyonPage.surname.sendKeys("Ozyurt");
        fhcRezervasyonPage.phone.sendKeys("061541234567");
        fhcRezervasyonPage.email.sendKeys("abcdokytg@gmail.com");
        fhcRezervasyonPage.notes.sendKeys("Orman manzarali oda");
        fhcRezervasyonPage.isApproved.click();
        fhcRezervasyonPage.isPaid.click();
        fhcRezervasyonPage.saveButton.click();

        Thread.sleep(5000);
        Assert.assertTrue(fhcRezervasyonPage.success_mesaj.isDisplayed());

        fhcRezervasyonPage.okButon.click();

    }
}
