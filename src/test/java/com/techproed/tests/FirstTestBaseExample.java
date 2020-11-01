package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FirstTestBaseExample extends TestBase {
    //Create a Test class
    @Test
    public void test1() {
        driver.get("https://www.google.com/");
    }
}
