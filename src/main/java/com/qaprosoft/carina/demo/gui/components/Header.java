package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.FailedLoginPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//button[@type='button']")
    private ExtendedWebElement burgerMenuButton;

    @FindBy(id = "logo")
    private ExtendedWebElement logoButton;

    @FindBy(xpath = ".//input[@type='text']")
    private ExtendedWebElement searchLabel;

    @FindBy(xpath = ".//a[@class='tip-icon']")
    private ExtendedWebElement tipButton;

    @FindBy(xpath = ".//a[@class='fb-icon']")
    private ExtendedWebElement facebookButton;

    @FindBy(xpath = ".//a[@class='tw-icon']")
    private ExtendedWebElement twitterButton;

    @FindBy(xpath = ".//a[@class='ig-icon']")
    private ExtendedWebElement instagramButton;

    @FindBy(xpath = ".//a[@class='yt-icon']")
    private ExtendedWebElement youTubeButton;

    @FindBy(xpath = ".//a[@class='rss-icon']")
    private ExtendedWebElement rssButton;

    @FindBy(id = "login-active")
    private ExtendedWebElement logInIcon;

    @FindBy(xpath = ".//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement signUpButton;

    @FindBy(id = "email")
    private ExtendedWebElement emailLabel;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordLabel;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = ".//i[@class='head-icon icon-signout']")
    private ExtendedWebElement logOutIconButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void verifyHeaderBasicElements(SoftAssert softAssert) {
        softAssert.assertTrue(burgerMenuButton.isElementPresent(), "Burger menu was not found!");
        softAssert.assertTrue(logoButton.isElementPresent(), "Logo was not found!");
        softAssert.assertTrue(searchLabel.isElementPresent(), "Search label was not found!");
        softAssert.assertTrue(tipButton.isElementPresent(), "Tip button was not found!");
        softAssert.assertTrue(facebookButton.isElementPresent(), "Facebook button was not found!");
        softAssert.assertTrue(twitterButton.isElementPresent(), "Twitter button was not found!");
        softAssert.assertTrue(instagramButton.isElementPresent(), "Instagram button was not found!");
        softAssert.assertTrue(youTubeButton.isElementPresent(), "YouTube button was not found!");
        softAssert.assertTrue(rssButton.isElementPresent(), "RSS button was not found!");
        softAssert.assertTrue(logInIcon.isElementPresent(), "Log in button was not found!");
        softAssert.assertTrue(signUpButton.isElementPresent(), "Sign up button was not found!");
    }

    public void openFieldsForLogIn() {
        logInIcon.click();
    }

    public void typeEmail(String email) {
        emailLabel.type(email);
    }

    public void typePassword(String password) {
        passwordLabel.type(password);
    }

    public void logInGood() {
        String email = "s9rowa@mail.ru";
        String password = "changeme";

        openFieldsForLogIn();
        typeEmail(email);
        typePassword(password);
        logInButton.click();
    }

    public boolean isLogOutIconButtonPresent() {
        return logOutIconButton.isElementPresent();
    }

    public FailedLoginPage logInFailedByEmail() {
        String email = "s9rowao@mail.ru";
        String password = "changeme";

        openFieldsForLogIn();
        typeEmail(email);
        typePassword(password);
        logInButton.click();
        return new FailedLoginPage(driver);
    }

    public FailedLoginPage logInFailedByPassword() {
        String email = "s9rowa@mail.ru";
        String password = "changemy";

        openFieldsForLogIn();
        typeEmail(email);
        typePassword(password);
        logInButton.click();
        return new FailedLoginPage(driver);
    }

    public void logInByWrongFormatEmail() {
        String email = "s9rowamail.ru";
        String password = "changeme";

        openFieldsForLogIn();
        typeEmail(email);
        typePassword(password);
        logInButton.click();
    }

    public void logInByWrongFormatPassword() {
        String email = "s9rowa@mail.ru";
        String password = "chan";

        openFieldsForLogIn();
        typeEmail(email);
        typePassword(password);
        logInButton.click();
    }
}
