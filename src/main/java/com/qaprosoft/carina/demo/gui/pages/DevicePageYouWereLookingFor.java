package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DevicePageYouWereLookingFor extends AbstractPage {

    @FindBy(xpath = "//h1[@class='specs-phone-name-title']")
    private ExtendedWebElement headText;

    public DevicePageYouWereLookingFor(WebDriver driver) {
        super(driver);
    }

    public boolean isPageHaveSearchTextInHead(String text) {
        return StringUtils.containsIgnoreCase(headText.getText(), text);
    }

    @Override
    public boolean isPageOpened(){
        return headText.isElementPresent();
    }
}
