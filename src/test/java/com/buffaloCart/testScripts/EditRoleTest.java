package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.*;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditRoleTest extends Base{
    LoginPage login;
    HomePage home;
    UsersPage user;
    ExcelUtility excel;
    AddUsersPage addUser;
    FakerUtility faker;
    AddRolesPage addRole;
    RolePage role;
    EditRolePage editRole;
    @Test(description = "TC_024_Verify Edit Role page title",priority = 24,enabled = true,groups = {"regression"})
    public void Verify_Edit_Role_page_title(){
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
        editRole=role.clickOnEditButton();
        String actual_title=editRole.getPageTitle();
        String expected_title = excel.readSingleData(1, 0, "EditRolePage");
        Assert.assertEquals(actual_title,expected_title,"Error:Invalid title");
    }
    @Test(description = "TC_025_Verify user can update a role ",priority = 25,enabled = true,groups = {"regression"})
    public void Verify_user_can_update_a_role (){
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
        String job=faker.jobTitle();
        addRole.enterRole(job);
        addRole.givePermission();
        role=addRole.clickOnSaveButton();
        role.enterValueOnSearch(job);
        editRole=role.clickOnEditButton();
        String edited_job=faker.jobTitle();
        editRole.editRoleTitle(edited_job);
        role=editRole.clickOnUpdateButton();
        role.enterValueOnSearch(edited_job);
        String actual_role=role.getRole();
        Assert.assertEquals(actual_role,edited_job,"Error:invalid job");
    }
}
