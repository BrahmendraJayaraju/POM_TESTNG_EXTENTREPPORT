package com.orangeHRM.tests;

import org.testng.annotations.Test;

import com.orangeHRM.generic.AdminBaseControl;
import com.orangeHRM.generic.WebUtilityKeys;
import com.orangeHRM.pages.LoginPage;

public class InvalidLoginTest extends AdminBaseControl{
	
	


   
	
	
    @Test(priority = 0, groups = { "Regression" })
    public void TC46043_verifyInvalidLoginFunctionality() throws Exception {

      

        WebUtilityKeys.createTestName(
                "TC46043 verify invalid Login Functionality",
                "TesterName=brahmendra.jayaraju@gmail.com"
        );
        
        LoginPage  login=new LoginPage(driver);

       login.enterUsername();
        login.invalidenterPassword();
        login.clickOnLogin();
        login.VerifyInvalidError_message();
    }
    

}
