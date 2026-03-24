package com.orangeHRM.generic;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import org.apache.commons.lang3.RandomStringUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class WebUtilityKeys {

    public WebDriver driver;
    public WebDriverWait wait;

   
    public WebUtilityKeys(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

  
    public void waitByXpath(String value) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
        } catch (Exception e) {
            captureStep("Wait failed for xpath: " + value);
            throw new RuntimeException("Element not visible: " + value);
        }
    }

    public void waitById(String value) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
        } catch (Exception e) {
            captureStep("Wait failed for id: " + value);
            throw new RuntimeException("Element not visible: " + value);
        }
    }

 
    public void clickByXpath(String value) {
        try {
            waitByXpath(value);
            driver.findElement(By.xpath(value)).click();
            captureStep("Clicked: " + value);

        } catch (TimeoutException e) {
            captureStep("Timeout while clicking: " + value);
            Assert.fail("Timeout: Element not visible -> " + value);

        } catch (NoSuchElementException e) {
            captureStep("Element not found: " + value);
            Assert.fail("NoSuchElement -> " + value);

        } catch (Exception e) {
            captureStep("Error clicking: " + value);
            Assert.fail("Error clicking element -> " + e.getMessage());
        }
    }

    public void clickById(String value) {
        try {
            waitById(value);
            driver.findElement(By.id(value)).click();
            captureStep("Clicked: " + value);

        } catch (Exception e) {
            captureStep("Error clicking ID: " + value);
            Assert.fail("Click failed -> " + e.getMessage());
        }
    }

  
    public void webEnterText_ByXpath(String element, String text) {
        try {
            waitByXpath(element);
            driver.findElement(By.xpath(element)).sendKeys(text);
            captureStep("Entered text: " + element);

        } catch (Exception e) {
            captureStep("Failed to enter text: " + element);
            Assert.fail("SendKeys failed -> " + e.getMessage());
        }
    }

    public void webEnterText_ById(String element, String text) {
        try {
            waitById(element);
            driver.findElement(By.id(element)).sendKeys(text);
            captureStep("Entered text: " + element);

        } catch (Exception e) {
            captureStep("Failed to enter text: " + element);
            Assert.fail("SendKeys failed -> " + e.getMessage());
        }
    }


    public String getTextByXpath(String value) {
        try {
            waitByXpath(value);
            return driver.findElement(By.xpath(value)).getText();

        } catch (Exception e) {
            captureStep("Failed to get text: " + value);
            Assert.fail("GetText failed -> " + e.getMessage());
            return null;
        }
    }


    public void assertTextByXpath(String value, String expected) {
        try {
            waitByXpath(value);
            String actual = driver.findElement(By.xpath(value)).getText();
            Assert.assertEquals(actual, expected);
            captureStep("Assertion passed for: " + value);

        } catch (AssertionError e) {
            captureStep("Assertion failed: " + value);
            throw e;

        } catch (Exception e) {
            captureStep("Error in assertion: " + value);
            Assert.fail("Assertion error -> " + e.getMessage());
        }
    }

   
    public boolean isDisplayedByXpath(String value) {
        try {
            waitByXpath(value);
            return driver.findElement(By.xpath(value)).isDisplayed();

        } catch (Exception e) {
            captureStep("Element not displayed: " + value);
            return false;
        }
    }

  
    public void doubleClickByXpath(String value) {
        try {
            waitByXpath(value);
            new Actions(driver).doubleClick(driver.findElement(By.xpath(value))).perform();
            captureStep("Double clicked: " + value);

        } catch (Exception e) {
            captureStep("Double click failed: " + value);
            Assert.fail("Double click failed -> " + e.getMessage());
        }
    }

   
    public void jsClickByXpath(String value) {
        try {
            waitByXpath(value);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(By.xpath(value)));

            captureStep("JS clicked: " + value);

        } catch (Exception e) {
            captureStep("JS click failed: " + value);
            Assert.fail("JS click failed -> " + e.getMessage());
        }
    }

 
    public void navigateTo(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail("Navigation failed -> " + e.getMessage());
        }
    }

  
    public static String readPropertyFiles(String filePath, String key) {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + filePath);
            props.load(fis);
            return props.getProperty(key);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read property: " + key);
        }
    }


    public static String generateScreenshot(WebDriver driver, String name) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + "/Project_Report/Screenshots/"
                + name + timestamp() + ".png";
        src.renameTo(new File(path));
        return path;
    }
  
    public void captureStep(String step) {
        try {
            String path = generateScreenshot(driver, step.replaceAll("[^a-zA-Z0-9]", "_"));

            DriverFactory.getTest().log(
                    Status.INFO,
                    step,
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build()
            );

        } catch (Exception e) {
            DriverFactory.getTest().log(Status.WARNING,
                    "Screenshot failed for step: " + step);
        }
    }


    public static String timestamp() {
        return new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss")
                .format(new java.util.Date());
    }

    public static int randomnumber() {
        return new Random().nextInt(10000);
    }

    public static String randomstring() {
        return RandomStringUtils.randomAlphabetic(5);
    }
    
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
    

    
    
   
}