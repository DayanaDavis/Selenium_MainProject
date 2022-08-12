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

public class EditUserPageTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel;
    UsersPage user;
    WaitUtility wait;
    AddUsersPage addUser;
    FakerUtility faker;
    EditUserPage editUser;
    @Test(description = "TC_017_Verify Edit User page title",priority = 17,enabled = true,groups = {"regression"})
    public void Verify_Edit_User_page_title(){
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
        editUser=user.clickOnEdit();
        String actual_title=editUser.getPageTitle();
        String expected_title=excel.readSingleData(1,0,"EditUserPage");
        Assert.assertEquals(actual_title,expected_title,"Error:Invalid Title");
    }
    @Test(description = "TC_018_Verify  user can edit the user details",priority = 18,enabled = true,groups = {"regression"})
    public void Verify_user_can_edit_the_user_details(){
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
        editUser=user.clickOnEdit();
        String lName_updated=editUser.editLastName();
        user=editUser.clickOnUpdateButton();
        user.enterSearchValue(email);
        String[] data={uName,fName.concat(" "+lName_updated),job,email};
        List<ArrayList<String>> expectedTable_data=new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data=user.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"Error:Invalid data");
    }
}
