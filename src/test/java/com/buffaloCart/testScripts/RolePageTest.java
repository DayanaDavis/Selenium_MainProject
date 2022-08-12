package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.*;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RolePageTest extends Base {
    LoginPage login;
    ExcelUtility excel;
    HomePage home;
    RolePage role;
    FakerUtility faker;
    AddRolesPage addRole;
    @Test(description = "TC_021_Verify Roles page title",priority = 21,enabled = true,groups = {"regression"})
    public void Verify_Roles_page_title(){
        login = new LoginPage(driver);
        excel = new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home = login.clickOnLoginButton();
        home.clickOnEndTour();
        home.clickOnUserManagementMenu();
        role=home.clickOnRoles();
        String actual_title=role.getPageTitle();
        String expected_title=excel.readSingleData(1,0,"RolesPage");
        Assert.assertEquals(actual_title,expected_title,"Error:Invalid Title");
    }
    @Test(description = "TC_026_Verify user can delete a role from the list",priority = 26,enabled = true,groups = {"regression"})
    public void Verify_user_can_delete_a_role_from_the_list(){
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
        role.clickOnDeleteRole();
        String actual_msg=role.getErrorMsgForNoRoleFound();
        String expected_msg=excel.readSingleData(1,1,"RolesPage");
        Assert.assertEquals(actual_msg,expected_msg,"Error:invalid error msg");
    }
}
