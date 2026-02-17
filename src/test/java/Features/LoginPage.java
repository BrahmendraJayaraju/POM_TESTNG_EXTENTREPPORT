package Features;
import org.openqa.selenium.WebDriver;
import Generic.WebUtilityKeys;

public class LoginPage extends WebUtilityKeys {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String element, String text) {

        this.webEnterText_ByXpath(element, text);
        
        captureStep("Entered Username");
        return this;
    }

    public LoginPage enterPassword(String element, String text) {
      
        
        this.webEnterText_ByXpath(element, text);
        captureStep("Entered Password");
        return this;
    }

    public LoginPage clickOnLogin(String element) {
        this.clickByXpath(element);
        captureStep("Click Login Button");
        return this;
    }

    public LoginPage VerifyInvalidError_message(String element, String expectedText) {
        this.assertTextByXpath(element, expectedText);
        captureStep("Verified invalid login message");
        return this;
    }
    
    
    
    
    public LoginPage verifyDashboardTitle(String element, String expectedText) {
        this.assertTextByXpath(element, expectedText);
        captureStep("Verified DashboardPage Title");
        return this;
    }
    
    
}
