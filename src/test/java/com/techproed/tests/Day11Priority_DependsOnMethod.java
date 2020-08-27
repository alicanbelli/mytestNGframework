package com.techproed.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day11Priority_DependsOnMethod {

    //normalde method'lari alfabetik siraya gore run ederken,
    // @Test(priority = ...) ile istedigimiz siralamayla method'lari run edebiliriz

    @Test(priority = 1)
    public  void login(){
        System.out.println("Bu login methodudur");

    }
    //(dependsOnMethods ="homePage")    ==>     methodu "" arasina yazdigimiz methoda baglamis oluyoruz.
                                // Burada homePage() methodunu login() methoduna baglamis olduk.

    // dependsOnMethods = "hongi Method'a bagli calismasini istedigimiz MethodIsmi" yazilir.
    // bagladigimiz method'i @Ignore yaparsak ikisi de calismamis olacak.
    // Bagli olan Methodu calistirdigimizda ise Bagli olan Method ve Baglanan Method ikisi de calisir.
    @Test( dependsOnMethods = "login")// *** ===> homePage() methodu login() methoduna bagli!
    public  void homePage(){
        System.out.println("Bu homePage  methodudur");

    }

    @Test(priority = 0)
    public void search(){
        System.out.println("Bu search  methodudur");

    }

    @Test(dependsOnMethods = "search")
    public void result(){
        System.out.println("Bu result  methodudur");

    }

}
