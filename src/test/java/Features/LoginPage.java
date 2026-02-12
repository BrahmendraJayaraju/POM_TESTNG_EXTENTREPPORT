package Features;
import org.openqa.selenium.WebDriver;
import Generic.WebUtilityKeys;

public class LoginPage extends WebUtilityKeys {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String element, String text) {

        this.webEnterText_ById(element, text);
        
        captureStep("Entered Username");
        return this;
    }

    public LoginPage enterPassword(String element, String text) {
      
        
        this.webEnterText_ByName(element, text);
        captureStep("Entered Password");
        return this;
    }

    public LoginPage clickOnLogin(String element) {
        this.clickByXpath(element);
        captureStep("Clicked Login Button");
        return this;
    }

    public LoginPage verifyEnterTimetracTitle(String element, String expectedText) {
        this.assertTextByXpath(element, expectedText);
        captureStep("Verified Enter Timetrack Title");
        return this;
    }
}
