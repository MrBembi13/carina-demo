package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Comment;
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
        if (!newestFirst.getElement().isSelected()) {
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

    public boolean isCommentsSortByNewestFirst() {
        //  Constants
        final String SPLIT_SYMBOL = " ";
        final String MINUTES = "minutes";
        final String HOURS = "hours";

        //  First date for compare
        LocalDate firstLocalDate;
        //  Second date for compare
        LocalDate secondLocalDate;
        //  List short name moths
        List<String> shortNameMonths = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

        //  Comparison two dates
        for (int i = 0; i < commentsList.size() - 1; i++) {
            //  Array of strings with the first comment's date
            LOGGER.info("First date in String = " + commentsList.get(i).getDateComment().getText());
            String[] firstDateStrings = commentsList.get(i).getDateComment().getText().split(SPLIT_SYMBOL);

            //  Parse 'firstDateStrings' to LocalDate
            //  If comment was added recently(during hour)
            LOGGER.info("'" + firstDateStrings[1] + "' compare to '" + MINUTES + "'");
            if (firstDateStrings[1].equalsIgnoreCase(MINUTES)) {
                firstLocalDate = LocalDate.now();
                LOGGER.info("First date = " + firstLocalDate);
            } else
                //  If comment was added recently(during twenty-four hours)
                LOGGER.info("'" + firstDateStrings[1] + "' compare to '" + HOURS + "'");
                if (firstDateStrings[1].equalsIgnoreCase(HOURS)) {
                    //  How many hours ago was added comment
                    int hourComment = Integer.parseInt(firstDateStrings[0]);
                    LOGGER.info(hourComment + " " + HOURS + " ago was added comment");
                    //  What hour at the moment
                    int hourNow = LocalTime.now().getHour();
                    LOGGER.info(hourNow + " hour now");
                    // If comment was added today or yesterday
                    LOGGER.info(hourComment + " compare to " + hourNow);
                    if (hourComment <= hourNow) {
                        LOGGER.info(hourComment + " <= " + hourNow);
                        firstLocalDate = LocalDate.now();
                    } else {
                        LOGGER.info(hourComment + " > " + hourNow);
                        firstLocalDate = LocalDate.now().minusDays(1);
                    }
                    LOGGER.info("First date = " + firstLocalDate);
                } else {
                    //  If comment was added more than day ago
                    //  Day of month
                    int day = Integer.parseInt(firstDateStrings[0]);
                    //  Month of year
                    int month = 0;
                    //  Year
                    int year = Integer.parseInt(firstDateStrings[2]);

                    //  Parse name month to number month of year
                    for (int m = 0; m < shortNameMonths.size(); m++) {
                        LOGGER.info("'" + firstDateStrings[1] + "' compare to '" + shortNameMonths.get(m) + "'");
                        if (firstDateStrings[1].equalsIgnoreCase(shortNameMonths.get(m))) {
                            month = m + 1;
                            LOGGER.info(firstDateStrings[1] + " is " + month + "(-st/-rd/-th) month of year");
                            break;
                        }
                    }
                    //  First date for compare
                    firstLocalDate = LocalDate.of(year, month, day);
                    LOGGER.info("First date = " + firstLocalDate);
                }

            for (int j = i + 1; j < commentsList.size(); j++) {
                //  Array of strings with the second comment's date
                LOGGER.info("Second date in String = " + commentsList.get(j).getDateComment().getText());
                String[] secondDateStrings = commentsList.get(j).getDateComment().getText().split(SPLIT_SYMBOL);

                //  Parse 'secondDateStrings' to LocalDate
                //  If comment was added recently(during hour)
                LOGGER.info("'" + secondDateStrings[1] + "' compare to '" + MINUTES + "'");
                if (secondDateStrings[1].equalsIgnoreCase("minutes")) {
                    secondLocalDate = LocalDate.now();
                    LOGGER.info("Second date = " + secondLocalDate);
                } else
                    //  If comment was added recently(during twenty-four hours)
                    LOGGER.info("'" + secondDateStrings[1] + "' compare to '" + HOURS + "'");
                    if (secondDateStrings[1].equalsIgnoreCase("hours")) {
                        //  How many hours ago was added comment
                        int hourComment = Integer.parseInt(secondDateStrings[0]);
                        LOGGER.info(hourComment + " " + HOURS + " ago was added comment");
                        //  What hour at the moment
                        int hourNow = LocalTime.now().getHour();
                        LOGGER.info(hourNow + " hour now");
                        // If comment was added today or yesterday
                        LOGGER.info(hourComment + " compare to " + hourNow);
                        if (hourComment <= hourNow) {
                            LOGGER.info(hourComment + " <= " + hourNow);
                            secondLocalDate = LocalDate.now();
                        } else {
                            LOGGER.info(hourComment + " > " + hourNow);
                            secondLocalDate = LocalDate.now().minusDays(1);
                        }
                        LOGGER.info("Second date = " + secondLocalDate);
                    } else {
                        //  If comment was added more than day ago
                        //  Day of month
                        int day = Integer.parseInt(secondDateStrings[0]);
                        //  Month of year
                        int month = 0;
                        //  Year
                        int year = Integer.parseInt(secondDateStrings[2]);

                        //  Parse name month to number month of year
                        for (int m = 0; m < shortNameMonths.size(); m++) {
                            LOGGER.info("'" + secondDateStrings[1] + "' compare to '" + shortNameMonths.get(m) + "'");
                            if (secondDateStrings[1].equalsIgnoreCase(shortNameMonths.get(m))) {
                                month = m + 1;
                                LOGGER.info(secondDateStrings[1] + " is " + month + "(-st/-rd/-th) month of year");
                                break;
                            }
                        }
                        //  Second date for compare
                        secondLocalDate = LocalDate.of(year, month, day);
                        LOGGER.info("Second date = " + secondLocalDate);
                    }

                //  Compare two dates
                if (firstLocalDate.isAfter(secondLocalDate) || firstLocalDate.isEqual(secondLocalDate)) {
                    //  First date newer than second date or dates equal
                    LOGGER.info(firstLocalDate + " and " + secondLocalDate);
                } else {
                    //  First date older than second date
                    //  It's wrong and return false
                    LOGGER.error(firstLocalDate + " and " + secondLocalDate);
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
