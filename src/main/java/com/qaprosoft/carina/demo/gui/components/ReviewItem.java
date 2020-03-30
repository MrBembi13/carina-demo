package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.ReviewItemPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewItem extends AbstractUIObject {

    @FindBy(xpath = ".//h3")
    private ExtendedWebElement reviewItem;

    public ReviewItem(WebDriver driver) {
        super(driver);
    }

    public ReviewItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ReviewItemPage openReviewItemPage() {
        reviewItem.click();
        return new ReviewItemPage(driver);
    }

    public String getReviewItemName() {
        return reviewItem.getText();
    }
}
