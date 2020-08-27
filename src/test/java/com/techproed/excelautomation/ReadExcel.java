package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcelFile() throws IOException {

//                     Data okuyacagimiz dosyanin path'ini yazalim
        String path = ".\\src\\test\\resources\\ULKELER.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path); //Dosyayi (file) acalim

//      fileInputStream kullanarak workbook'u acalim
        Workbook workbook = WorkbookFactory.create(fileInputStream); // 1. Workbook

        Sheet sheet = workbook.getSheetAt(0);       // 2.Sheet  ==> sheet'ler index 0'dan basliyor.
        Row row = sheet.getRow(0);                  // 3. Row  ==> row'larda index 0'dan baslar
        Cell cell = row.getCell(0);                 // 4. Cell  ==> cell'lerde index 0'dan baslar

        System.out.println("1.CELL'deki data : " +cell); //ULKELER
        System.out.println("2.CELL'deki data : " +row.getCell(1)); //BASKENT
        System.out.println("2.CELL'deki data : " +row.getCell(2)); //NEYI MESHUR

//  Soru:  2.row 1.cell konsolda yazdirin?
        //1.Yontem:
        Row row1 = sheet.getRow(1);
        Cell cell1= row1.getCell(0);
        System.out.println(cell1);//Almanya

        //2.Yontem:                                //chain methodu
        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(0)); //Almanya

        //3.Yontem:
        String row2cell1 =workbook.getSheetAt(0).getRow(1).getCell(0).toString(); //toString
        System.out.println(row2cell1); //Almanya                                             kullandik

//  Soru:  Son row numarasini alalim?
        int rowCount = sheet.getLastRowNum();
        System.out.println("Dosyadaki toplam row(satir) sayisi : "+rowCount); // 10

//  Soru: Kullanilan satirlarin sayisini nasil aliriz? (index 0'dan basliyor)
        int numberOfPhfsicalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Toplam row sayisi :" +numberOfPhfsicalRows); //T oplam row sayisi :12
//  ***      getPhysicalNumberOfRows(); ==> kac satir kullaniliyorsa o sayiyi verir.

//  Soru: Tablodaki tum verileri yazdiralim? ===> Bunun icin HashMap<>() create etmeliyiz
        Map<String, String > countries = new HashMap<>();
        int ulkeColumn = 0;
        int baskentColumn = 1;
        for( int rowNum = 1 ; rowNum<= rowCount ; rowNum++){
            String ulke    = sheet.getRow(rowNum).getCell(ulkeColumn).toString();
            String baskent = sheet.getRow(rowNum).getCell(baskentColumn).toString();

            //hashmap olarak nasil yazdirabilirim???
            countries.put(ulke,baskent);
        }
        System.out.println(countries);

    }
}
