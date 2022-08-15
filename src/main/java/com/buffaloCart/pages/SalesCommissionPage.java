package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SalesCommissionPage extends ObjectUtility {
    public WebDriver driver;
    public SalesCommissionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
    WebElement addSalesAgentButton;
    @FindBy(xpath = "//button[@class='btn btn-xs btn-modal btn-primary']")
    WebElement editButton;
    @FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_commsn_agnt_button']")
    WebElement deleteButton;
    @FindBy(id = "surname")
    WebElement prefix;
    @FindBy(id = "first_name")
    WebElement firstName;
    @FindBy(id = "last_name")
    WebElement lastName;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(xpath = "//input[@id='contact_no']")
    WebElement contact;
    @FindBy(id = "address")
    WebElement address;
    @FindBy(id = "cmmsn_percent")
    WebElement salesPercentage;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement search;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr")
    List<WebElement> rowElement;
    @FindBy(xpath = "//table[@class='table table-bordered table-striped dataTable no-footer']/tbody/tr/td")
    List<WebElement> cellElement;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement error_NoMatchingRecord;
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement okButton;

    public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public void clickOnAddSalesAgent(){
        wait.waitUntilVisibilityOfElement(500,driver,addSalesAgentButton);
        page.clickOnElement(addSalesAgentButton);
    }
    public void clickOnDeleteButton(){
        wait.waitUntilVisibilityOfElement(500,driver,deleteButton);
        page.clickOnElement(deleteButton);
        wait.waitUntilVisibilityOfElement(500,driver,okButton);
        page.clickOnElement(okButton);

    }
    public void clickOnEditButton(){
        wait.waitUntilVisibilityOfElement(500,driver,editButton);
        page.clickOnElement(editButton);
    }
    public void enterPrefix(String prefixValue){
        wait.waitUntilVisibilityOfElement(500,driver,prefix);
        page.enterText(prefix,prefixValue);
    }
    public void enterFirstName(String name){
        wait.waitUntilVisibilityOfElement(500,driver,firstName);
        page.enterText(firstName,name);
    }
    public void enterLastName(String name){
        wait.waitUntilVisibilityOfElement(500,driver,lastName);
        page.enterText(lastName,name);
    }
    public void enterEmail(String emailId){
        wait.waitUntilVisibilityOfElement(500,driver,email);
        page.enterText(email,emailId);
    }
    public void enterContactNo(String num){
        wait.waitUntilVisibilityOfElement(500,driver,contact);
        page.enterText(contact,num);
    }
    public void enterAddress(String addressData){
        wait.waitUntilVisibilityOfElement(500,driver,address);
        page.enterText(address,addressData);
    }
    public void enterSalesCommission(String comm){
        wait.waitUntilVisibilityOfElement(500,driver,salesPercentage);
        page.enterText(salesPercentage,comm);
    }
    public void clickOnSaveButton(){
        wait.waitUntilVisibilityOfElement(500,driver,saveButton);
        page.clickOnElement(saveButton);
        wait.hardWait(10000);
    }
    public void enterSearchValue(String searchValue){
        wait.waitUntilVisibilityOfElement(500,driver,search);
        page.clearText(search);
        page.enterText(search,searchValue);
        wait.hardWait(5000);
    }
    public List<ArrayList<String>> getSalesAgentTableData(){
        wait.hardWait(10000);
        List<ArrayList<String>> tableData1=table.getGridData(rowElement,cellElement);
    return tableData1;
    }
    public String getErrorMsgForNonExistingData(){
        wait.waitUntilVisibilityOfElement(500,driver,error_NoMatchingRecord);
        String error=page.getElementText(error_NoMatchingRecord);
        return error;
    }
    public void editContact(String num){
        wait.waitUntilVisibilityOfElement(500,driver,contact);
        page.clearText(contact);
        page.enterText(contact,num);
    }

}
