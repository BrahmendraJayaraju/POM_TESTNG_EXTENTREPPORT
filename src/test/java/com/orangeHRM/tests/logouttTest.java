package com.orangeHRM.tests;



import org.testng.annotations.Test;

import com.orangeHRM.generic.AdminBaseControl;

import com.orangeHRM.generic.WebUtilityKeys;
import com.orangeHRM.pages.DashboardPage;
import com.orangeHRM.pages.LoginPage;


public class logouttTest extends AdminBaseControl {

	
	
	

  

    

    
 

    @Test(priority = 0, groups = { "Regression" })
    public void TC46044_verifyLogoutFunctionality() throws Exception {
    	
    	  WebUtilityKeys.createTestName(
                  "TC46044 verify logout functionality",
                  "TesterName=balaji@gmail.com"
          );

     
     




    

       
        
        DashboardPage dash=new DashboardPage(driver);
        
        LoginPage  login=new LoginPage(driver);
        
        login.enterUsername();
        login.validenterPassword();
        login.clickOnLogin();
       	
        dash.clickOnAvatar();
       dash.clickOnLogout();
        dash.verifyLoginPageDisplayed();
    }
}
