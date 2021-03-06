package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Comment;
import com.qaprosoft.carina.demo.gui.components.Constants;
import com.qaprosoft.carina.demo.utils.DateUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpinionsPage extends AbstractPage {
    private Logger LOGGER = Logger.getLogger(OpinionsPage.class);

    @FindBy(xpath = "//h1[@class='specs-phone-name-title']")
    private ExtendedWebElement headText;

    @FindBy(id = "sort-comments")
    private ExtendedWebElement sortBy;

    @FindBy(xpath = "//option[@value='0']")
    private ExtendedWebElement newestFirst;

    @FindBy(xpath = "//option[@value='2']")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "//div[@class='user-thread']")
    private List<Comment> commentsList;

    public OpinionsPage(WebDriver driver) {
        super(driver);
    }

    public void sortByBestRating() {
        if (!bestRating.getElement().isSelected()) {
            sortBy.click();
            bestRating.click();
        }
    }

    public void sortByNewestFirst() {
        if (sortBy.isElementPresent() && !newestFirst.getElement().isSelected()) {
            sortBy.click();
            newestFirst.click();
        }
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
                if (Integer.parseInt(commentsList.get(i).getStringScoreComment()) >= Integer.parseInt(commentsList.get(j).getStringScoreComment())) {
                    LOGGER.info(commentsList.get(i).getStringScoreComment() + " more or equals " + commentsList.get(j).getStringScoreComment());
                } else {
                    LOGGER.error(commentsList.get(i).getStringScoreComment() + " less than " + commentsList.get(j).getStringScoreComment());
                    return false;
                }
            }
        }
        return true;
    }

    public void verifyGoodRateComment() {
        int beforeGoodRate = Integer.parseInt(commentsList.get(0).getStringScoreComment());
        commentsList.get(0).upvoteRating();
        int afterGoodRate = Integer.parseInt(commentsList.get(0).getStringScoreComment());
        Assert.assertTrue(beforeGoodRate < afterGoodRate, "Comment rating was not upvoted -> (last rating = " + beforeGoodRate + " and new rating = " + afterGoodRate + ")!");
    }

    public boolean isCommentsSortByNewestFirst() {
        //  First date for compare
        LocalDate firstLocalDate;
        //  Second date for compare
        LocalDate secondLocalDate;
        //  List dates
        List<LocalDate> dateList = new ArrayList<>();

        //  Parse and add dates to list
        for (Comment comment : commentsList) {
            String date = comment.getStringDateComment();
            dateList.add(DateUtil.parseDate(date));
            LOGGER.info("'" + date + "' added to list.");
        }

        LOGGER.info("All dates: " + dateList);
        //  Comparison two dates
        for (int i = 0; i < dateList.size() - 1; i++) {
            firstLocalDate = dateList.get(i);
            LOGGER.info("First date = " + firstLocalDate);

            secondLocalDate = dateList.get(i+1);
            LOGGER.info("Second date = " + secondLocalDate);

            //  Compare two dates
            if (firstLocalDate.isAfter(secondLocalDate) || firstLocalDate.isEqual(secondLocalDate)) {
                //  First date newer than second date or dates equal
                LOGGER.info("'" + firstLocalDate + " newer than " + secondLocalDate + "' or 'dates equal'");
            } else {
                //  First date older than second date
                //  It's wrong and return false
                LOGGER.error(firstLocalDate + " older than " + secondLocalDate);
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean isPageOpened() {
        return headText.isElementWithTextPresent("opinions");
    }
}
