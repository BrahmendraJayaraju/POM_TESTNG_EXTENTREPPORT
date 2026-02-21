package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;

import com.orangeHRM.generic.WebUtilityKeys;
 
public class DashboardPage extends WebUtilityKeys {

    public DashboardPage (WebDriver driver) {
        super(driver);
    }

    public DashboardPage  clickOnAvatar(String element) {
        this.clickByXpath(element);
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
