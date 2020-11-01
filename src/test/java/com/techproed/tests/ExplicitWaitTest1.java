package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest1 extends TestBase {
//    Create a class:ExplicitWaitTest1. Create a method: isEnabled
//    Go to https://the-internet.herokuapp.com/dynamic_controls
//    Click enable Button
//    And verify the message is equal to “It's enabled!”
//    And verify the textbox is enabled (I can type in the box)
      //Hint: isEnable(); Similar to Displayed();
//    And click on Disable button
//    And verify the message is equal to “It's disabled!”
//    And verify the textbox is disabled (I cannot type in the box)

    @Test
    public void isEnabled() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Click enable Button
        WebElement enableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        //    And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String enableMessageText = enabledMessage.getText();
        Assert.assertEquals(enableMessageText, "It's enabled!");

        //    And verify the textbox is enabled (I can type in the box)
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.isEnabled();  //isEnabled is used to understand if an element is enabled.
        Assert.assertTrue(inputBox.isEnabled());
        //Hint: isEnable(); Similar to Displayed();
//    And click on Disable button
        WebElement disableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        disableButton.click();
//    And verify the message is equal to “It's disabled!”
       WebElement disableMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       String disableMessageText = disableMessage.getText();
       Assert.assertEquals(disableMessageText, "It's disabled!");
//    And verify the textbox is disabled (I cannot type in the box)
        WebElement inputBox1 = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!inputBox1.isEnabled());

    }
}
