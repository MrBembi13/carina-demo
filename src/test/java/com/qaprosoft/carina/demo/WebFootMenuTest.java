package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.AndroidAppPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test open Android app on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebFootMenuTest extends AbstractTest {

    @Test(description = "test open android app page")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testOpenAndroidApp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        AndroidAppPage androidAppPage = homePage.getFooterMenu().openAndroidAppPage();
        Assert.assertTrue(androidAppPage.isPageOpened(), "Android app page wasn't opened!");

        androidAppPage.verifyComponentsOnAppPage();
    }
}
