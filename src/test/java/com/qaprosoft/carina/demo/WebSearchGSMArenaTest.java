package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.DropDownSearchForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.DevicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test search system on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */

public class WebSearchGSMArenaTest extends AbstractTest {
    private static final String SEARCH_TEXT = "xiaomi";

    @Test(description = "Test search field in header for searching device by text")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testSearchFieldInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        DropDownSearchForm dropDownSearchForm = homePage.getHeader().openDropDownSearchForm(SEARCH_TEXT);
        Assert.assertTrue(dropDownSearchForm.isDropDownSearchFormIsVisible(), "Drop down search form was not opened!");

        Assert.assertTrue(dropDownSearchForm.verifyListDevicesHaveText(SEARCH_TEXT), "Drop down search form didn't contains `" + SEARCH_TEXT + "`!");

        DevicePage devicePage = dropDownSearchForm.openRandomDevicePage();
        Assert.assertTrue(devicePage.isPageOpened(), SEARCH_TEXT + " page was not opened!");
        Assert.assertTrue(devicePage.isPageHasSearchTextInHead(SEARCH_TEXT), SEARCH_TEXT + " page didn't have - `" + SEARCH_TEXT + "`!");
    }
}
