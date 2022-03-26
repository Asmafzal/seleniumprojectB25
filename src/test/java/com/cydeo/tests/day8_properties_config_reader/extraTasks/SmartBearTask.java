package com.cydeo.tests.day8_properties_config_reader.extraTasks;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Open browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.loginToSmartBear(driver);
    }

    //    TC #1: Smartbear software link verification
    @Test
    public void smartbear_software_link_verification_test() {
        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Count of links on landing page = " + allLinks.size());
        //7. Print out each link text on this page
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
        }
    }

    //TC#2: Smartbear software order placing
    @Test
    public void software_order_placing_test() {
        //6. Click on Order
        driver.findElement(By.linkText("Order")).click();
        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        productDropdown.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys("2");
        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        //10. Click on “visa” radio button
        //11. Generate card number using JavaFaker
        //12. Click on “Process”
        //13. Verify success message “New order has been successfully added.”
    }

    //TC#3: Smartbear software order verification
    @Test
    public void order_verification_test() {
        //2. Click on View all orders
        driver.findElement(By.linkText("View all orders")).click();
        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebTableUtils.orderVerify(driver, "Susan McLaren", "01/05/2010");
    }


}
