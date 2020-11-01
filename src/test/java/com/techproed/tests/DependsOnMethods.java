package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test
    public void logIn() {
        System.out.println("Log in TEST");
    }

    @Test
    public void homePage() {
        System.out.println("Home Page Test");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "homePage")
    public void searchTest() {//I want searchTest to be dependent on homePage. I want seachTest skipped if homePage fails
        System.out.println("Search Test");
    }

    @Test
    public void verifyTheResults() {
        System.out.println("Result Test");
    }
}
