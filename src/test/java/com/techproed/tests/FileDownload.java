package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {

//    Create a class:FileDownload
//    downloadTest()
//    In the downloadTest() method, do the following test:
//    Go to https://the-internet.herokuapp.com/download
//    Download FLOWER.JPG file
//    Then verify if the file downloaded successfully

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement flower = driver.findElement(By.linkText("FLOWER.JPG"));
        flower.click();
        //Path of the file
        //We  must put some wait for the download to complete
        Thread.sleep(5000);

        //We can find the user folder using System.getProperty();
        String userFolder = System.getProperty("user.home");  //User/eminebatar
        System.out.println(userFolder);
        String pathOfTheFile = userFolder + "/Downloads/FLOWER.JPG";

//        String pathOfTheFile = "/Users/eminebatar/Downloads/FLOWER.JPG";
        //boolean isDownloaded = File.exists(Paths.get(file path));
        boolean isDownloaded = Files.exists(Paths.get(pathOfTheFile));
        //Use assertion to check if boolean is true of false
        Assert.assertTrue(isDownloaded);

    }
}
