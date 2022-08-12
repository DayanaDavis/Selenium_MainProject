package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class AddUsersPage extends ObjectUtility {
    public WebDriver driver;

    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first_name")
    WebElement fName;
    @FindBy(id = "last_name")
    WebElement lName;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "username")
    WebElement uName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "confirm_password")
    WebElement confirmPassword;
    @FindBy(xpath = "//select[@id='role']//option")
    List<WebElement> role;
    @FindBy(id = "submit_user_button")
    WebElement saveButton;
    @FindBy(xpath = "//label[@id='email-error']")
    WebElement emailError;
    @FindBy(id = "cmmsn_percent")
    WebElement salesCommission;
    public String getPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public void enterFirstName(String name) {
        wait.waitUntilVisibilityOfElement(500, driver, fName);
        page.enterText(fName, name);
    }

    public void enterLastName(String name) {
        wait.waitUntilVisibilityOfElement(500, driver, lName);
        page.enterText(lName, name);
    }

    public void enterEmail(String emailId) {
        page.enterText(email, emailId);
    }

    public String selectRole() {
        Random rand = new Random();
        int index = rand.nextInt(role.size());
        wait.waitUntilVisibilityOfElement(500, driver, role.get(index));
        String job = page.getElementText(role.get(index));
        page.clickOnElement(role.get(index));
        return job;
    }

    public void enterUserName(String name) {
        wait.waitUntilVisibilityOfElement(500, driver, uName);
        page.enterText(uName, name);
    }

    public void enterPassword(String pass) {
        wait.waitUntilVisibilityOfElement(500, driver, password);
        page.enterText(password, pass);
    }

    public void enterConfirmPass(String pass) {
        wait.waitUntilVisibilityOfElement(500, driver, confirmPassword);
        page.enterText(confirmPassword, pass);
    }

    public UsersPage clickOnSaveButton() {
        wait.waitUntilVisibilityOfElement(500, driver, saveButton);
        page.clickOnElement(saveButton);
        return new UsersPage(driver);
    }

    public String getEmailErrorMsg() {
        wait.waitUntilVisibilityOfElement(500, driver, emailError);
        String msg = page.getElementText(emailError);
        return msg;
    }
    public String enterSalesPercentage(){
        wait.waitUntilVisibilityOfElement(500,driver,salesCommission);
       String percentage= faker.decimalValue();
        page.enterText(salesCommission,percentage);
        return percentage;
    }

}
