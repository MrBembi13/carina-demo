package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.CreateAccountForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(id = "user-submit")
    private ExtendedWebElement createAccountForm;

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public CreateAccountForm getCreateAccountForm() {
        return new CreateAccountForm(driver);
    }
}
