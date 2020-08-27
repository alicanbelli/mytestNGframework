package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {
    //1.Bir class oluşturun : WebTables
    //2.login() metodun oluşturun ve oturum açın.
    //3.http://www.fhctrip.com/admin/HotelRoomAdmin
    //Username : manager2
    //Password : Man1ager2!

    //4.table() metodu oluşturun
    //5.Tüm table body’sinin boyutunu(size) bulun. Kac tane hucre(cell) var?
    //6.Table’daki başlıkları(headers) konsolda yazdırın.

    //7.printRows() metodu oluşturun
    //8.table body’sinde bulunan toplam satir(row) sayısını bulun.
    //9.Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
    //10. 4.satirdaki(row) elementleri konsolda yazdırın.

    //11.printCells() metodu oluşturun
    //12.table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    //13.Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.
    
    //14.printColumns() metodu oluşturun
    //15.table body’sinde bulunan toplam sutun(column) sayısını bulun.
    //16.Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
    //17. 5.column daki elementleri  konsolda yazdırın.

    //18. Bir metod oluşturun : printData(int row, int column);
    //19. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell)
    //      veriyi yazdırmalıdır.
    //20. Baska bir metod daha oluşturun: printDataTest();
    //21. Ve bu metodu printData() methodunu cagirmak icin kullanin.
    //22. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

    public void login() throws InterruptedException {
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        //Username : manager2
        //Password : Man1ager2!

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button")).click();

       }

    @Test
    public void table() throws InterruptedException {

        login(); // ***** Burda login() yazarak yukardaki metodun @Test ihtiyaci kalmadi

        //table ==> tum tablo'yu gorur
        //thead ==> tum basligi gorur
        //tbody ==> tum body'yi gorur

        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText()); // Bununla table body'sinin datalarini consolde yazdi

        //5.Tüm table body’sinin boyutunu(size) bulun. Kac tane hucre(cell) var?
        List<WebElement> table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("TABLE BODY SIZE : " + table.size());


        //6.Table’daki başlıkları(headers) konsolda yazdırın.
        WebElement allHeaders = driver.findElement(By.xpath("//tr"));
        System.out.println(allHeaders.getText()); // Asagidaki List<> ile bu kod ayni sonucu veriyor

//        List<WebElement> allHeaders = driver.findElements(By.tagName("th"));
//        for (WebElement header: allHeaders){
//            System.out.println(header.getText());
//        }

    }
    @Test  //7.printRows() metodu oluşturun
    public void printRows() throws InterruptedException {
       login();

        //8.table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> toplamSatir = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(toplamSatir.size()); // ==> "Table body'de bulunan toplam satir(row) sayisi

        //9.Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement rows: allRows){
            System.out.println(rows.getText());

        }
        //10. 4.satirdaki(row) elementleri konsolda yazdırın.
        // 1. Yontem
        WebElement tbody4 = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("4. satir 1. yontem: " + tbody4.getText());
        // 2. Yontem
        List<WebElement> elemntRow4 = driver.findElements(By.xpath("//tbody//tr[4]"));
        for (WebElement element: elemntRow4){
            System.out.print("4. satir 2. yontem: " +element.getText());
        }

    }

    @Test   //11. printCells() metodu oluşturun
    public void printCells() throws InterruptedException {
        login();

        //12. table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("Tabloda toplam "+ driver.findElements(By.xpath("//tbody//td")).size()+
                                                                        " tane cell(hucre) vardir.");

        //13. Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement cell : allCells){
            System.out.println(cell.getText());
        }

    }
    @Test   //14. printColumns() metodu oluşturun
    public void printColumns() throws InterruptedException {
        login();
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//th"));
        System.out.println("Tabloda toplam " + sutunSayisi.size()+ " tane sutun(column) vardir.");
                            // ==> tr[1]//td = //th
                    // ==> th = basliktaki bir hucre==> her bir baslik hucresi bir sutunun baslangicidir.

        //16. Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
        List<WebElement> allColumn = driver.findElements(By.xpath("//th"));
        for (WebElement column : allColumn) {
            System.out.println(column.getText());
        }

        // 17. 5.column daki(sutundaki) elementleri  konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement element: column5){
            System.out.println(element.getText());
        }

    }
    //18. Bir metod oluşturun : printData(int row, int column);
    public void printData(int row, int column){ // ***** DIKKAT!!!  Bu methodun parametreleri var!!!!!!
        // ***** -BU METHOD ASAGIDAKI printDataTest() METHODU'NUN VERILERINI KULLANACAK!

        //19. Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu
        //                                        bu hücredeki(cell) veriyi yazdırmalıdır.

        //   //tbody//tr[8]//td[3]

        String xpath = "//tbody//tr[" +row+ "]//td[" +column+ "]";//Bu dinamik bir xpath kod
//      DIKKAT!      yukaridaki xpath     =     asagidaki xpath
//      String xpath = "//tbody//tr[8]//td[3]";
//        [8] = [" +row+ "]     ve      [3] = [" +column+ "]
// ===> Ama yukaridaki DINAMIK!
// Butun satir(row) ve butun sutun(column) numaralari girildiginde asagidaki printDataTest() methodunda calisir.
// Ama bir asagidaki kod sadece 8.row ve 3.column icin calsisr



        //elementleri xpath'i kullanarak bulalim
        WebElement data = driver.findElement(By.xpath(xpath));
        //data lari yazdiralim
        System.out.println(data.getText());
    }

    @Test
    public void printDataTest() throws InterruptedException {  //20. Baska bir metod daha oluşturun: printDataTest();
        login();
        //21. Ve bu metodu printData() methodunu cagirmak icin kullanin.
        //22. Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

        printData(8,3); // 1234
        printData(5,2); //kalem
        printData(9,5); //London
        printData(3,7);

    }

}
