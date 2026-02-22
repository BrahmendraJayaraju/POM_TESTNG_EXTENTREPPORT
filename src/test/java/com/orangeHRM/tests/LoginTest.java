package com.orangeHRM.tests;




import org.testng.annotations.Test;

import com.orangeHRM.generic.AdminBaseControl;

import com.orangeHRM.generic.WebUtilityKeys;
import com.orangeHRM.pages.LoginPage;

public class LoginTest extends AdminBaseControl {

	LoginPage  login;

    public static String objectRepologin = "/ObjectRepository/Login.properties";
    public static String objectdashboard = "/ObjectRepository/Dashboard.properties";
    
    public static String testDatalogin   = "/TestData/TestLogin.properties";
    public static String  testDataDashboard   = "/TestData/TestDashboard.properties";
    public static String filepath   = "/TestEnviornmentSetUp/BasicTestSetUp.properties";
   
    
   




    @Test(priority = 0, groups = { "Regression" })
    public void TC46043_verifyInvalidLoginFunctionality() throws Exception {

        String usernameXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "username_xpath");
        String passwordXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "password_xpath");
        String loginBtnXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "login_btn_xpath");
        String errorXpath      = WebUtilityKeys.readPropertyFiles(objectRepologin, "invalidpassworderror_xpath");

        String username        = WebUtilityKeys.readPropertyFiles(testDatalogin , "username");
        String invalidPassword = WebUtilityKeys.readPropertyFiles(testDatalogin , "Invalidpassword");
        String errorMessage    = WebUtilityKeys.readPropertyFiles(testDatalogin , "Errormessage");

        WebUtilityKeys.createTestName(
                "TC46043 verify invalid Login Functionality",
                "TesterName=brahmendra.jayaraju@gmail.com"
        );
        
        this.login=new LoginPage(driver);

        this.login.enterUsername(usernameXpath, username);
        this.login.enterPassword(passwordXpath, invalidPassword);
        this.login.clickOnLogin(loginBtnXpath);
        this.login.VerifyInvalidError_message(errorXpath, errorMessage);
    }
    
    
    
    @Test(priority = 1, groups = { "Regression" })
    public void TC46042_verifyValidLoginFunctionality() throws Exception {

        String usernameXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "username_xpath");
        String passwordXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "password_xpath");
        String loginBtnXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "login_btn_xpath");
        String dashboardXpath  = WebUtilityKeys.readPropertyFiles(objectdashboard, "dashboardXpath");

        String username        = WebUtilityKeys.readPropertyFiles(testDatalogin, "username");
        String password        = WebUtilityKeys.readPropertyFiles(testDatalogin, "password");
        String dashboardtext   = WebUtilityKeys.readPropertyFiles(testDataDashboard, "dashboardtext");

        WebUtilityKeys.createTestName(
                "TC46042 verify valid Login Functionality",
                "TesterName=brahmendra.jayaraju@gmail.com"
        );

        this.login.enterUsername(usernameXpath, username);
        this.login.enterPassword(passwordXpath, password);
        this.login.clickOnLogin(loginBtnXpath);
        this.login.verifyDashboardTitle( dashboardXpath, dashboardtext);
    }
}
