package com.cydeo.tests.crm;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US9_Access_Correct_Modules {

    public WebDriver driver;

    @DataProvider(name = "expected title")
    public Object[][] dpMethod() {
        return new Object[][]{{"Portal"}, {"Site Map"}, {"Workgroups and projects"},
                {"Site Map"}, {"Site Map"}, {"Mailbox Integration"}, {"Contact Center"},
                {"Absence Chart"}, {"Company Structure"}, {"Meeting Rooms"}, {"Company"}};
    }


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1- go to login page
        driver.get(ConfigurationReader.getProperty("env"));
        //2- user login and go to home page
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "expected title")
    public void access_correct_modules_test(String expectedTitle) {
        //3- user should be able to click to any module and go to the right page
        // get the count of thumbs down accounts
        int elementsCount = driver.findElements(By.xpath("//ul[@id='left-menu-list']/li/a")).size();
        System.out.println("Amount of elements: " + elementsCount);

// loop and click through all elements found

        for (int x = 0; x < elementsCount - 1; x++) {
            List<WebElement> modules = driver.findElements(By.xpath("//ul[@id='left-menu-list']/li/a"));
            WebElement eachModule = modules.get(x);
            if ((eachModule.getText()).equals("Chat and Calls")) {
                continue;
            }
            eachModule.click();
            Assert.assertEquals(expectedTitle, driver.getTitle());

            BrowserUtils.sleep(3);
        }


    }

}
