package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {
//    Create a new class: FaceLogin
//    Create a test method: logInTest() and test the following user story
//    When user enter invalid credentials, we should see sign up page
//    https://www.facebook.com/
//    Username: fakeusernam123441231
//    Password: fakeusernam123441231

    @Test
    public void logInTest() throws InterruptedException {
        Driver.getDriver().get("https://www.facebook.com/");
        //Create FaceLoginPage object
        FaceLoginPage faceLoginPage = new FaceLoginPage(driver);
        //send username
        faceLoginPage.username.sendKeys("sdgagarga3erghae");
        faceLoginPage.password.sendKeys("asdgsadfhgsdhfsd");
        faceLoginPage.login.click();
        Thread.sleep(6000);

        String actualErrorMessage = faceLoginPage.errorMessage.getText();
        String expectedErrorMessage = "The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }
}
