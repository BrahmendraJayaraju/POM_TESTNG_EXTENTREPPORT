package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;

import com.orangeHRM.generic.Autoconstant;
import com.orangeHRM.generic.WebUtilityKeys;
 
public class DashboardPage extends WebUtilityKeys implements Autoconstant {
	
	
	
	
	    
	    String headerText  = WebUtilityKeys.readPropertyFiles(testDatalogin, "loginheadertext");

	    String avatarXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "avatar_xpath");
	    String logoutXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "logout_xpath");
	    String headerXpath = WebUtilityKeys.readPropertyFiles(objectRepologin, "loginheader");
	    
	    

	       
	    

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
