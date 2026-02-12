package Features;

import org.openqa.selenium.WebDriver;
import Generic.WebUtilityKeys;

public class LogoutPage extends WebUtilityKeys {

    public LogoutPage (WebDriver driver) {
        super(driver);
    }

    public LogoutPage  clickOnAvatar(String element) {
        this.clickByXpath(element);
        captureStep("Clicked on User Avatar");
        return this;
    }

    public LogoutPage  clickOnLogout(String element) {
        this.clickByXpath(element);
        captureStep("Clicked on Logout Button");
        return this;
    }

    public LogoutPage  verifyLoginPageDisplayed(String element, String expectedText) {
        this.assertTextByXpath(element, expectedText);
        captureStep("Verified Login Page after Logout");
        return this;
    }
}
