package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ViewUserPage extends ObjectUtility {
    public WebDriver driver;
    public ViewUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='profile-username']")
    WebElement profileName;
    @FindBy(xpath = "//div[@class='row']//div[@class='col-md-6']//p")
    List<WebElement> userPageInformation;
    public List<String> getUserPageDetails(){
        wait.waitUntilVisibilityOfElement(500,driver,profileName);
        List<String> userInfo=new ArrayList<String>();
        for(int i=0;i<userPageInformation.size();i++){
            userInfo.add(page.getElementText(userPageInformation.get(i)));
        }
        return userInfo;
    }
}
