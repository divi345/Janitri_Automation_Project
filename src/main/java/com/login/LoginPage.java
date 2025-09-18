package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By userIdInput = By.id("formEmail");
    private By passwordInput = By.id("formPassword");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By passwordToggle = By.xpath("//img[@class='passowrd-visible']");
    private By errorMessage = By.xpath("//div[@class='invalid-credential-div']");

    // Methods
    public boolean isLoginButtonEnabled() {
        return wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isEnabled();
    }

    public void enterUserId(String userId) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(userIdInput));
        userField.clear();
        userField.sendKeys(userId);
    }

    public void enterPassword(String password) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passField.clear();
        passField.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void togglePasswordVisibility() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordToggle)).click();
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    public boolean isUserIdFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userIdInput)).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).isDisplayed();
    }

    public boolean isPasswordToggleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordToggle)).isDisplayed();
    }
}
