package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomTest extends TestBase {

    //Create a clickOnLogin method
    public void clickOnLogin() {
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton .click();
    }

    @Test
    public void createHotelRoom() throws InterruptedException {
        clickOnLogin();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        //Click on Hotel Management
        WebElement hotelManagement=driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
        //Click on Hotel Rooms
        WebElement hotelRooms=driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
        //Click on Add Hotel Room
        Thread.sleep(5000);
        WebElement addHotelRoomButton=driver.findElement(By.partialLinkText("ADD HOTELROOM"));
        addHotelRoomButton.click();
        //Enter All required fields
        WebElement idHotelDropdown=driver.findElement(By.id("IDHotel"));
        Select select=new Select(idHotelDropdown);
        select.selectByIndex(1);
        WebElement code=driver.findElement(By.id("Code"));
        code.sendKeys("12345");
        WebElement name=driver.findElement(By.id("Name"));
        name.sendKeys("Best Hotel");
        WebElement location = driver.findElement(By.id("Location"));
        location.sendKeys("Houston");
        WebElement description = driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        description.sendKeys("This is Royal Class Hotel Room");
        //To enter a price, we can send keys, OR we can use actions class to drag and drop
        Thread.sleep(3000);
        WebElement source=driver.findElement(By.xpath("//li[@data-id='700']"));
        WebElement target= driver.findElement(By.id("Price"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target).perform();
        WebElement roomTypeDropdown=driver.findElement(By.id("IDGroupRoomType"));
        Select select1=new Select(roomTypeDropdown);
        select1.selectByVisibleText("Studio");
        WebElement maxAdultCount=driver.findElement(By.id("MaxAdultCount"));
        maxAdultCount.sendKeys("5");
        WebElement maxChildrenCount=driver.findElement(By.id("MaxChildCount"));
        maxChildrenCount.sendKeys("6");
        WebElement approvedCheckbox=driver.findElement(By.id("IsAvailable"));
        approvedCheckbox.click();
        //Click Save
        Thread.sleep(5000);
        WebElement saveButton= driver.findElement(By.id("btnSubmit"));
        saveButton.click();
        //Explicit wait should be used, becauase implicit wait didn't work fine
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement successMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        //Verify the message: HotelRoom was inserted successfully
//        WebElement successMessage=driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        String successMessageText=successMessage.getText();
        Assert.assertEquals(successMessageText,"HotelRoom was inserted successfully");
        //Click OK
        WebElement okButton=driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();

        //HOME WORK 1: Complete teh next two step
        //Now click on Hotel Rooms
        //Then verify the hotelID = Star on that page
        //HOMEWORK2: As user I should be able to create a room reservation
        //As tester, you decide your test data.
        //Use same manager id and password
    }
}
