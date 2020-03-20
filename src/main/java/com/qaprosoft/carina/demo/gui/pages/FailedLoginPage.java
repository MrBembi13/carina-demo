package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FailedLoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='normal-text res-error']")
    private ExtendedWebElement loginFailedField;

    public FailedLoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isLoginFailedByEmail() {
        return loginFailedField.isElementWithTextPresent("Reason: User record not found.");
    }
}
