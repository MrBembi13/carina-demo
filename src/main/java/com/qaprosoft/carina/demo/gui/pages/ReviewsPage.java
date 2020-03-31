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

    public boolean verifyReviewsHeaderNameWithNameOnReviewPage() {
        for (int i = 0; i < reviewItemList.size(); i++) {
            String nameReviewItem = reviewItemList.get(i).getReviewItemName();
            ReviewItemPage reviewItemPage = reviewItemList.get(i).openReviewItemPage();
            String nameReview;
            if (reviewItemPage.isPageOpened()) {
                nameReview = reviewItemPage.getNameReview();
                LOGGER.info("Review item page was opened.");
            } else {
                LOGGER.error("Review item page wasn't opened!");
                return false;
            }
            if (nameReviewItem.equals(nameReview)) {
                LOGGER.info("`" + nameReviewItem + "` equals `" + nameReview + "`");
            } else {
                LOGGER.error("`" + nameReviewItem + "` didn't equals `" + nameReview + "`!!!");
                return false;
            }
            driver.navigate().back();
        }
        return true;
    }
}
