package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ReviewItem;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewsPage extends AbstractPage {
    Logger LOGGER = Logger.getLogger(ReviewsPage.class);

    @FindBy(xpath = "//div[@class='review-item clearfix']")
    List<ReviewItem> reviewItemList;

    @FindBy(xpath = "//a[@title='Next page']")
    private ExtendedWebElement nextPageButton;

    public ReviewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/reviews.php3");
    }
/*

    public boolean clickNextButtonIfIsClickable() {
        if (nextPageButton.isClickable()) {
            LOGGER.info("Click on 'Next button'");
            nextPageButton.click();
        } else {
            return false;
        }
        return true;
    }
*/

    public List<ReviewItem> getReviewItemList() {
        return reviewItemList;
    }

    public boolean verifyReviewsHeaderNameWithNameOnReviewPage() {
        for (ReviewItem reviewItem : reviewItemList) {
            String nameReviewItem = reviewItem.getReviewItemName();
            ReviewItemPage reviewItemPage = reviewItem.openReviewItemPage();
            String nameReview;
            if (reviewItemPage.isPageOpened()) {
                nameReview = reviewItemPage.getNameReview();
                LOGGER.info("Review item page was opened.");
            } else {
                LOGGER.error("Review item page wasn't opened!");
                return false;
            }
            if (nameReviewItem.equals(nameReview)) {
                LOGGER.info("Name review item equals name review on the page.");
            } else {
                LOGGER.error("Name review item didn't equals name review on the page!");
                return false;
            }
            driver.navigate().back();
        }
        return true;
    }
}
