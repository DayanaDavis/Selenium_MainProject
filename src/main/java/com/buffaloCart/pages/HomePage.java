package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends ObjectUtility {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']//span")
    WebElement userName;
    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
    WebElement homePageDate;
    @FindBy(xpath = "//div[@class='pull-right']//a")
    WebElement signOutButton;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;
    @FindBy(xpath = "//span[text()='User Management']")
    WebElement userManagementMenu;
    @FindBy(xpath = "//ul[@class='treeview-menu menu-open']//span[@class='title']")
    List<WebElement> userManagementOptions;


    public String getHomePageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public String getHomePageUserName() {
        String user = page.getElementText(userName);
        return user;
    }

    public String getHomePageDate() {
        String date = page.getElementText(homePageDate);
        return date;
    }

    public void clickOnHomePageUserName() {
        wait.waitUntilVisibilityOfElement(50, driver, userName);
        page.clickOnElement(userName);
    }

    public LoginPage clickOnSignOutButton() {
        wait.waitUntilVisibilityOfElement(50, driver, signOutButton);
        page.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }

    public void clickOnEndTour() {
        wait.hardWait(2000);
        if(endTour.isDisplayed()){
            page.clickOnElement(endTour);
        }
    }

    public void clickOnUserManagementMenu() {
        wait.waitUntilVisibilityOfElement(50, driver, userManagementMenu);
        page.clickOnElement(userManagementMenu);
        wait.hardWait(5000);

    }

    public List<String> getUserManagementOptions() {
        System.out.println(userManagementOptions.size());
        List<String> values=new ArrayList<String>();
        for (int i = 0; i < userManagementOptions.size(); i++) {
            wait.waitUntilVisibilityOfElement(50, driver, userManagementOptions.get(i));
            values.add(page.getElementText(userManagementOptions.get(i)));
        }
        return values;
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
    public RolePage clickOnRoles(){
        for(int i=0;i< userManagementOptions.size();i++){
            wait.waitUntilVisibilityOfElement(50,driver,userManagementOptions.get(i));
            String value=page.getElementText(userManagementOptions.get(i));
            if(value.equalsIgnoreCase("Roles")){
                page.clickOnElement(userManagementOptions.get(i));
            }
        }
        return new RolePage(driver);
    }
    public SalesCommissionPage clickOnSalesCommission(){
        for(int i=0;i< userManagementOptions.size();i++){
            wait.waitUntilVisibilityOfElement(50,driver,userManagementOptions.get(i));
            String value=page.getElementText(userManagementOptions.get(i));
            if(value.equalsIgnoreCase("Sales Commission Agents")){
                page.clickOnElement(userManagementOptions.get(i));
            }
        }
        return new SalesCommissionPage(driver);
    }
}
