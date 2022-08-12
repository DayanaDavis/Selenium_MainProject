package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.*;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesCommissionTest extends Base {
    LoginPage login;
    HomePage home;
    UsersPage user;
    ExcelUtility excel;
    AddUsersPage addUser;
    FakerUtility faker;
    SalesCommissionPage sale;
    @Test(description = "TC_028_Verify Sales Commission Agents page title",priority = 28,enabled = true,groups = {"regression"})
    public void verify_Sales_Commission_Agents_page_title(){
        login=new LoginPage(driver);
        excel=new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home = login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        sale=home.clickOnSalesCommission();
        String expected_title=excel.readSingleData(1,0,"SalesCommissionPage");
        String actual_title=sale.getPageTitle();
        Assert.assertEquals(actual_title,expected_title,"Error:invalid title");
    }
}
