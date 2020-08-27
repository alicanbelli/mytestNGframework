package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void writeExcel() throws IOException {
        String path = ".\\src\\test\\resources\\ULKELER.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);  //   file'i acalim

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // 1.sheet'e git
        Row row = sheet.getRow(0);     // 1.Row'a git
        Cell cell = row.createCell(3); // 3. index'li cell'i creat ediyoruz
        cell.setCellValue("NUFUS"); // creat ettigimiz cell'e setCellValue() 'le value gonderiyoruz.
//      ***     setCellValue() ile veri gonderiyoruz/koyuyoruz!

//         Nasil create edilen cell'e birseyler Yazilabilir?
//        Asagidaki satir file acarak, uzerine yazar
        FileOutputStream fileOutputStream = new FileOutputStream(path);// veri yuklemek icin path / yol

        Cell cell1 = row.createCell(4); // 4. index'i create ediyoruz
        cell1.setCellValue("YUZOLCUMU"); // artik 4. index'te YUZOLCUMU basligi var.

//        hucreyi SILMEK icin removeCell()
        row.removeCell(cell1); // artik 4. index'te bulunan YUZOLCUMU basligi yok silindi

        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83000000"); //2. satira 83000000 yazacak
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10000000"); //3. satira 10000000 yazacak
        workbook.getSheetAt(0).getRow(3).createCell(3).setCellValue("83000000"); //4. satira 83000000 yazacak
        workbook.getSheetAt(0).getRow(4).createCell(3).setCellValue("13000000"); //5. satira 13000000 yazacak
        workbook.getSheetAt(0).getRow(5).createCell(3).setCellValue("35000000"); //6. satira 35000000 yazacak

        workbook.write(fileOutputStream); //cell'e value yazar ve save eder, dolayisyla en SONDA olmali

        fileInputStream.close();      // *** bu objeler kapatilmadan bazen FAIL alinabiliniyor,
        fileOutputStream.close();     //     bunu onlemek icin bu close()'lar kullanilmali...
        workbook.close();             // arka planda actiklarini kapatarak calisiyor,yoksa acilip kapanan bir web sitesi yok

    }
}
