package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRolesPage extends ObjectUtility {
    WebDriver driver;
    public AddRolesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "name")
    WebElement roleName;
    @FindBy(xpath = "//div[@class='col-md-2']//div[@class='icheckbox_square-blue']")
    List<WebElement> permission;
    @FindBy(xpath = "//button[@class='btn btn-primary pull-right']")
    WebElement saveButton;

    public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public void enterRole(String role){
        wait.waitUntilVisibilityOfElement(50,driver,roleName);
        page.enterText(roleName,role);
    }
    public void givePermission(){
        for (int i=0;i<permission.size();i++){
            wait.waitUntilVisibilityOfElement(50,driver,permission.get(i));
            page.clickOnElement(permission.get(i));
        }
    }
    public RolePage clickOnSaveButton(){
        wait.waitUntilVisibilityOfElement(50,driver,saveButton);
        page.clickOnElement(saveButton);
        wait.hardWait(5000);
        return new RolePage(driver);
    }

}
