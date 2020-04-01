package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginService {
    private static Logger LOGGER = Logger.getLogger(LoginService.class);

    public static void login(WebDriver driver, String email, String password) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        loginForm.login(email, password);

        Assert.assertTrue(loginForm.isLogOutIconButtonPresent(), "User wasn't login on website!");
    }
}
