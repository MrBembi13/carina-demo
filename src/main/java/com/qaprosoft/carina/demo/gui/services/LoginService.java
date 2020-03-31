package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.services.components.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginService implements IDriverPool {
    private static Logger LOGGER = Logger.getLogger(LoginService.class);

    public static void login(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        User user = UserService.getUserForLogin();
        LOGGER.info("User parameters send to login");
        loginForm.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(loginForm.isLogOutIconButtonPresent(), "User wasn't login on website!");
    }
}
