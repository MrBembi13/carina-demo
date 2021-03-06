package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.DevicePage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.OpinionsPage;
import com.qaprosoft.carina.demo.gui.pages.PhonesPage;
import com.qaprosoft.carina.demo.gui.services.LoginService;
import com.qaprosoft.carina.demo.gui.services.UserService;
import com.qaprosoft.carina.demo.gui.components.User;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test opinions on device page. Website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebOpinionsGSMArenaTest extends AbstractTest {

    @Test(description = "verify whether opinions were sorted by best rating")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testOpinionsSortByBestRating() {
        User user = UserService.getUser();
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.login(user.getEmail(), user.getPassword());

        PhonesPage phonesPage = homePage.getPhoneFinderForm().openRandomPhonesPage();
        Assert.assertTrue(phonesPage.isPageOpened(), "Phones page was not opened!");

        DevicePage devicePage = phonesPage.openRandomDevice();
        Assert.assertTrue(devicePage.isPageOpened(), "Device page was not opened!");

        OpinionsPage opinionsPage = devicePage.openOpinions();
        Assert.assertTrue(opinionsPage.isPageOpened(), "Opinions page was not opened!");

        Assert.assertTrue(opinionsPage.isPossibleSortByBestRating(), "Drop down menu for 'Sort by' was not found on page!");
        opinionsPage.sortByBestRating();
        Assert.assertTrue(opinionsPage.isCommentsSortByBestRating(), "Opinions were not sorted by best rating!");
    }

    @Test(description = "verify whether we can rate opinion")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testRateOpinion() {
        User user = UserService.getUser();
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.login(user.getEmail(), user.getPassword());

        PhonesPage phonesPage = homePage.getPhoneFinderForm().openRandomPhonesPage();
        Assert.assertTrue(phonesPage.isPageOpened(), "Phones page was not opened!");

        DevicePage devicePage = phonesPage.openRandomDevice();
        Assert.assertTrue(devicePage.isPageOpened(), "Device page was not opened!");

        OpinionsPage opinionsPage = devicePage.openOpinions();
        Assert.assertTrue(opinionsPage.isPageOpened(), "Opinions page was not opened!");

        opinionsPage.verifyGoodRateComment();
    }

    @Test(description = "verify whether opinions were sorted by newest first")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testOpinionsSortedByNewestFirst() {
        User user = UserService.getUser();
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.login(user.getEmail(), user.getPassword());

        PhonesPage phonesPage = homePage.getPhoneFinderForm().openRandomPhonesPage();
        Assert.assertTrue(phonesPage.isPageOpened(), "Phones page was not opened!");

        DevicePage devicePage = phonesPage.openRandomDevice();
        Assert.assertTrue(devicePage.isPageOpened(), "Device page was not opened!");

        OpinionsPage opinionsPage = devicePage.openOpinions();
        Assert.assertTrue(opinionsPage.isPageOpened(), "Opinions page was not opened!");

        opinionsPage.sortByNewestFirst();

        Assert.assertTrue(opinionsPage.isCommentsSortByNewestFirst(), "Opinions were not sorted by Newest first!");
    }
}
