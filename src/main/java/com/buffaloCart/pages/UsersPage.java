package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends ObjectUtility {
    public WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement Add;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement search;
    @FindBy(xpath = "//table[@id='users_table']/tbody/tr")
    List<WebElement> rawElements;
    @FindBy(xpath = "//table[@id='users_table']/tbody/tr/td")
    List<WebElement> cellElements;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement invalidUserErrorMsg;
    @FindBy(xpath = "//a[@class='btn btn-xs btn-primary']")
    WebElement edit;
    @FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
    WebElement deleteUser;
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement oK_confirmDelete;
    @FindBy(xpath = "//a[@class='btn btn-xs btn-info']")
    WebElement view_userInformation;
    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a[@class='dropdown-toggle']")
    WebElement userName;
    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signOutButton;


    public String getUserPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public AddUsersPage clickOnAddUsers() {
        wait.waitUntilVisibilityOfElement(1000, driver, Add);
        page.clickOnElement(Add);
        wait.hardWait(20000);
        return new AddUsersPage(driver);
    }

    public void enterSearchValue(String email) {
        wait.waitUntilVisibilityOfElement(500,driver,search);
        page.enterText(search, email);
        wait.hardWait(10000);
    }

    public List<ArrayList<String>> getTableData(){
        List<ArrayList<String>> tableData=table.getGridData(rawElements,cellElements);
        return tableData;
    }

    public String getErrorMsgForInvalidUser(){
        wait.waitUntilVisibilityOfElement(500,driver,invalidUserErrorMsg);
        String msg=page.getElementText(invalidUserErrorMsg);
        return msg;
    }
    public EditUserPage clickOnEdit(){
        wait.waitUntilVisibilityOfElement(500,driver,edit);
        page.clickOnElement(edit);
        return new EditUserPage(driver);
    }
    public void clickOnDeleteUser(){
        wait.waitUntilVisibilityOfElement(500,driver,deleteUser);
        page.clickOnElement(deleteUser);
    }
    public void clickOnOK_confirmDeletion(){
        wait.waitUntilVisibilityOfElement(500,driver,oK_confirmDelete);
        page.clickOnElement(oK_confirmDelete);
    }
    public ViewUserPage clickOnViewUser(){
        wait.waitUntilVisibilityOfElement(500,driver,view_userInformation);
        page.clickOnElement(view_userInformation);
        return new ViewUserPage(driver);
    }

    public LoginPage clickOnSignOutButton(){
        wait.hardWait(10000);
        page.clickUsingJavaScript(driver,userName);
        wait.waitUntilVisibilityOfElement(500,driver,signOutButton);
        page.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
}
