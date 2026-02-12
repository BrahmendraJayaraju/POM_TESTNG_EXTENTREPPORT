package Generic;



import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;

import java.text.SimpleDateFormat;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;





import org.apache.commons.lang3.RandomStringUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class WebUtilityKeys extends AdminBaseControl
{

	public WebDriver driver;
	public  WebDriverWait wait;
	   

	    public WebUtilityKeys(WebDriver driver)
	    {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    }
	    
	    
	
	    
	    public void navigate_To(String Url)
	    {
	        this.getWebDriver().navigate().to(Url.trim());
	    }

   

    /* ==================== WAIT METHODS ==================== */

	    public void waitById(String value) {
	    	

	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id(value))
	        );
	    }

	    public void waitByName(String value) {


	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.name(value))
	        );
	    }

	    public void waitByClassName(String value) {
	    	

	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.className(value))
	        );
	    }

	    public void waitByXpath(String value) {
	    

	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath(value))
	        );
	    }

	    public void waitByCss(String value) {
	    	

	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value))
	        );
	    }

	    public void waitByLinkText(String value) {
	    

	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.linkText(value))
	        );
	    }

	    public void waitByPartialLinkText(String value) {


	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value))
	        );
	    }

    



    /* ==================== CLICK ==================== */

	    public void clickById(String value) {
	 
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id(value))
	        );
	        this.getWebDriver().findElement(By.id(value)).click();
	    }

	    public void clickByName(String value) {
	      
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.name(value))
	        );
	        this.getWebDriver().findElement(By.name(value)).click();
	    }

	    public void clickByClassName(String value) {
	      
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.className(value))
	        );
	        this.getWebDriver().findElement(By.className(value)).click();
	    }

	    public void clickByXpath(String value) {
	
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath(value))
	        );
	        this.getWebDriver().findElement(By.xpath(value)).click();
	    }

	    public void clickByCss(String value) {
	       
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value))
	        );
	        this.getWebDriver().findElement(By.cssSelector(value)).click();
	    }

	    public void clickByLinkText(String value) {
	        
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.linkText(value))
	        );
	        this.getWebDriver().findElement(By.linkText(value)).click();
	    }

	    public void clickByPartialLinkText(String value) {
	       
	        this.wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value))
	        );
	        this.getWebDriver().findElement(By.partialLinkText(value)).click();
	    }


	    //enter text 
	    
	    public void webEnterText_ById(String element, String text) {
	        this.waitById(element);
	        this.getWebDriver().findElement(By.id(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    public void webEnterText_ByName(String element, String text) {
	        this.waitByName(element);
	        this.getWebDriver().findElement(By.name(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    public void webEnterText_ByClassName(String element, String text) {
	        this.waitByClassName(element);
	        this.getWebDriver().findElement(By.className(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    public void webEnterText_ByXpath(String element, String text) {
	        this.waitByXpath(element);
	        this.getWebDriver().findElement(By.xpath(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    public void webEnterText_ByCss(String element, String text) {
	        this.waitByCss(element);
	        this.getWebDriver().findElement(By.cssSelector(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    public void webEnterText_ByLinkText(String element, String text) {
	        this.waitByLinkText(element);
	        this.getWebDriver().findElement(By.linkText(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    public void webEnterText_ByPartialLinkText(String element, String text) {
	        this.waitByPartialLinkText(element);
	        this.getWebDriver().findElement(By.partialLinkText(element))
	                          .sendKeys(new CharSequence[]{text});
	    }

	    
	    
	    
	    
	    
	    
	    
	    

    /* ==================== GET TEXT ==================== */

	    public String getTextById(String value) {
	        this.waitById(value);
	        return this.getWebDriver().findElement(By.id(value)).getText();
	    }

	    public String getTextByName(String value) {
	        this.waitByName(value);
	        return this.getWebDriver().findElement(By.name(value)).getText();
	    }

	    public String getTextByClassName(String value) {
	        this.waitByClassName(value);
	        return this.getWebDriver().findElement(By.className(value)).getText();
	    }

	    public String getTextByXpath(String value) {
	        this.waitByXpath(value);
	        return this.getWebDriver().findElement(By.xpath(value)).getText();
	    }

	    public String getTextByCss(String value) {
	        this.waitByCss(value);
	        return this.getWebDriver().findElement(By.cssSelector(value)).getText();
	    }

	    public String getTextByLinkText(String value) {
	        this.waitByLinkText(value);
	        return this.getWebDriver().findElement(By.linkText(value)).getText();
	    }

	    public String getTextByPartialLinkText(String value) {
	        this.waitByPartialLinkText(value);
	        return this.getWebDriver().findElement(By.partialLinkText(value)).getText();
	    }


    /* ==================== DISPLAY / ENABLE ==================== */

	    public boolean isDisplayedByXpath(String value) {
	        this.waitByXpath(value);
	        return this.getWebDriver().findElement(By.xpath(value)).isDisplayed();
	    }

	    public boolean isEnabledById(String value) {
	        this.waitById(value);
	        return this.getWebDriver().findElement(By.id(value)).isEnabled();
	    }


    /* ==================== ACTIONS ==================== */

	    public void doubleClickByXpath(String value) {
	        this.waitByXpath(value);
	        new Actions(this.getWebDriver())
	                .doubleClick(this.getWebDriver().findElement(By.xpath(value)))
	                .perform();
	    }

	    public void rightClickByXpath(String value) {
	        this.waitByXpath(value);
	        new Actions(this.getWebDriver())
	                .contextClick(this.getWebDriver().findElement(By.xpath(value)))
	                .perform();
	    }

	    public void pressKeyByXpath(String value, Keys key) {
	        this.waitByXpath(value);
	        this.getWebDriver().findElement(By.xpath(value)).sendKeys(key);
	    }


    /* ==================== JAVASCRIPT ==================== */

	    public void jsClickByXpath(String value) {
	        this.waitByXpath(value);
	        ((JavascriptExecutor) this.getWebDriver())
	                .executeScript(
	                        "arguments[0].click();",
	                        this.getWebDriver().findElement(By.xpath(value))
	                );
	    }


public void scrollToElementByXpath(String value) {
    WebElement el = this.getWebDriver().findElement(By.xpath(value));
    ((JavascriptExecutor) this.getWebDriver())
            .executeScript("arguments[0].scrollIntoView(true);", el);
}


    /* ==================== NAVIGATION ==================== */

public void navigateTo(String url) {
    this.getWebDriver().navigate().to(url);
}

public void navigateBack() {
    this.getWebDriver().navigate().back();
}

    /* ==================== ASSERTIONS ==================== */

public void assertTextByXpath(String value, String expected) {
    this.waitByXpath(value);
    Assert.assertEquals(
            this.getWebDriver().findElement(By.xpath(value)).getText(),
            expected
    );
}

public void assertTextById(String value, String expected) {
    this.waitById(value);
    Assert.assertEquals(
            this.getWebDriver().findElement(By.id(value)).getText(),
            expected
    );
}



    /* ==================== PROPERTY ==================== */

    public static String readPropertyFiles(String filePath, String key) throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + filePath);
        props.load(fis);
        return props.getProperty(key);
    }

    /* ==================== SCREENSHOT ==================== */

    public static String generateScreenshot(WebDriver driver, String name) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + "/Project_Report/Screenshots/"
                + name + timestamp() + ".png";
        src.renameTo(new File(path));
        return path;
    }


    /* ==================== EXTENT ==================== */

    public static void createTestName(String testName, String author) {
        AdminBaseControl.mainTest =
                AdminBaseControl.reports.createTest(testName).assignAuthor(author);
        AdminBaseControl.secondTest =
                AdminBaseControl.mainTest.createNode(testName);
        DriverFactory.setTest(AdminBaseControl.secondTest);
    }

    public static void assignTestCategories(String category) {
        AdminBaseControl.mainTest.assignCategory(category);
    }

    /* ==================== UTIL ==================== */

    public static String timestamp() {
        return new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss").format(new java.util.Date());
    }

    public static int randomnumber() {
        return new Random().nextInt(10000);
    }

    public static String randomstring() {
        return RandomStringUtils.randomAlphabetic(5);
    }
    
    /* ==================== EXTENT STEP SCREENSHOT ==================== */

    public void captureStep(String step) 
    {
        try {
            String path = generateScreenshot(
                    this.getWebDriver(),
                    step.replaceAll("[^a-zA-Z0-9]", "_")
            );

            DriverFactory.getTest().log(
                    Status.INFO,
                    step,
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build()
            );

        } catch (Exception e) {
            DriverFactory.getTest().log(
                    Status.WARNING,
                    "Screenshot failed for step: " + step
            );
        }
    }

    
    

}
