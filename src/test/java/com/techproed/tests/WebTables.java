package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
public class WebTables extends TestBase {
    //PRE CONDITION. THIS IS NOT A TEST CASE
    public void login(){
//Log in  http://www.kaolapalace-qa-environment2.com/
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton=driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
//Click on Hotel Management
        WebElement hotelManagement=driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
//Click on Hotel Rooms
        WebElement hotelRooms=driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
    }
    //    Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
    @Test(groups = "regression1")
    public void entireTable() throws InterruptedException {
        login();
//    Create a test method: entireTable() and
        //Print Entire table body
        Thread.sleep(5000);
        WebElement tBody=driver.findElement(By.xpath("//tbody"));
        //We can identify table body useing tagName
//        WebElement tBody=driver.findElement(By.tagName("tbody"));
        System.out.println(tBody.getText());
        // Find the size of the entire table body
        List<WebElement> tableData=driver.findElements(By.xpath("//td"));
        System.out.println("There are "+tableData.size()+" data.");
        //Another way of printing the entire table data
        for (WebElement eachData:tableData){
            System.out.println(eachData.getText());
        }
//        what is difference for each and tBody.getText()
        //Answer: In for each, i get each data one by one and print them one by one.
        //tBody gives me one SINGLE element that has ALL OF THE DATA AS A WHOLE.
        //and print all of headers
        List<WebElement> allHeaders=driver.findElements(By.xpath("//th"));
        for (WebElement eachHeader:allHeaders){
            System.out.print(eachHeader.getText()+", ");
        }
    }
    //    Create a test method: printRows()
    @Test
    public void printRows(){
        login();
        //and Print all of the rows in the TABLE BODY
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement eachRow:allRows){
            System.out.println(eachRow.getText());
        }
        //and print the elements on the 4th row
        WebElement forthRow=driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(forthRow.getText());
    }
    //    Create a test method: printCells()
    @Test
    public  void printCells(){
        login();
        //and Find the total number of cells in the table body and print all of the cells
        List<WebElement> allCells=driver.findElements(By.xpath("//tbody//td"));
        System.out.println(allCells.size());
        for (WebElement eachCell:allCells){
            System.out.println(eachCell.getText());
        }
    }
    //    Create a test method: printColumns()
    @Test
    public void printColumns() throws InterruptedException {
        login();
        //and print Find the total number of columns
        List<WebElement> allColumns=driver.findElements(By.tagName("th"));
        System.out.println(allColumns.size());
        //and Print the elements of the 5th column
        Thread.sleep(5000);
        List<WebElement> fifthColumn=driver.findElements(By.xpath("//tr//td[5]"));
        //    //tr//td[5]  => give me 5th elements on each row
        for (WebElement eachElement:fifthColumn){
            System.out.println(eachElement.getText());
        }
    }


// printData(3,6); => print the data in row 3 column 6
//Create a test method: printData(int row, int column);
// This method should print the given cell. Example: printData(2,3);
// should print 2nd row,3rd column
    //This custom method will take a row, and a column number
    //and print the data on that row and column
    //This will not be a test method, but this will be a custom method
    public void printData(int row,int column){
//        String xPath="//tbody//tr[9]//td[5]";//NJ
//        String xPath2="//tbody//tr[2]//td[3]";//12746376
        //Only the index numbers keep changing in teh webtable xpath
        String xPath="//tbody//tr["+row+"]//td["+column+"]";
        WebElement data=driver.findElement(By.xpath(xPath));
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest(){
        login();
        printData(2,3);
        printData(5,4);
    }


    //HOMEWORK:
    /*
    Create a test method: webTableHW
    test if the 6th column includes price of 1000
    test if the first table row has Orlando
    test if there 4th column has Hotel name called Hilton
     */
}
