package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1 {
    public static void main(String[] args) {

        /*
        TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
       Expected: Practice
         */

        //do setup for browser driver
        WebDriverManager.chromedriver().setup();

        //open chrome browser
        WebDriver driver = new ChromeDriver();

        //make our page fullscreen
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("cydeo")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is as expected.  Verification Passed!");
        } else {
            System.out.println("Title is not as expected.  Verification Failed!");
        }

        driver.quit();


    }

}
