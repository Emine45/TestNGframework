package com.techproed.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomsPage {
    WebDriver driver;

    public HotelRoomsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "ADD HOTELROOM")
    public WebElement addHotelRoomButton;

}
