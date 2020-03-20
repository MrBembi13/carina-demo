package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginForm extends AbstractUIObject {
    @FindBy(id = "login-active")
    private ExtendedWebElement logInIcon;

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginForm;

    @FindBy(id = "email")
    private ExtendedWebElement emailField;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordField;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = ".//i[@class='head-icon icon-signout']")
    private ExtendedWebElement logOutIconButton;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openLoginForm() {
        logInIcon.click();
        Assert.assertTrue(loginForm.isElementPresent(), "Login form was not opened!");
    }

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public boolean isLogOutIconButtonPresent() {
        return logOutIconButton.isElementPresent();
    }

    public void login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        logInButton.click();
    }
}
