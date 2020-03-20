package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
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

        homePage.getHeader().logIn();
        Assert.assertTrue(homePage.getHeader().isLogOutIconButtonPresent(), "Lon in was failed!");
    }
}
