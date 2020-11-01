package com.techproed.tests;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
//Create a class name : DropDown
//Go to https://the-internet.herokuapp.com/dropdown
//1.Select and Print Option 1 using index
//2.Select and Print Option 2 by value
//3.Select and Print Option 1 by visible text
//4.Print all dropdown values
//5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropdownTest1() throws InterruptedException {
        //Locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        //2.Create Select Object
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
        //1.Select and Print Option 1 using index
        //Step3 Select the option byIndex, or byValue, or byVisibleText
        options.selectByIndex(1);
    }

    @Test
    public void selectByValue() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
    //2.Select and Print Option 2 by value
        options.selectByIndex(2);
    }

    //3.Select and Print Option 1 by visible text
    @Test
    public void selectByVisibleText() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
        options.selectByVisibleText("Option 1");
    }

    //4.Print all dropdown values
    @Test
    public void printAllValue() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
        List<WebElement> allOption = options.getOptions();  //This gives ALL OF THE DROPDOWN OPTIONS
        for(WebElement option:allOption) {
            System.out.println(option.getText());
        }
    }

    //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.
    @Test
    public void dropdownSizeTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
        int actualSizeOfDropdown = options.getOptions().size();
        Assert.assertEquals(actualSizeOfDropdown,4,"EXPECTED IS NOT EQUAL TO ACTUAL");
    }

    @Test
    public void getFirstSelectedOptionTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
        String firstSelectedOption = options.getFirstSelectedOption().getText();
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
