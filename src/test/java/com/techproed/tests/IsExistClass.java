package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class IsExistClass extends TestBase {
    @Test
    public void isExist(){
        //Check if the Flower image is existing on your desktop

        //Find the path of the image
        String pathOfTheFile = "/Users/eminebatar/Desktop/FLOWER. IMG.jpg";

        //We will use JAVA to check if a file exist or not
        boolean isExist = Files.exists(Paths.get(pathOfTheFile));

        //Assert if the path exist
        Assert.assertTrue(isExist);
    }
}
