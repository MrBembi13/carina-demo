package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='normal-text res-error']")
    private ExtendedWebElement loginField;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isLoginFailedByEmail() {
        return loginField.isElementWithTextPresent("Reason: User record not found.");
    }

    public boolean isLoginFailedByPassword() {
        return loginField.isElementWithTextPresent("Reason: Wrong password.");
    }

    public boolean isLoginSuccessful() {
        return loginField.isElementWithTextPresent("Stand-by for redirect.");
    }
}