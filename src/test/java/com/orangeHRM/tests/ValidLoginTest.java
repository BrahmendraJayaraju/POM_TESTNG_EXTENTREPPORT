package com.orangeHRM.tests;




import org.testng.annotations.Test;

import com.orangeHRM.generic.AdminBaseControl;

import com.orangeHRM.generic.WebUtilityKeys;
import com.orangeHRM.pages.LoginPage;

public class ValidLoginTest extends AdminBaseControl {

	

	 
   



    
    
    @Test(priority = 1, groups = { "Regression" })
    public void TC46042_verifyValidLoginFunctionality() throws Exception {

        

        WebUtilityKeys.createTestName(
                "TC46042 verify valid Login Functionality",
                "TesterName=brahmendra.jayaraju@gmail.com"
        );
        LoginPage   login=new LoginPage(driver);
        
        
        
        login.enterUsername();
        login.validenterPassword();
       login.clickOnLogin();
        login.verifyDashboardTitle( );
    }
}
