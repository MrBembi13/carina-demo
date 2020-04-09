package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.ReviewItemPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewItem extends AbstractUIObject {

    @FindBy(xpath = ".//h3//a")
    private ExtendedWebElement reviewText;

    @FindBy(xpath = ".//div[@class='review-item-media-wrap']//img")
    private ExtendedWebElement reviewItemPhoto;

    public ReviewItem(WebDriver driver) {
        super(driver);
    }

    public ReviewItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ReviewItemPage openReviewItemPage() {
        reviewText.click();
        return new ReviewItemPage(driver);
    }

    public String getReviewItemName() {
        return reviewText.getText();
    }

    public String getReviewItemPhoto() {
        return reviewItemPhoto.getAttribute("src");
    }
}
