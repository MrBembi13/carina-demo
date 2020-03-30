package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class CreateAccountForm extends AbstractUIObject {
    Logger LOGGER = Logger.getLogger(CreateAccountForm.class);

    @FindBy(id = "uname")
    private ExtendedWebElement nicknameField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='upass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = ".//label[@for='iagree1']")
    private ExtendedWebElement agreeForGSMArenaToStoreInfo;

    @FindBy(xpath = ".//label[@for='iagree2']")
    private ExtendedWebElement agreeYouHave16;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='nick-submit']")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='normal-text res-success']//h3")
    private ExtendedWebElement textSuccessfulRegistration;

    public CreateAccountForm(WebDriver driver) {
        super(driver);
    }

    public void typeNickname(String nickname) {
        nicknameField.type(nickname);
        LOGGER.info("Enter nickname - " + nickname);
    }

    public void typeEmail(String email) {
        emailField.type(email);
        LOGGER.info("Enter email - " + email);
    }

    public void typePassword(String password) {
        passwordField.type(password);
        LOGGER.info("Enter password - " + password);
    }

    public boolean registration() {
        Random random = new Random();
        int number = random.nextInt(100000);
        String nickname = "nickname" + number;
        String email = "email" + number + "@gmail.com";
        String password = "password" + number;
        typeNickname(nickname);
        typeEmail(email);
        typePassword(password);
        agreeForGSMArenaToStoreInfo.click();
        agreeYouHave16.click();
        if (submitButton.isClickable(10)) {
            LOGGER.info("Parameters entered correctly.");
            submitButton.click();
        } else {
            LOGGER.error("Parameters didn't enter correctly!");
            return false;
        }
        return textSuccessfulRegistration.getText().equals("Your account was created.");
    }
}
