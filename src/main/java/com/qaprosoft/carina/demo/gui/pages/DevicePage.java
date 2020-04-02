package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DevicePage extends AbstractPage {
    private Logger LOGGER = Logger.getLogger(DevicePage.class);

    private static final String OPINIONS = "Opinions";

    @FindBy(xpath = "//h1[@class='specs-phone-name-title']")
    private ExtendedWebElement headText;

    @FindBy(xpath = "//li[@class='article-info-meta-link light']//a")
    private List<ExtendedWebElement> infoButtons;

    public DevicePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageHasSearchTextInHead(String text) {
        return StringUtils.containsIgnoreCase(headText.getText(), text);
    }

    public ExtendedWebElement getInfoElement(String text) {
        for (ExtendedWebElement e: infoButtons) {
            if (e.getText().equalsIgnoreCase(text)) {
                LOGGER.info(e.getText() + " will be open.");
                return e;
            }
        }
        LOGGER.error(text + " didn't found!");
        return null;
    }

    public OpinionsPage openOpinions() {
        getInfoElement(OPINIONS).click();
        return new OpinionsPage(driver);
    }

    @Override
    public boolean isPageOpened() {
        return headText.isElementPresent();
    }
}
