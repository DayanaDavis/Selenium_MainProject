package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SalesCommissionPage extends ObjectUtility {
    public WebDriver driver;
    public SalesCommissionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
}
