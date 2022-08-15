package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.AddUsersPage;
import com.buffaloCart.pages.HomePage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.pages.UsersPage;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddUsersTest extends Base {
    LoginPage login;
    HomePage home;
    UsersPage user;
    ExcelUtility excel;
    AddUsersPage addUser;
    FakerUtility faker;

    @Test(description = "TC_013_Verify the error message displayed without filling mandatory fields in add user form",priority = 13,enabled = true,groups = {"regression"})
    public void verify_the_error_message_displayed_without_filling_mandatory_fields_in_add_user_form(){
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
        String job=addUser.selectRole();
        String uName=faker.userName();
        addUser.enterUserName(uName);
        String pass=faker.passWord();
        addUser.enterPassword(pass);
        addUser.enterConfirmPass(pass);
        user=addUser.clickOnSaveButton();
        String actual_ErrorMsg=addUser.getEmailErrorMsg();
        String expected_ErrorMsg=excel.readSingleData(1,1,"AddUserPage");
        Assert.assertEquals(actual_ErrorMsg,expected_ErrorMsg,"Error:Invalid error Message");
    }
    @Test(description = "TC_014_Verify user login with newly added user",priority = 14,enabled = true,groups = {"regression"})
    public void Verify_user_login_with_newly_added_user(){
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
        addUser.enterPassword(pass);
        addUser.enterConfirmPass(pass);
        user=addUser.clickOnSaveButton();
        login=user.clickOnSignOutButton();
        login.enterUsername(uName);
        login.enterPassword(pass);
        home = login.clickOnLoginButton();
        String actual_UnameDisplay= home.getHomePageUserName();
        String expected_UnameDisplay=fName.concat(" "+lName);
        Assert.assertEquals(actual_UnameDisplay,expected_UnameDisplay,"Error: invalid Login");
    }

    @Test(description = "TC_015_Verify Add Users page title",priority = 15,enabled = true,groups = {"regression"})
    public void verify_Add_Users_page_title(){
        login=new LoginPage(driver);
        excel=new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home = login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        user=home.clickOnUserMenu();
        addUser=user.clickOnAddUsers();
        String expected_title=excel.readSingleData(1,0,"AddUserPage");
        String actual_title=addUser.getPageTitle();
        Assert.assertEquals(actual_title,expected_title,"Error:invalid title");
    }
    @Test(description = "TC_016_Verify user can add user details",priority = 16,enabled = true,groups = {"smoke"})
    public void Verify_user_can_add_user_details(){
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
        addUser.enterPassword(pass);
        addUser.enterConfirmPass(pass);
        user=addUser.clickOnSaveButton();
        user.enterSearchValue(email);
        String[] data={uName,fName.concat(" "+lName),job,email};
        List<ArrayList<String>> expectedTable_data=new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data=user.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"Error:Invalid data");
    }


}
