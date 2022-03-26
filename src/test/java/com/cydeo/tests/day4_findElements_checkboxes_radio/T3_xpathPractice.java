package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_xpathPractice {
    public static void main(String[] args) {
//        XPATH Practice
//        DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
//        TC #6:  XPATH LOCATOR practice
//        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

//        3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

//        4. Verify text displayed is as expected:
//        Expected: “Clicked on button one!”
        WebElement textDisplayed = driver.findElement(By.xpath("//p[.='Clicked on button one!']"));

        String expectedText = "Clicked on button one!";
        String actualText = textDisplayed.getText();

        System.out.println("expectedText = " + expectedText);
        System.out.println("actualText = " + actualText);

        if (actualText.equals(expectedText)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED");
        }

//
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}
