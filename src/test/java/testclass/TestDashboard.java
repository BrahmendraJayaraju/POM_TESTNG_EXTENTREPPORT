package testclass;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Features.DashboardPage;
import Generic.AdminBaseControl;
import Generic.DriverFactory;
import Generic.WebUtilityKeys;

public class TestDashboard extends AdminBaseControl {

    DashboardPage logout;

    public static String objectRepoDashboard = "/ObjectRepository/Dashboard.properties";
    public static String testDataDashboard   = "/TestData/TestDashboard.properties";
    
    public static String objectRepologin = "/ObjectRepository/login.properties";
    public static String testDatalogin  = "/TestData/TestLogin.properties";

    @BeforeClass
    public void setupPages() {
        this.logout = new DashboardPage(DriverFactory.getDriver());
    }

    @Test(priority = 0, groups = { "Regression" })
    public void TC46044_verifyLogoutFunctionality() throws Exception {

        String avatarXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "avatar_xpath");
        String logoutXpath = WebUtilityKeys.readPropertyFiles(objectRepoDashboard, "logout_xpath");
        String headerXpath = WebUtilityKeys.readPropertyFiles(objectRepologin, "loginheader");

        String headerText  = WebUtilityKeys.readPropertyFiles(testData, "loginheadertext");

        WebUtilityKeys.createTestName(
                "TC46044 verify logout functionality",
                "TesterName=balaji@gmail.com"
        );

        this.logout.clickOnAvatar(avatarXpath);
        this.logout.clickOnLogout(logoutXpath);
        this.logout.verifyLoginPageDisplayed(headerXpath, headerText);
    }
}
