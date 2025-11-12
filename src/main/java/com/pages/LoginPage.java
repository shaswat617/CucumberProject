package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // 1. By Locators = Object Repository
    private By emailId = By.id("Email");
    private By password = By.id("Password");
    private By forgotPasswordLinkText = By.xpath("//a[@href='/passwordrecovery']");
    private By signInButton = By.xpath("//input[@value='Log in']");

    // 2. Constructor of page class
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // 3. Page Actions : features(behaviour) of page or basically page methods
    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkExists()
    {
        return driver.findElement(forgotPasswordLinkText).isDisplayed();
    }

    public void enterUsername(String uName)
    {
        driver.findElement(emailId).sendKeys(uName);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin()
    {
        driver.findElement(signInButton).click();
    }

    public LandingPage doLogin(String uName, String pwd)
    {
        driver.findElement(emailId).sendKeys(uName);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        System.out.println("Login button clicked successfully");
        return new LandingPage(driver);
    }


}
