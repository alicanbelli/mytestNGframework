package com.techproed.tests;

import org.testng.annotations.*;

public class Day10TestNGAnnotations {

        //En buyuk @Before en basta @BeforeSuit, ....
        //En buyuk @After en sonda yazar @AfterSuit, .....

//    @BeforeSuite
//      @BeforeTest
//          @BeforeClass
//              @BeforeMethod
//                  @Test
//              @AfterMethod
//          @AfterClass
//      @AfterTest
//    @AfterSuite

    @Ignore // @Ignore sadece @Test annotationlarda calisir. yani nerde run varsa orda calisir.
            // Burada kullanmanin bir etkisi yok, cunku altinda @Test yok, run yok.
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("======== Before Method =======");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("======== Before Class ========"); //@BeforeClass sadece bir kez yazar.cunku class bir tane
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("======= Before Test ========");
    }


    @Test       //dependency eksik oldugundan kirmizi yaziyor. dependency'ler yuklenince import yap!
    public void test1() {
        System.out.println("Bu test1 metodudur");
    }

    @Test
    public void test2() {
        System.out.println("Bu test2 metodudur");
    }

    @Ignore
    @Test
    public void test3() {
        System.out.println("Bu test3 metodudur");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("---------- After Method ----------");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("------- After Class -------");//@AfterClasssadece bir kez yazar.cunku class bir tane
    }

    @AfterTest
    public void afterTest() {
        System.out.println("-------- After Test ----------");

    }
}
