package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.AddUsersPage;
import com.buffaloCart.pages.HomePage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.pages.UsersPage;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import com.buffaloCart.utilities.TableUtility;
import com.buffaloCart.utilities.WaitUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPageTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel;
    UsersPage user;
    WaitUtility wait;
    AddUsersPage addUser;
    FakerUtility faker;
    @Test(description = "TC_010_Verify Users page title",priority = 10,enabled = true,groups = {"regression"})
    public void Verify_Users_page_title() throws InterruptedException {
        login = new LoginPage(driver);
        excel=new ExcelUtility();
        wait =new WaitUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home=login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        user=home.clickOnUserMenu();
        String actual_title=user.getUserPageTitle();
        System.out.println(actual_title);
        String expected_title=excel.readSingleData(1,0,"UserPage");
        Assert.assertEquals(actual_title,expected_title,"Error:Invalid Title");
    }
    @Test(description = "TC_011_Verify user search with valid data",priority = 11,groups = {"regression"})
    public void Verify_user_search_with_valid_data(){
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
    @Test(description = "TC_012_Verify message displayed by user search with invalid data",priority = 12,enabled = true,groups = {"smoke"})
    public void Verify_message_displayed_by_user_search_with_invalid_data(){
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
        String email=faker.eMail();
        user.enterSearchValue(email);
        String actual_ErrorMsg=user.getErrorMsgForInvalidUser();
        String expected_ErrorMsg=excel.readSingleData(1,1,"UserPage");
        Assert.assertEquals(actual_ErrorMsg,expected_ErrorMsg,"Error:Invalid Error message");
    }
    @Test(description = "TC_019_Verify user can delete a user",priority = 19,enabled = true,groups = {"regression"})
    public void verify_user_can_delete_a_user(){
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
        user.clickOnDeleteUser();
        user.clickOnOK_confirmDeletion();
        user.enterSearchValue(email);
        String actual_ErrorMsg=user.getErrorMsgForInvalidUser();
        String expected_ErrorMsg=excel.readSingleData(1,1,"UserPage");
        Assert.assertEquals(actual_ErrorMsg,expected_ErrorMsg,"Error:Invalid Error message");
    }

}
