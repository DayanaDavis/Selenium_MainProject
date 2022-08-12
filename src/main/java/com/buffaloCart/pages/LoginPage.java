package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ObjectUtility {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//span[@class='help-block']//strong")
    WebElement errorMessage;
    @FindBy(xpath = "//input[@name='remember']")
    WebElement rememberMe;
    @FindBy(xpath = "//a[@class='btn btn-link']")
    WebElement forgotLink;

    public String getLoginPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public void enterUsername(String name) {
        wait.waitUntilVisibilityOfElement(500, driver, userName);
        page.enterText(userName, name);
    }

    public void enterPassword(String pass) {
        wait.waitUntilVisibilityOfElement(500,driver,password);
        page.enterText(password, pass);
    }

    public HomePage clickOnLoginButton() {
        page.clickOnElement(loginButton);
        return new HomePage(driver);
    }

    public String getErrorMessageOfInvalidLogin() {
        String msg = page.getElementText(errorMessage);
        return msg;
    }

    public boolean clickOnRememberMeCheckBox() {
        page.clickOnElement(rememberMe);
        if (rememberMe.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public ResetPasswordPage clickOnForgotPasswordLink() {
        page.clickOnElement(forgotLink);
        return new ResetPasswordPage(driver);
    }
}
