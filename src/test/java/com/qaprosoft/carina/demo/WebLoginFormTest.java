package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test log in on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebLoginFormTest extends AbstractTest {
    private static final String EMAIL_GOOD = "s9rowa@mail.ru";
    private static final String PASSWORD_GOOD = "changeme";
    private static final String EMAIL_WRONG = "s9rowa1@mail.ru";
    private static final String PASSWORD_WRONG = "changeme1";
    private static final String EMAIL_WRONG_FORMAT = "s9rowamail.ru";
    private static final String PASSWORD_WRONG_FORMAT = "chan";
    private HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @Test(description = "Test good log in")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testGoodLogIn() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        loginForm.login(EMAIL_GOOD, PASSWORD_GOOD);
        Assert.assertTrue(loginForm.isLogOutIconButtonPresent(), "Lon in was failed!");
    }

    @Test(description = "Failed test log in by wrong email")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testWrongEmailLogIn() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        LoginPage loginPage = loginForm.login(EMAIL_WRONG, PASSWORD_GOOD);
        Assert.assertTrue(loginPage.isLoginFailedByEmail(), "Log in was successful when it was failed by email!");
    }

    @Test(description = "Failed test log in by wrong password")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testWrongPasswordLogIn() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        LoginPage loginPage = loginForm.login(EMAIL_GOOD, PASSWORD_WRONG);
        Assert.assertTrue(loginPage.isLoginFailedByPassword(), "Log in was successful when it was failed by password!");
    }

    @Test(description = "Failed test log in by wrong format email")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testWrongFormatEmailLogIn() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        loginForm.login(EMAIL_WRONG_FORMAT, PASSWORD_GOOD);
        Assert.assertFalse(loginForm.isLogOutIconButtonPresent(), "Lon in was successful when you enter wrong format email!");
    }

    @Test(description = "Failed test log in by wrong format password")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testWrongFormatPasswordLogIn() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        LoginForm loginForm = homePage.getHeader().openLoginForm();

        loginForm.login(EMAIL_GOOD, PASSWORD_WRONG_FORMAT);
        Assert.assertFalse(loginForm.isLogOutIconButtonPresent(), "Lon in was successful when you enter wrong format password!");
    }
}
