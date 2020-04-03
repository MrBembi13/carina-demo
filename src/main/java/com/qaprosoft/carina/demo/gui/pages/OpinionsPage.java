package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Comment;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class OpinionsPage extends AbstractPage {
    private Logger LOGGER = Logger.getLogger(OpinionsPage.class);

    @FindBy(xpath = "//h1[@class='specs-phone-name-title']")
    private ExtendedWebElement headText;

    @FindBy(id = "sort-comments")
    private ExtendedWebElement sortBy;

    @FindBy(xpath = "//option[@value='2']")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "//div[@class='user-thread']")
    private List<Comment> commentsList;

    public OpinionsPage(WebDriver driver) {
        super(driver);
    }

    public void sortByBestRating() {
        sortBy.click();
        bestRating.click();
    }

    public boolean isPossibleSortByBestRating() {
        if (sortBy.isElementPresent()) {
            LOGGER.info("Sort possible.");
        } else {
            LOGGER.error("Sort impossible!");
            return false;
        }
        return true;
    }

    public boolean isCommentsSortByBestRating() {
        for (int i = 0; i < commentsList.size() - 1; i++) {
            for (int j = i + 1; j < commentsList.size(); j++) {
                if (Integer.parseInt(commentsList.get(i).getScoreComment().getText()) >= Integer.parseInt(commentsList.get(j).getScoreComment().getText())) {
                    LOGGER.info(commentsList.get(i).getScoreComment().getText() + " more or equals " + commentsList.get(j).getScoreComment().getText());
                } else {
                    LOGGER.error(commentsList.get(i).getScoreComment().getText() + " less than " + commentsList.get(j).getScoreComment().getText());
                    return false;
                }
            }
        }
        return true;
    }

    public void verifyGoodRateComment() {
        int beforeGoodRate = Integer.parseInt(commentsList.get(0).getScoreComment().getText());
        commentsList.get(0).upvoteRating();
        int afterGoodRate = Integer.parseInt(commentsList.get(0).getScoreComment().getText());
        Assert.assertTrue(beforeGoodRate < afterGoodRate, "Comment rating was not upvoted -> (last rating = " + beforeGoodRate + " and new rating = " + afterGoodRate + ")!");
    }

    @Override
    public boolean isPageOpened() {
        return headText.isElementWithTextPresent("opinions");
    }
}
