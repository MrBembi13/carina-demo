package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test sign up on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebSignUpGSMArenaTest extends AbstractTest {
    private HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @Test(description = "test sign up with random parameters")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testSignUp() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        SignUpPage signUpPage = homePage.getHeader().openSignUpPage();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign up page wasn't opened!");

        Assert.assertTrue(signUpPage.registerRandomUser(), "Registration was failed!");
    }
}
