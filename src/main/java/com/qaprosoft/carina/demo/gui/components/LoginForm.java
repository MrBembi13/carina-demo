package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {
    Logger LOGGER = Logger.getLogger(LoginForm.class);

    @FindBy(id = "login-active")
    private ExtendedWebElement logInIcon;

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

    public void typeEmail(String email) {
        emailField.type(email);
    }

    public void typePassword(String password) {
        passwordField.type(password);
    }

    public boolean isLogOutIconButtonPresent() {
        return logOutIconButton.isElementPresent();
    }

    public LoginPage login(String email, String password) {
        typeEmail(email);
        typePassword(password);
        LOGGER.info("Enter email - " + email);
        LOGGER.info("Enter password - " + password);
        logInButton.click();
        return new LoginPage(driver);
    }
}
