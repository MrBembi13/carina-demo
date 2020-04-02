package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OpinionsPage extends AbstractPage {
    private Logger LOGGER = Logger.getLogger(OpinionsPage.class);

    @FindBy(xpath = "//h1[@class='specs-phone-name-title']")
    private ExtendedWebElement headText;

    @FindBy(id = "sort-comments")
    private ExtendedWebElement sortBy;

    @FindBy(xpath = "//option[@value='2']")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "//span[@class='thumbs-score']")
    private List<ExtendedWebElement> scoreCommentList;

    @FindBy(xpath = "//a[@class='voting-link vote-up']")
    private List<ExtendedWebElement> goodRateCommentList;

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
        for (int i = 0; i < scoreCommentList.size() - 1; i++) {
            for (int j = i + 1; j < scoreCommentList.size(); j++) {
                if (Integer.parseInt(scoreCommentList.get(i).getText()) >= Integer.parseInt(scoreCommentList.get(j).getText())) {
                    LOGGER.info(scoreCommentList.get(i).getText() + " more or equals " + scoreCommentList.get(j).getText());
                } else {
                    LOGGER.error(scoreCommentList.get(i).getText() + " less than " + scoreCommentList.get(j).getText());
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyGoodRateComment() {
        int beforeGoodRate = Integer.parseInt(scoreCommentList.get(0).getText());
        goodRateCommentList.get(0).click();
        int afterGoodRate = Integer.parseInt(scoreCommentList.get(0).getText());
        if (beforeGoodRate < afterGoodRate) {
            LOGGER.info("Comment rating works -> (last rating = " + beforeGoodRate + " and new rating = " + afterGoodRate);
        } else {
            LOGGER.error("Comment rating don't work -> (last rating = " + beforeGoodRate + " and new rating = " + afterGoodRate);
            return false;
        }
        return true;
    }

    @Override
    public boolean isPageOpened() {
        return headText.isElementWithTextPresent("opinions");
    }
}
