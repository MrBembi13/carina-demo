package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private static final String TEXT_WRONG_EMAIL = "Reason: User record not found.";
    private static final String TEXT_WRONG_PASSWORD = "Reason: Wrong password.";

    @FindBy(xpath = "//div[@class='normal-text res-error']")
    private ExtendedWebElement loginField;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isLoginFailedByEmail() {
        return loginField.isElementWithTextPresent(TEXT_WRONG_EMAIL);
    }

    public boolean isLoginFailedByPassword() {
        return loginField.isElementWithTextPresent(TEXT_WRONG_PASSWORD);
    }
}
