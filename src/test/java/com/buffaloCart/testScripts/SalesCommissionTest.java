package com.buffaloCart.testScripts;

import com.buffaloCart.automationCore.Base;
import com.buffaloCart.pages.*;
import com.buffaloCart.utilities.ExcelUtility;
import com.buffaloCart.utilities.FakerUtility;
import com.github.javafaker.PhoneNumber;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesCommissionTest extends Base {
    LoginPage login;
    HomePage home;
    ExcelUtility excel;
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
    @Test(description = "TC_029_Verify user can add sales  agent ",priority = 29,enabled = true,groups = {"regression"})
    public void Verify_user_can_add_sales_agent (){
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
        sale=home.clickOnSalesCommission();
        sale.clickOnAddSalesAgent();
        String prefix=faker.prefix();
        String fName=faker.firstName();
        String lName=faker.lastName();
        String email=faker.eMail();
        String contact= faker.contactNumber();
        String address=faker.address();
        String salesComm=faker.decimalValue();
        sale.enterPrefix(prefix);
        sale.enterFirstName(fName);
        sale.enterLastName(lName);
        sale.enterEmail(email);
        sale.enterContactNo(contact);
        sale.enterAddress(address);
        sale.enterSalesCommission(salesComm);
        sale.clickOnSaveButton();
        sale.enterSearchValue(email);
        String data[]={prefix.concat(" "+fName+" "+lName),email,contact,address,salesComm};
        List<ArrayList<String>> expected_data=new ArrayList<ArrayList<String>>();
        expected_data.add(new ArrayList<>(Arrays.asList(data)));
        List<ArrayList<String>> actual_data=sale.getSalesAgentTableData();
        Assert.assertEquals(actual_data,expected_data,"Error:Invalid data");
    }
    @Test(description = "TC_030_Verify Edit sales agent details",priority = 30,enabled = true,groups = {"regression"})
    public void Verify_user_can_Edit_sales_agent_details(){
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
        sale=home.clickOnSalesCommission();
        sale.clickOnAddSalesAgent();
        String prefix=faker.prefix();
        String fName=faker.firstName();
        String lName=faker.lastName();
        String email=faker.eMail();
        String contact= faker.contactNumber();
        String address=faker.address();
        String salesComm=faker.decimalValue();
        sale.enterPrefix(prefix);
        sale.enterFirstName(fName);
        sale.enterLastName(lName);
        sale.enterEmail(email);
        sale.enterContactNo(contact);
        sale.enterAddress(address);
        sale.enterSalesCommission(salesComm);
        sale.clickOnSaveButton();
        sale.enterSearchValue(email);
        sale.clickOnEditButton();
        String new_contact=faker.contactNumber();
        sale.editContact(new_contact);
        sale.clickOnSaveButton();
        sale.enterSearchValue(email);
        String data[]={prefix.concat(" "+fName+" "+lName),email,new_contact,address,salesComm};
        List<ArrayList<String>> expected_data=new ArrayList<ArrayList<String>>();
        expected_data.add(new ArrayList<>(Arrays.asList(data)));
        List<ArrayList<String>> actual_data=sale.getSalesAgentTableData();
        Assert.assertEquals(actual_data,expected_data,"Error:Invalid data");

    }
    @Test(description = "TC_031_Verify user can delete a Sales Commission Agents",priority = 31,enabled = true,groups = {"regression"})
    public void Verify_user_can_delete_a_Sales_Commission_Agents(){
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
        sale=home.clickOnSalesCommission();
        sale.clickOnAddSalesAgent();
        String prefix=faker.prefix();
        String fName=faker.firstName();
        String lName=faker.lastName();
        String email=faker.eMail();
        String contact= faker.contactNumber();
        String address=faker.address();
        String salesComm=faker.decimalValue();
        sale.enterPrefix(prefix);
        sale.enterFirstName(fName);
        sale.enterLastName(lName);
        sale.enterEmail(email);
        sale.enterContactNo(contact);
        sale.enterAddress(address);
        sale.enterSalesCommission(salesComm);
        sale.clickOnSaveButton();
        sale.enterSearchValue(email);
        sale.clickOnDeleteButton();
        String actual_errorMsg=sale.getErrorMsgForNonExistingData();
        String expected_msg=excel.readSingleData(1,1,"SalesCommissionPage");
        Assert.assertEquals(actual_errorMsg,expected_msg,"Error: invalid data");
    }
}
