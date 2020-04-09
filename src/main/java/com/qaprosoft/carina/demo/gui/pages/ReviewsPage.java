package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Constants;
import com.qaprosoft.carina.demo.gui.components.ReviewItem;
import com.qaprosoft.carina.demo.utils.RandomUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class ReviewsPage extends AbstractPage {
    private Logger LOGGER = Logger.getLogger(ReviewsPage.class);
    private Random random = new Random();

    @FindBy(xpath = "//div[@class='review-item clearfix']")
    List<ReviewItem> reviewItemList;

    @FindBy(xpath = "//a[@title='Next page']")
    private ExtendedWebElement nextPageButton;

    @FindBy(xpath = "//input[@class='searchFor']")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//input[@class='submit button button-small']")
    private ExtendedWebElement searchButton;

    private int randomReviewItem = random.nextInt(reviewItemList.size());

    public ReviewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/reviews.php3");
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
                LOGGER.info("`" + nameReviewItem + "` equals `" + nameReview + "`");
            } else {
                LOGGER.error("`" + nameReviewItem + "` didn't equals `" + nameReview + "`!!!");
                return false;
            }
            driver.navigate().back();
        }
        return true;
    }

    public void verifySearchSystemOnReviewsPage() {
        searchField.type(Constants.WRONG_SEARCH_TEXT_REVIEWS);
        searchButton.click();
        Assert.assertTrue(reviewItemList.isEmpty());

        searchField.getElement().clear();

        Assert.assertNotNull(RandomUtil.getRandomPhonesName(), "Method which get random phone name didn't work!");
        String searchText = RandomUtil.getRandomPhonesName();
        searchField.type(searchText);
        searchButton.click();

        String headerText = reviewItemList.get(randomReviewItem).getReviewItemName();
        Assert.assertTrue(headerText.contains(searchText), "Header text hadn't contain search text!");
    }

    public ReviewItem getRandomReviewItem() {
        return reviewItemList.get(randomReviewItem);
    }

    public String[] getStringUrl() {
        return reviewItemList.get(randomReviewItem).getReviewItemPhoto().split(Constants.SPLIT_URL);
    }
}
