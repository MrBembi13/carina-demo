package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ReviewsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test reviews on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebReviewsGSMArenaTest extends AbstractTest {
    private HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @Test(description = "test equal reviews header name with name on review page")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testEqualReviewHeaderNameWithNameOnPage() {
        Assert.assertTrue(homePage.isPageOpened(),"Home page wasn't opened!");

        ReviewsPage reviewsPage = homePage.getFooterMenu().openReviewsPage();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews page wasn't opened!");

        Assert.assertTrue(reviewsPage.verifyReviewsHeaderNameWithNameOnReviewPage(), "Name review item didn't equal name review on page!");
    }
}
