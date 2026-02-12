package testclass;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Features.LogoutPage;
import Generic.AdminBaseControl;
import Generic.DriverFactory;
import Generic.WebUtilityKeys;

public class Testlogout extends AdminBaseControl {

    LogoutPage logout;

    public static String objectRepo = "/ObjectRepository/Logout.properties";
    public static String testData   = "/TestData/TestLogout.properties";

    @BeforeClass
    public void setupPages() {
        this.logout = new LogoutPage(DriverFactory.getDriver());
    }

    @Test(priority = 0, groups = { "Regression" })
    public void TC46044_verifyLogoutFunctionality() throws Exception {

        String avatarXpath = WebUtilityKeys.readPropertyFiles(objectRepo, "avatar_xpath");
        String logoutXpath = WebUtilityKeys.readPropertyFiles(objectRepo, "logout_xpath");
        String headerXpath = WebUtilityKeys.readPropertyFiles(objectRepo, "logout_header_xpath");

        String headerText  = WebUtilityKeys.readPropertyFiles(testData, "logout_header_text");

        WebUtilityKeys.createTestName(
                "TC46044 verify logout functionality",
                "TesterName=balaji@gmail.com"
        );

        this.logout.clickOnAvatar(avatarXpath);
        this.logout.clickOnLogout(logoutXpath);
        this.logout.verifyLoginPageDisplayed(headerXpath, headerText);
    }
}
