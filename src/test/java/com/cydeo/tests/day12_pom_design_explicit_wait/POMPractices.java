package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setup() {
        //  1- Open a chrome browser
//        2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void required_field_error_message_test() {
//        4- Click to “Sign in” button
        libraryLoginPage.signInButton.click();
//        5- Verify expected error is displayed:
//        Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
    }

    @Test
    public void invalid_email_format_error_message_test() {
        //        3- Enter invalid email format
        libraryLoginPage.inputUsername.sendKeys("abcdasd" + Keys.ENTER);
//        4- Verify expected error is displayed:
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
//        Expected: Please enter a valid email address.
    }

    @Test
    public void library_negative_login() {
        //        3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUsername.sendKeys("asma@hotmail.com" + Keys.ENTER);
//        4- Verify title expected error is displayed:
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
//        Expected: Sorry, Wrong Email or Password
    }
}
