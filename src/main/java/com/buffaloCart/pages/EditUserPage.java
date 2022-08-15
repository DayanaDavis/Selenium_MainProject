package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage extends ObjectUtility {
    WebDriver driver;
    public EditUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="last_name")
    WebElement lastName;
    @FindBy(id = "submit_user_button")
    WebElement updateButton;
    public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public String editLastName(){
        wait.waitUntilVisibilityOfElement(50,driver,lastName);
        page.clearText(lastName);
        String lName= faker.lastName();
        page.enterText(lastName,lName);
        return lName;
    }
    public UsersPage clickOnUpdateButton(){
        wait.waitUntilVisibilityOfElement(50,driver,updateButton);
        page.clickOnElement(updateButton);
        return new UsersPage(driver);
    }

}
