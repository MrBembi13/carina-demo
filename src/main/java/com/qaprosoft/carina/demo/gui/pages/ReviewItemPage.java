package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReviewItemPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='article-info']//h1")
    private ExtendedWebElement nameReview;

    public ReviewItemPage(WebDriver driver) {
        super(driver);
    }

    public String getNameReview() {
        return nameReview.getText();
    }

    @Override
    public boolean isPageOpened() {
        return nameReview.isElementPresent();
    }
}
