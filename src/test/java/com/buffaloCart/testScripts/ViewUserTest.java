package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.*;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import com.buffaloCart.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewUserTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel;
    UsersPage user;
    WaitUtility wait;
    AddUsersPage addUser;
    FakerUtility faker;
    ViewUserPage viewUser;
    @Test(description = "TC_020_Verify  the details displayed on view user page",priority = 20,enabled = true,groups = {"regression"})
    public void verify_the_details_displayed_on_view_user_page(){
        login=new LoginPage(driver);
        excel=new ExcelUtility();
        faker=new FakerUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home = login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        user=home.clickOnUserMenu();
        addUser=user.clickOnAddUsers();
        String fName= faker.firstName();
        addUser.enterFirstName(fName);
        String lName= faker.lastName();
        addUser.enterLastName(lName);
        String email=faker.eMail();
        addUser.enterEmail(email);
        String job=addUser.selectRole();
        String uName=faker.userName();
        addUser.enterUserName(uName);
        String pass=faker.passWord();
        String percentage=addUser.enterSalesPercentage();
        addUser.enterPassword(pass);
        addUser.enterConfirmPass(pass);
        user=addUser.clickOnSaveButton();
        user.enterSearchValue(email);
        viewUser=user.clickOnViewUser();
        List<String> expected_details=new ArrayList<String>();
        expected_details.add("Email: ".concat(email));
        expected_details.add("Role: ".concat(job));
        expected_details.add("Username: ".concat(uName));
        expected_details.add("Sales Commission Percentage (%): ".concat(percentage)+"%");
        expected_details.add("Active");
        expected_details.add("Sales Commission Percentage (%): ".concat(percentage)+"%");
        expected_details.add("Allowed Contacts: All");
        List<String> actual_userDetails=viewUser.getUserPageDetails();
        Assert.assertEquals(actual_userDetails,expected_details,"Error:Invalid data");
    }
}
