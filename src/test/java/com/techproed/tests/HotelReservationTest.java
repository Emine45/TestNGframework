package com.techproed.tests;
import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HotelReservationTest  {
    //REFACTOR: Refactoring is done to make existing codes better.
    //CREATE A SEPARATE LOG IN METHOD
    //CREATE A PAGE CLASS TO STORE PAGE OBJECTS
    //USE THAT PAGE OBJECTS IN THIS CLASS.

    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("kaola_url"));
        KaolaMainPage kaolaMainPage=new KaolaMainPage(Driver.getDriver());
        kaolaMainPage.kaolaMainLoginButton.click();
        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage(Driver.getDriver());
        kaolaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();
    }

    @Test
    public void reservationTest(){
        login();
        WebElement clickOnLogin = Driver.getDriver().findElement(By.xpath("(//input)[4]"));
        clickOnLogin.click();
        WebElement hotelManagement = Driver.getDriver().findElement(By.xpath("(//span[@class='title'])[3]"));
        hotelManagement.click();
        WebElement roomReservation = Driver.getDriver().findElement(By.xpath("//a[@href='/admin/RoomReservationAdmin']"));
        roomReservation.click();
        WebElement addRoomReservation = Driver.getDriver().findElement(By.xpath("//span[@class ='hidden-480']"));
        addRoomReservation.click();
        WebElement selectUser = Driver.getDriver().findElement(By.xpath("(//select)[1]"));
        Select selectSelectUser = new Select(selectUser);
        selectSelectUser.selectByIndex(1);
        WebElement selectRoom = Driver.getDriver().findElement(By.xpath("(//select)[2]"));
        Select selectSelectRoom = new Select(selectRoom);
        selectSelectRoom.selectByVisibleText("King Room");
        WebElement price = Driver.getDriver().findElement(By.xpath("(//input)[1]"));
        price.sendKeys("600");
        Driver.getDriver().findElement(By.xpath("//input[@name='DateStart']")).sendKeys("09/26/2020");
        Driver.getDriver().findElement(By.xpath("//input[@id = 'DateEnd']")).sendKeys("09/30/2020");
        Driver.getDriver().findElement(By.xpath("//input[@id = 'AdultAmount']")).sendKeys("2");
        Driver.getDriver().findElement(By.xpath("//input[@id = 'ChildrenAmount']")).sendKeys("2");
        Driver.getDriver().findElement(By.xpath("//input[@id = 'ContactPhone']")).sendKeys("0491255544");
        Driver.getDriver().findElement(By.xpath("//input[@id='ContactNameSurname']")).sendKeys("Memet ekici");
        Driver.getDriver().findElement(By.xpath("//input[@id='ContactEmail']")).sendKeys("ggg@gmail.com");
        Driver.getDriver().findElement(By.xpath("//input[@id='Notes']")).sendKeys("Herşey ok");
        Driver.getDriver().findElement(By.xpath("//input[@id='IsPaid']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='btnSubmit']")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        
        String message = Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).getText();
        System.out.println(message);
        Assert.assertEquals(message,"RoomReservation was inserted successfully");
        Driver.getDriver().findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
    }
}