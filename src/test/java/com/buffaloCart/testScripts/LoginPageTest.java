package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.HomePage;
import com.buffaloCart.pages.LoginPage;
import com.buffaloCart.pages.ResetPasswordPage;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    LoginPage login;
    ExcelUtility excel;
    HomePage home;
    FakerUtility faker;
    ResetPasswordPage reset;
    @Test(description = "TC_001_Verify Login page title", priority = 1, enabled = true, groups = {"regression"})
    public void Verify_Login_page_title() {
        login = new LoginPage(driver);
        excel = new ExcelUtility();
        String expected_title = excel.readSingleData(1, 0, "LoginPage");
        String actual_title = login.getLoginPageTitle();
        System.out.println(actual_title);
        Assert.assertEquals(actual_title, expected_title, "Error:Invalid login page title");
    }

    @Test(description = "TC_002_Verify user login with valid user credentials", priority = 2, enabled = true, groups = {"smoke"})
    public void Verify_User_login_with_valid_user_credentials() {
        login = new LoginPage(driver);
        excel = new ExcelUtility();
        String username = excel.readSingleData(1, 1, "LoginPage");
        String password = excel.readSingleData(1, 2, "LoginPage");
        login.enterUsername(username);
        login.enterPassword(password);
        home = login.clickOnLoginButton();
        String expected_username = excel.readSingleData(1, 0, "HomePage");
        String actual_Username = home.getHomePageUserName();
        Assert.assertEquals(actual_Username, expected_username, "Error:Invalid login");
    }

    @Test(description = "TC_003_Verify the error message displayed for user login with invalid credentials", priority = 3, enabled = true, groups = {"regression"})
    public void Verify_the_error_message_displayed_for_user_login_with_invalid_credentials() {
        login = new LoginPage(driver);
        faker = new FakerUtility();
        excel = new ExcelUtility();
        String userName = faker.userName();
        login.enterUsername(userName);
        String password = faker.passWord();
        login.enterPassword(password);
        login.clickOnLoginButton();
        String expected_message = excel.readSingleData(1, 3, "LoginPage");
        String actual_message = login.getErrorMessageOfInvalidLogin();
        Assert.assertEquals(actual_message, expected_message, "Error:Invalid Message");
    }

    @Test(description = "TC_004_Verify whether the user is able to click on 'Remember me' checkbox", priority = 4, enabled = true, groups = {"regression"})
    public void Verify_whether_the_user_is_able_to_click_on_Remember_me_checkbox(){
    login=new LoginPage(driver);
    boolean remember=login.clickOnRememberMeCheckBox();
    Assert.assertTrue(remember);
    }

    @Test(description = "TC_005_Verify error message displayed on  Reset Password page with invalid email id",priority = 5,enabled = true,groups = {"regression"})
    public void Verify_error_message_displayed_on_Reset_Password_page_with_invalid_email_id(){
    login=new LoginPage(driver);
    excel=new ExcelUtility();
    faker=new FakerUtility();
    String emailAddress=faker.eMail();
    reset= login.clickOnForgotPasswordLink();
    reset.enterEmailAddress(emailAddress);
    reset.clickOnSendPasswordResetLink();
    String expected_message=excel.readSingleData(1,0,"ResetPage");
    String actual_message=reset.getErrorMessageOfInvalidEmail();
    Assert.assertEquals(actual_message,expected_message,"Error:Invalid Message");
    }
}
