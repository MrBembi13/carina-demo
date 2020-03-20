package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.FailedLoginPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test log in on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebLoginTest extends AbstractTest {
    @Test(description = "Test good log in")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testGoodLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        homePage.getHeader().logInGood();
        Assert.assertTrue(homePage.getHeader().isLogOutIconButtonPresent(), "Lon in was failed!");
    }

    @Test(description = "Test good log in")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testWrongEmailLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        FailedLoginPage failedLoginPage = homePage.getHeader().logInFailedByEmail();
        Assert.assertTrue(failedLoginPage.isLoginFailedByEmail(), "Log in was successful when it was failed by email!");
    }
}
