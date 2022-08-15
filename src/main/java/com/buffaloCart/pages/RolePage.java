package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RolePage extends ObjectUtility {
    WebDriver driver;
    public RolePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addRole;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement search;
    @FindBy(xpath = "//td[@class='sorting_1']")
    WebElement job;
    @FindBy(xpath = "//i[@class='glyphicon glyphicon-trash']")
    WebElement delete;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement error_NoRole;
    @FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
    WebElement editRole;
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement ok_confirmDelete;
    @FindBy(xpath = "//li[@class='dropdown user user-menu']//a[@class='dropdown-toggle']")
    WebElement userName;
    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signOutButton;
    @FindBy(xpath = "//span[text()='User Management']")
    WebElement userManagementMenu;
    @FindBy(xpath = "//ul[@class='treeview-menu menu-open']//span[@class='title']")
    List<WebElement> userManagementOptions;

     public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
     }
     public AddRolesPage clickOnAddRole(){
         wait.waitUntilVisibilityOfElement(50,driver,addRole);
         page.clickOnElement(addRole);
         return new AddRolesPage(driver);
     }
     public void enterValueOnSearch(String value){
         wait.waitUntilElementIsClickable(50,driver,search);
         page.enterText(search,value);
         wait.hardWait(5000);
     }
     public String getRole(){
         wait.waitUntilVisibilityOfElement(50,driver,job);
         String jobs=page.getElementText(job);
         return jobs;
     }
     public void clickOnDeleteRole(){
         wait.waitUntilVisibilityOfElement(50,driver,delete);
         page.clickOnElement(delete);
         wait.waitUntilVisibilityOfElement(50,driver,ok_confirmDelete);
         page.clickOnElement(ok_confirmDelete);
     }
     public String getErrorMsgForNoRoleFound(){
         wait.waitUntilVisibilityOfElement(50,driver,error_NoRole);
         String msg=page.getElementText(error_NoRole);
         return msg;
     }
     public EditRolePage clickOnEditButton(){
         wait.waitUntilVisibilityOfElement(50,driver,editRole);
         page.clickOnElement(editRole);
         return new EditRolePage(driver);
     }
     public void clickOnUsername(){
         wait.hardWait(5000);
         page.clickOnElement(userName);
     }
     public LoginPage clickOnSignOutButton(){
         wait.waitUntilVisibilityOfElement(50,driver,signOutButton);
         page.clickOnElement(signOutButton);
         return new LoginPage(driver);
     }
    public void clickOnUserManagementMenu() {
        wait.waitUntilVisibilityOfElement(50, driver, userManagementMenu);
        page.clickOnElement(userManagementMenu);
        wait.hardWait(5000);

    }
    public UsersPage clickOnUserMenu() {
        for(int i=0;i< userManagementOptions.size();i++){
            wait.waitUntilVisibilityOfElement(50,driver,userManagementOptions.get(i));
            String value=page.getElementText(userManagementOptions.get(i));
            if(value.equalsIgnoreCase("Users")){
                page.clickOnElement(userManagementOptions.get(i));
            }
            wait.hardWait(5000);
        }
        return new UsersPage(driver);
    }
}
