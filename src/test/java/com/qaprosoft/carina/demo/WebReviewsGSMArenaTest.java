package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.ReviewItemPage;
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
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");
    }

    @Test(description = "test equal reviews header name with name on review page")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testEqualReviewHeaderNameWithNameOnPage() {
        ReviewsPage reviewsPage = homePage.getFooterMenu().openReviewsPage();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews page wasn't opened!");

        Assert.assertTrue(reviewsPage.verifyReviewsHeaderNameWithNameOnReviewPage(), "Name review item didn't equal name review on page!");
    }

    @Test(description = "test search on reviews page")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testSearchOnReviews() {
        ReviewsPage reviewsPage = homePage.getFooterMenu().openReviewsPage();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews page wasn't opened!");

        reviewsPage.typeWrongText();
        Assert.assertTrue(reviewsPage.isListItemsEmpty(), "Search was good when it should bad!");

        reviewsPage.clearSearchFiled();

        reviewsPage.typeValidatedText();
        Assert.assertTrue(reviewsPage.verifyGoodSearch(), "Header text hadn't contain search text!");
    }

    @Test(description = "test equal photos")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testPhotoOnReviews() {
        ReviewsPage reviewsPage = homePage.getFooterMenu().openReviewsPage();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews page wasn't opened!");

        String[] stringsPhotoUrlReviewItem = reviewsPage.getStringUrl();
        ReviewItemPage reviewItemPage = reviewsPage.getRandomReviewItem().openReviewItemPage();
        Assert.assertTrue(reviewItemPage.isPhotosEqual(stringsPhotoUrlReviewItem), "Photo review item didn't equal photo review page header!");
    }
}
