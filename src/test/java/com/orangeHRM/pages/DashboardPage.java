package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;

import com.orangeHRM.generic.WebUtilityKeys;
 
public class DashboardPage extends WebUtilityKeys {
	
	
	
	  public static String objectRepoDashboard = "/ObjectRepository/Dashboard.properties";

	    public static String objectdashboard = "/ObjectRepository/Dashboard.properties";
	    public static String objectRepologin = "/ObjectRepository/login.properties";
	    public static String testDatalogin  = "/TestData/TestLogin.properties";

	    String avatarXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "avatar_xpath");
	    String logoutXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "logout_xpath");
	    String headerXpath = WebUtilityKeys.readPropertyFiles(objectRepologin, "loginheader");
	    
	    

	        String headerText  = WebUtilityKeys.readPropertyFiles(testDatalogin, "loginheadertext");
	    

    public DashboardPage (WebDriver driver) {
        super(driver);
    }

    public DashboardPage  clickOnAvatar() {
        this.clickByXpath(avatarXpath );
        captureStep("Click on User Avatar");
        return this;
    }

    public DashboardPage  clickOnLogout() {
        this.clickByXpath(logoutXpath);
        captureStep("Click on Logout Button");
        return this;
    }

    public DashboardPage  verifyLoginPageDisplayed() {
        this.assertTextByXpath(headerXpath, headerText);
        captureStep("Verified Login Page after Logout");
        return this;
    }
}
