package com.cydeo.tests.day5_testNG_intro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_SelectAllValues {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void SelectMultipleValuesTest() {
        //3. Select all the options from multiple select dropdown.
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        //check if this object is multiselect
        System.out.println("dropdown.isMultiple() = " + dropdown.isMultiple());
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            //
        }


    }
    //5. Deselect all values.
}

