package com.techproed.tests;

import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class FirstDriverTest {

    @Test
    public void firstDriverTest(){
//    When user goes to the application http://www.kaolapalace-qa-environment2.com/
//    And click on the Login button
//    Then verify user is able to log in
        //driver   ==== >>>>>>>  Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("kaola_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage(Driver.getDriver());
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage(Driver.getDriver());
        kaolaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
        //Closing the driver
        Driver.closeDriver();
    }
}

