package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    private ExtendedWebElement logInButton;

    @FindBy(xpath = ".//a[@class='signup-icon no-margin-right']")
    private ExtendedWebElement signUpButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void verifyHeaderBasicElements(){
        Assert.assertTrue(burgerMenuButton.isElementPresent(), "Burger menu was not found!");
        Assert.assertTrue(logoButton.isElementPresent(), "Logo was not found!");
        Assert.assertTrue(searchLabel.isElementPresent(), "Search label was not found!");
        Assert.assertTrue(tipButton.isElementPresent(), "Tip button was not found!");
        Assert.assertTrue(facebookButton.isElementPresent(), "Facebook button was not found!");
        Assert.assertTrue(twitterButton.isElementPresent(), "Twitter button was not found!");
        Assert.assertTrue(instagramButton.isElementPresent(), "Instagram button was not found!");
        Assert.assertTrue(youTubeButton.isElementPresent(), "YouTube button was not found!");
        Assert.assertTrue(rssButton.isElementPresent(), "RSS button was not found!");
        Assert.assertTrue(logInButton.isElementPresent(), "Log in button was not found!");
        Assert.assertTrue(signUpButton.isElementPresent(), "Sign up button was not found!");
    }
}
