package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.DropDownSearchForm;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.DevicePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Test search system on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */

public class WebSearchGSMArenaTest extends AbstractTest {
    @Test(description = "Test search field in header for searching device by text", dataProvider = "DataProvider")
    @MethodOwner(owner = "Vasyl Rudyk")
    @XlsDataSourceParameters(path = "xls/search.xlsx", sheet = "Search text", dsUid = "TUID")
    public void testSearchFieldInHeader(HashMap<String, String> args) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        DropDownSearchForm dropDownSearchForm = homePage.getHeader().openDropDownSearchForm(args.get("searchText"));
        Assert.assertTrue(dropDownSearchForm.isDropDownSearchFormIsVisible(), "Drop down search form was not opened!");

        Assert.assertTrue(dropDownSearchForm.verifyListDevicesHaveText(args.get("searchText")), "Drop down search form didn't contains `" + args.get("searchText") + "`!");

        DevicePage devicePage = dropDownSearchForm.openRandomDevicePage();
        Assert.assertTrue(devicePage.isPageOpened(), args.get("searchText") + " page was not opened!");
        Assert.assertTrue(devicePage.isPageHasSearchTextInHead(args.get("searchText")), args.get("searchText") + " page didn't have - `" + args.get("searchText") + "`!");
    }
}
