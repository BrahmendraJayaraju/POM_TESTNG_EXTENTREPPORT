package com.orangeHRM.pages;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.generic.WebUtilityKeys;

public class LoginPage extends WebUtilityKeys {
	
	  public static String objectRepologin = "/ObjectRepository/Login.properties";
	    public static String objectdashboard = "/ObjectRepository/Dashboard.properties";
	    
	    public static String testDatalogin   = "/TestData/TestLogin.properties";
	    public static String  testDataDashboard   = "/TestData/TestDashboard.properties";
	    public static String filepath   = "/TestEnviornmentSetUp/BasicTestSetUp.properties";
	
	
	
	String usernameXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "username_xpath");
    String passwordXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "password_xpath");
    String loginBtnXpath   = WebUtilityKeys.readPropertyFiles(objectRepologin, "login_btn_xpath");
    String dashboardXpath  = WebUtilityKeys.readPropertyFiles(objectdashboard, "dashboardXpath");

    String username        = WebUtilityKeys.readPropertyFiles(testDatalogin, "username");
    String password        = WebUtilityKeys.readPropertyFiles(testDatalogin, "password");
    String dashboardtext   = WebUtilityKeys.readPropertyFiles(testDataDashboard, "dashboardtext");
    
  
    String errorXpath      = WebUtilityKeys.readPropertyFiles(objectRepologin, "invalidpassworderror_xpath");

 
    String invalidPassword = WebUtilityKeys.readPropertyFiles(testDatalogin , "Invalidpassword");
    String errorMessage    = WebUtilityKeys.readPropertyFiles(testDatalogin , "Errormessage");
    
  
    
    
   
	
	
	

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    

    public LoginPage enterUsername() {

        this.webEnterText_ByXpath(usernameXpath,username );
        
        captureStep("Entered Username");
        return this;
    }

    public LoginPage invalidenterPassword() {
      
        
        this.webEnterText_ByXpath(passwordXpath,invalidPassword);
        captureStep("Entered Password");
        return this;
    }
    
    
 public LoginPage validenterPassword() {
      
        
        this.webEnterText_ByXpath(passwordXpath,password     );
        captureStep("Entered Password");
        return this;
    }
    

    public LoginPage clickOnLogin() {
        this.clickByXpath(loginBtnXpath );
        captureStep("Click Login Button");
        return this;
    }

    public LoginPage VerifyInvalidError_message() {
        this.assertTextByXpath(errorXpath ,errorMessage );
        captureStep("Verified invalid login message");
        return this;
    }
    
    
    
    
    public LoginPage verifyDashboardTitle() {
        this.assertTextByXpath( dashboardXpath,dashboardtext );
        captureStep("Verified DashboardPage Title");
        return this;
    }
    
    
}
