package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.HomePage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.utilities.DateUtility;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.WaitUtility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageTest extends Base {
    HomePage home;
    LoginPage login;
    ExcelUtility excel;
    DateUtility date;
    WaitUtility wait;
    @Test(description = "TC_006_Verify home page title", priority = 6, enabled = true, groups = {"regression"})
    public void Verify_home_page_title() {
        login = new LoginPage(driver);
        excel=new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home=login.clickOnLoginButton();
        String expected_title= excel.readSingleData(1,1,"HomePage");
        String actual_title= home.getHomePageTitle();
        System.out.println(actual_title);
        Assert.assertEquals(actual_title,expected_title,"Error:invalid homepage title");
    }

    @Test(description = "TC_007_Verify date displayed in home page",priority = 7,enabled = true,groups = {"regression"})
    public void Verify_date_displayed_in_home_page(){
        login = new LoginPage(driver);
        excel=new ExcelUtility();
        date=new DateUtility();
        wait=new WaitUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home=login.clickOnLoginButton();
        String actual_date= home.getHomePageDate();
        String expected_date=date.getCurrentDate();
        System.out.println(actual_date);
        Assert.assertEquals(actual_date,expected_date,"Error:invalid Date");
    }
    @Test(description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button",priority = 8,enabled = true,groups = {"smoke"})
    public void Verify_whether_user_is_navigating_to_login_page_by_clicking_on_Sign_out_button(){
        login = new LoginPage(driver);
        excel=new ExcelUtility();
        date=new DateUtility();
        wait=new WaitUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home=login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnHomePageUserName();
        login=home.clickOnSignOutButton();
        String expectedPage_title=excel.readSingleData(1, 0, "LoginPage");
        System.out.println(expectedPage_title);
        String actualPage_title= login.getLoginPageTitle();
        System.out.println(actualPage_title);
        Assert.assertEquals(actualPage_title,expectedPage_title,"Error:invalid page");

    }
    @Test(description = "TC_009_Verify the UserManagement sub tabs",priority = 9,enabled = true,groups = {"regression"})
    public void Verify_the_UserManagement_sub_tabs(){
        login = new LoginPage(driver);
        excel=new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home=login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        List<String> actual_options=home.getUserManagementOptions();
        List<String> expected_options=excel.getExcelAsArrayList("UserManagementPage");
        Assert.assertEquals(actual_options,expected_options,"Error:Invalid Options");
    }

}
