package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class x {

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get("https://app.billie.io/signup/step1");
        WebElement anrede = Driver.getDriver().findElement(By.xpath("(//i[@role='presentation'])[1]"));
        anrede.click();
        WebElement andereOptions = Driver.getDriver().findElement(By.xpath("(//li[@role='presentation'])[1]"));
        andereOptions.click();
        WebElement firstName=Driver.getDriver().findElement(By.xpath("(//input[@class='fs-hide'])[1]"));
        firstName.sendKeys("Hello");
        WebElement lastName=Driver.getDriver().findElement(By.xpath("(//input[@class='fs-hide'])[2]"));
        lastName.sendKeys("World");
        WebElement email=Driver.getDriver().findElement(By.xpath("(//input[@class='fs-hide'])[3]"));
        email.sendKeys("Hello@gmail.com");
        WebElement password=Driver.getDriver().findElement(By.xpath("(//input[@class='fs-hide'])[4]"));
        password.sendKeys("World123");


    }

}
