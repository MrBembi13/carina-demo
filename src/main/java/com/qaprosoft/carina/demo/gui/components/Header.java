package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//button[@type='button']")
    private ExtendedWebElement burgerMenuButton;

    @FindBy(id = "logo")
    private ExtendedWebElement logoButton;

    @FindBy(xpath = "//input[@type='text']")
    private ExtendedWebElement searchLabel;

    @FindBy(xpath = "//a[@class='tip-icon']")
    private ExtendedWebElement tipButton;

    @FindBy(xpath = "//a[@class='fb-icon']//i")
    private ExtendedWebElement facebookButton;

    @FindBy(xpath = "//a[@class='tw-icon']//i")
    private ExtendedWebElement twitterButton;

    @FindBy(xpath = "//a[@class='ig-icon']//i")
    private ExtendedWebElement instagramButton;

    @FindBy(xpath = "//a[@class='yt-icon']//i")
    private ExtendedWebElement youTubeButton;

    @FindBy(xpath = "//a[@class='rss-icon']//i")
    private ExtendedWebElement rssButton;

    @FindBy(id = "login-active")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[@class='signup-icon no-margin-right']//i")
    private ExtendedWebElement signUpButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean checkIfBurgerMenuPresent() {
        return burgerMenuButton.isElementPresent();
    }

    public boolean checkIfLogoPresent() {
        return logoButton.isElementPresent();
    }

    public boolean checkIfSearchLabelPresent() {
        return searchLabel.isElementPresent();
    }

    public boolean checkIfTipButtonPresent() {
        return tipButton.isElementPresent();
    }

    public boolean checkIfFacebookButtonPresent() {
        return facebookButton.isElementPresent();
    }

    public boolean checkIfTwitterButtonPresent() {
        return twitterButton.isElementPresent();
    }

    public boolean checkIfInstagramButtonPresent() {
        return instagramButton.isElementPresent();
    }

    public boolean checkIfYouTubeButtonPresent() {
        return youTubeButton.isElementPresent();
    }

    public boolean checkIfRSSButtonPresent() {
        return rssButton.isElementPresent();
    }

    public boolean checkIfLogInButtonPresent() {
        return logInButton.isElementPresent();
    }

    public boolean checkIfSignUpButtonPresent() {
        return signUpButton.isElementPresent();
    }
}
