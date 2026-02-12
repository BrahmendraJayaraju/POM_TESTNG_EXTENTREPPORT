package testclass;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Features.LoginPage;
import Generic.AdminBaseControl;
import Generic.DriverFactory;
import Generic.WebUtilityKeys;

public class TestLogin extends AdminBaseControl {

    LoginPage login;

    public static String objectRepo = "/ObjectRepository/Login.properties";
    public static String testData   = "/TestData/TestLogin.properties";
    public static String filepath   = "/TestEnviornmentSetUp/BasicTestSetUp.properties";

 

    @BeforeClass
    public void setupPages() {
       
        this.login = new LoginPage(DriverFactory.getDriver());
    }
    



    @Test(priority = 0, groups = { "Regression" })
    public void TC46043_verifyInvalidLoginFunctionality() throws Exception {

        String usernameXpath   = WebUtilityKeys.readPropertyFiles(objectRepo, "username_xpath");
        String passwordXpath   = WebUtilityKeys.readPropertyFiles(objectRepo, "password_xpath");
        String loginBtnXpath   = WebUtilityKeys.readPropertyFiles(objectRepo, "login_btn_xpath");
        String errorXpath      = WebUtilityKeys.readPropertyFiles(objectRepo, "invalidpassworderror_xpath");

        String username        = WebUtilityKeys.readPropertyFiles(testData, "username");
        String invalidPassword = WebUtilityKeys.readPropertyFiles(testData, "Invalidpassword");
        String errorMessage    = WebUtilityKeys.readPropertyFiles(testData, "Errormessage");

        WebUtilityKeys.createTestName(
                "TC46043 verify invalid Login Functionality",
                "TesterName=brahmendra.jayaraju@gmail.com"
        );

        this.login.enterUsername(usernameXpath, username);
        this.login.enterPassword(passwordXpath, invalidPassword);
        this.login.clickOnLogin(loginBtnXpath);
        this.login.verifyEnterTimetracTitle(errorXpath, errorMessage);
    }
    
    
    
    @Test(priority = 1, groups = { "Regression" })
    public void TC46042_verifyValidLoginFunctionality() throws Exception {

        String usernameXpath   = WebUtilityKeys.readPropertyFiles(objectRepo, "username_xpath");
        String passwordXpath   = WebUtilityKeys.readPropertyFiles(objectRepo, "password_xpath");
        String loginBtnXpath   = WebUtilityKeys.readPropertyFiles(objectRepo, "login_btn_xpath");
        String enterTimeXpath  = WebUtilityKeys.readPropertyFiles(objectRepo, "EnterTimetrack");

        String username        = WebUtilityKeys.readPropertyFiles(testData, "username");
        String password        = WebUtilityKeys.readPropertyFiles(testData, "password");
        String enterTimeText   = WebUtilityKeys.readPropertyFiles(testData, "EnterTimetrack");

        WebUtilityKeys.createTestName(
                "TC46042 verify valid Login Functionality",
                "TesterName=brahmendra.jayaraju@gmail.com"
        );

        this.login.enterUsername(usernameXpath, username);
        this.login.enterPassword(passwordXpath, password);
        this.login.clickOnLogin(loginBtnXpath);
        this.login.verifyEnterTimetracTitle(enterTimeXpath, enterTimeText);
    }
}
