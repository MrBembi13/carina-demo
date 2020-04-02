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

    @Override
    public boolean isPageOpened() {
        return headText.isElementWithTextPresent("opinions");
    }
}
