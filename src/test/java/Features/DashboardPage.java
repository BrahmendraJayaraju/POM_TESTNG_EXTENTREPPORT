package Features;

import org.openqa.selenium.WebDriver;
import Generic.WebUtilityKeys;

public class DashboardPage extends WebUtilityKeys {

    public DashboardPage (WebDriver driver) {
        super(driver);
    }

    public DashboardPage  clickOnAvatar(String element) {
        this.clickByClassName(element);
        captureStep("Click on User Avatar");
        return this;
    }

    public DashboardPage  clickOnLogout(String element) {
        this.clickByXpath(element);
        captureStep("Click on Logout Button");
        return this;
    }

    public DashboardPage  verifyLoginPageDisplayed(String element, String expectedText) {
        this.assertTextByXpath(element, expectedText);
        captureStep("Verified Login Page after Logout");
        return this;
    }
}
