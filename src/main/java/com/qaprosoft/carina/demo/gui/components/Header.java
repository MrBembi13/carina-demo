package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.security.Signature;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//button[@type='button']")
    private ExtendedWebElement burgerMenuButton;

    @FindBy(id = "logo")
    private ExtendedWebElement logoButton;

    @FindBy(xpath = ".//input[@type='text']")
    private ExtendedWebElement searchField;

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

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginForm;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginForm openLoginForm() {
        logInIcon.click();
        Assert.assertTrue(loginForm.isElementPresent(), "Login form was not opened!");
        return new LoginForm(driver);
    }

    public void verifyHeaderBasicElements(SoftAssert softAssert) {
        softAssert.assertTrue(burgerMenuButton.isElementPresent(), "Burger menu was not found!");
        softAssert.assertTrue(logoButton.isElementPresent(), "Logo was not found!");
        softAssert.assertTrue(searchField.isElementPresent(), "Search label was not found!");
        softAssert.assertTrue(tipButton.isElementPresent(), "Tip button was not found!");
        softAssert.assertTrue(facebookButton.isElementPresent(), "Facebook button was not found!");
        softAssert.assertTrue(twitterButton.isElementPresent(), "Twitter button was not found!");
        softAssert.assertTrue(instagramButton.isElementPresent(), "Instagram button was not found!");
        softAssert.assertTrue(youTubeButton.isElementPresent(), "YouTube button was not found!");
        softAssert.assertTrue(rssButton.isElementPresent(), "RSS button was not found!");
        softAssert.assertTrue(logInIcon.isElementPresent(), "Log in button was not found!");
        softAssert.assertTrue(signUpButton.isElementPresent(), "Sign up button was not found!");
    }

    public DropDownSearchForm openDropDownSearchForm(String text) {
        searchField.type(text);
        searchField.click();
        return new DropDownSearchForm(driver);
    }

    public SignUpPage openSignUpPage() {
        signUpButton.click();
        return new SignUpPage(driver);
    }
}
