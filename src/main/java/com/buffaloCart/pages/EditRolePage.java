package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRolePage extends ObjectUtility {
    public WebDriver driver;
    public EditRolePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "name")
    WebElement roleField;
    @FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
    WebElement updateButton;
    public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public void editRoleTitle(String job){
        wait.waitUntilVisibilityOfElement(500,driver,roleField);
        page.clearText(roleField);
        page.enterText(roleField,job);
    }
    public RolePage clickOnUpdateButton(){
        wait.waitUntilVisibilityOfElement(500,driver,updateButton);
        page.clickOnElement(updateButton);
        return new RolePage(driver);
    }
}
