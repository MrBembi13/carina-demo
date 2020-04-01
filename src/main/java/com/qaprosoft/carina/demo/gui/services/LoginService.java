package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class LoginService implements IDriverPool {
    private Logger LOGGER = Logger.getLogger(LoginService.class);

    public HomePage login(String email, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        loginForm.login(email, password);

        Assert.assertTrue(loginForm.isLogOutIconButtonPresent(), "User wasn't login on website!");
        return new HomePage(getDriver());
    }
}
