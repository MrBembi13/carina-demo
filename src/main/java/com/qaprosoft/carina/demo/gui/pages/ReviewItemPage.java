package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class ReviewItemPage extends AbstractPage {
    private Logger LOGGER = Logger.getLogger(ReviewItemPage.class);

    @FindBy(xpath = "//div[@class='article-info']//h1")
    private ExtendedWebElement nameReview;

    @FindBy(xpath = "//style[@type='text/css']")
    private ExtendedWebElement photo;

    public ReviewItemPage(WebDriver driver) {
        super(driver);
    }

    public String getNameReview() {
        return nameReview.getText();
    }

    public String[] getPhotoUrlReviewHeader() {
        String photoCSS = photo.getAttribute("innerHTML");
        String[] stringsPhotoCSS = photoCSS.split(Constants.SPLIT_CSS_FOR_URL);
        return stringsPhotoCSS[1].split(Constants.SPLIT_URL);
    }

    public boolean isPhotosEqual(String[] strings) {
        LOGGER.info("Url photo's review item - " + Arrays.toString(strings));
        LOGGER.info("Url photo's review header - " + Arrays.toString(getPhotoUrlReviewHeader()));
        for (int i = 0; i < strings.length; i++) {
            if (getPhotoUrlReviewHeader()[i].equals(strings[i])) {
                LOGGER.info("'" + getPhotoUrlReviewHeader()[i] + "' equals '" + strings[i] + "'");
            } else if (i == (strings.length - 2)) {
                LOGGER.info("We had different size photos - '" + getPhotoUrlReviewHeader()[i] + "' and '" + strings[i] + "'");
            } else {
                LOGGER.info("'" + getPhotoUrlReviewHeader()[i] + "' didn't equals '" + strings[i] + "'");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isPageOpened() {
        return nameReview.isElementPresent();
    }
}
