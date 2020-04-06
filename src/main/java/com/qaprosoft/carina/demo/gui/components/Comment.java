package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Comment extends AbstractUIObject {
    Logger LOGGER = Logger.getLogger(Comment.class);

    @FindBy(xpath = ".//a[@class='voting-link vote-up']")
    private ExtendedWebElement goodRateComment;

    @FindBy(xpath = ".//span[@class='thumbs-score']")
    private ExtendedWebElement scoreComment;

    @FindBy(xpath = ".//li[@class='upost']")
    private ExtendedWebElement dateComment;

    public Comment(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getScoreComment() {
        return scoreComment;
    }

    public ExtendedWebElement getGoodRateComment() {
        return goodRateComment;
    }

    public String getStringDateComment() {
        return dateComment.getText();
    }

    public void upvoteRating() {
        goodRateComment.click();
    }
}
