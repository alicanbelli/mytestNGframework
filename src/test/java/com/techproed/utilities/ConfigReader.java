package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
//  ***AMAC:  Bu class'in amaci congiguration.properties dosyasindaki verileri(test data) okumaktir.
//  !!!  Bu class sadece bir kez olusturulur. Belki isyerinde onceden olusturulmus olabilir.

//    create Properties instance
    private static Properties properties;

//    ***** ACIKLAMALAR *****
//    1. FileInputStream kullanarak, bir dosya aciyoruz,
//    2. Properties'i bu dosyaya yukluyoruz,
//    3  Daha sonra properties dosyasini okuyacagiz,

//    4. Baslamak icin static blok olusturduk

    static{
        String path = "configuration.properties"; // adres path'i
        try {
            FileInputStream file = new FileInputStream(path); //
            properties = new Properties();
            properties.load(file);  // ***  Properties'i bu dosyaya yukluyoruz!!!
        } catch (Exception e) { // ==> try { catch{ methodunu import edince kendisi otomatikman olusturdu
            //System.out.println("file path bulunamadi"); ==> istersek yazabiliriz
            e.printStackTrace();
        }
    }
//    Okumak icin static bir method gerekli
//    Bu method kullanici anahtar(key) kelime girdiginde value return eder.
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
