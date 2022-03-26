package com.cydeo.tests.day5_testNG_intro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_StateDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void stateDropdownTest() {
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        //3. Select Illinois
        stateDropdown.selectByIndex(14);
        //4. Select Virginia
        stateDropdown.selectByValue("VA");
        //5. Select California
        stateDropdown.selectByVisibleText("California");
        //6. Verify final selected option is California.
        String expectedSelectedOption = "California";
        String actualSelectionOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualSelectionOption, expectedSelectedOption);
        //Use all Select options. (visible text, value, index


    }
}
