package com.orangeHRM.tests;


import org.testng.annotations.Test;

import com.orangeHRM.generic.AdminBaseControl;

import com.orangeHRM.generic.WebUtilityKeys;
import com.orangeHRM.pages.DashboardPage;


public class DashboardTest extends AdminBaseControl {

	DashboardPage dash;

    public static String objectRepoDashboard = "/ObjectRepository/Dashboard.properties";
    public static String testDataDashboard   = "/TestData/TestDashboard.properties";
    
    public static String objectRepologin = "/ObjectRepository/login.properties";
    public static String testDatalogin  = "/TestData/TestLogin.properties";

    
 
    
    
 

    @Test(priority = 0, groups = { "Regression" })
    public void TC46044_verifyLogoutFunctionality() throws Exception {

        String avatarXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "avatar_xpath");
        String logoutXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "logout_xpath");
        String headerXpath = WebUtilityKeys.readPropertyFiles(objectRepologin, "loginheader");

        String headerText  = WebUtilityKeys.readPropertyFiles(testDatalogin, "loginheadertext");

        WebUtilityKeys.createTestName(
                "TC46044 verify logout functionality",
                "TesterName=balaji@gmail.com"
        );

        
       	this.dash=new DashboardPage(driver);
       	
        this.dash.clickOnAvatar(avatarXpath);
        this.dash.clickOnLogout(logoutXpath);
        this.dash.verifyLoginPageDisplayed(headerXpath, headerText);
    }
}
