package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.login.LoginPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void testLoginWithBlankFieldsShowsError() throws InterruptedException {
	    LoginPage loginPage = new LoginPage(driver);

	    // Enter blank User ID and Password
	    loginPage.enterUserId("");
	    Thread.sleep(2000); // wait 2 seconds

	    loginPage.enterPassword("");
	    Thread.sleep(2000); // wait 2 seconds

	    // Click login
	    loginPage.clickLogin();
	    Thread.sleep(2000); // wait 2 seconds for error message to appear

	    // Verify error message
	    String error = loginPage.getErrorMessage();
	    Assert.assertFalse(error.isEmpty(), "Error message should appear for blank fields");
	}

	@Test(priority = 2)
	public void testInvalidLoginShowsError() throws InterruptedException {
	    LoginPage loginPage = new LoginPage(driver);

	    // Enter random credentials
	    loginPage.enterUserId("randomUser");
	    Thread.sleep(2000); // wait 2 seconds

	    loginPage.enterPassword("randomPass");
	    Thread.sleep(2000); // wait 2 seconds

	    // Click login
	    loginPage.clickLogin();
	    Thread.sleep(2000); // wait 2 seconds for error message to appear

	    // Capture and print error message
	    String error = loginPage.getErrorMessage();
	    System.out.println("Error Message Displayed: " + error);

	    // Verify error message is shown
	    Assert.assertFalse(error.isEmpty(), "Error message should be displayed for invalid login");
	}


	@Test(priority = 3)
	public void testPasswordMaskedButton() {
	    LoginPage loginPage = new LoginPage(driver);

	    // Enter password
	    loginPage.enterPassword("password123");

	    // Verify masked initially
	    Assert.assertEquals(loginPage.getPasswordFieldType(), "password", 
	        "Password should be masked initially");

	    // Toggle to show
	    loginPage.togglePasswordVisibility();
	    Assert.assertEquals(loginPage.getPasswordFieldType(), "text", 
	        "Password should be visible after toggling");

	    // Toggle back to mask
	    loginPage.togglePasswordVisibility();
	    Assert.assertEquals(loginPage.getPasswordFieldType(), "password", 
	        "Password should be masked again after second toggle");
	}



@Test(priority = 4)
public void testPageElementsPresence() {
    LoginPage loginPage = new LoginPage(driver);

    Assert.assertTrue(loginPage.isUserIdFieldDisplayed(), "User ID input should be displayed");

    Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password input should be displayed");

    
    Assert.assertTrue(loginPage.isPasswordToggleDisplayed(), "Password eye icon should be displayed");

    
    Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button should be displayed & enabled");

    
    String title = driver.getTitle();
    System.out.println("Page Title: " + title);
    Assert.assertTrue(title.contains("Janitri"), "Page title should contain 'Janitri'");
}
}
