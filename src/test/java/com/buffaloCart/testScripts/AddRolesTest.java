package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.*;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRolesTest extends Base {
    LoginPage login;
    HomePage home;
    UsersPage user;
    ExcelUtility excel;
    AddUsersPage addUser;
    FakerUtility faker;
    AddRolesPage addRole;
    RolePage role;
    @Test(description = "TC_022_Verify Add Roles page title",priority = 22,enabled = true,groups = {"regression"})
    public void Verify_Add_Roles_page_title(){
        login=new LoginPage(driver);
        excel=new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home = login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        role=home.clickOnRoles();
        addRole=role.clickOnAddRole();
        String actual_title=addRole.getPageTitle();
        String expected_title=excel.readSingleData(1,0,"AddRolesPage");
        Assert.assertEquals(actual_title,expected_title,"Error:invalid title");
    }
    @Test(description = "TC_023_Verify user can add roles",priority = 22,enabled = true,groups = {"smoke"})
    public void Verify_user_can_add_roles(){
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
        role=home.clickOnRoles();
        addRole=role.clickOnAddRole();
        String expected_job=faker.jobTitle();
        addRole.enterRole(expected_job);
        addRole.givePermission();
        role=addRole.clickOnSaveButton();
        role.enterValueOnSearch(expected_job);
        String actual_role=role.getRole();
        Assert.assertEquals(actual_role,expected_job,"Error:invalid job");
    }
}
