package com.cydeo.tests.day8_properties_config_reader.extraTasks;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_Find_Elements {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to: https://www.openxcell.com
        driver.get("https://www.openxcell.com");
    }


    //TC #1: Checking the number of links on the page
    @Test
    public void number_of_links_test() {
        //    3. Count the number of the links on the page and verify
        List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));
        //Expected: 332
        int expectedNumberOfLinks = 325;
        int actualNumberOfLinks = noOfLinks.size();
        Assert.assertEquals(actualNumberOfLinks, expectedNumberOfLinks);

    }

    //TC #2: Printing out the texts of the links on the page
    @Test
    public void texts_of_links_test() {
        //  3. Print out all of the texts of the links on the page
        List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));
        try {
            for (WebElement eachLink : noOfLinks) {
                System.out.println("Link text = " + eachLink.getText());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //TC #3: Counting the number of links that does not have text
    @Test
    public void count_links_with_no_text_test_() {
        // 3. Count the number of links that does not have text and verify
        //Expected: 109
        List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));
        int count = 0;
        for (WebElement eachLink : noOfLinks) {
            if (eachLink.getText().isEmpty()) {
                count++;
            }
        }
        System.out.println(count);


    }


}
