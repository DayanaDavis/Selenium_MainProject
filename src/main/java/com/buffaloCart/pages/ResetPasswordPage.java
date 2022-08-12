package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends ObjectUtility {
    public WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement sendResetLink;
    @FindBy(xpath = "//span[@class='help-block']//strong")
    WebElement errorMessage;

    public void enterEmailAddress(String emailId) {
        page.enterText(email, emailId);
    }

    public void clickOnSendPasswordResetLink() {
        page.clickOnElement(sendResetLink);
    }

    public String getErrorMessageOfInvalidEmail() {
        String message = page.getElementText(errorMessage);
        return message;
    }
}
