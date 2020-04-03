package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PhonesPage extends AbstractPage {
    Logger LOGGER = Logger.getLogger(PhonesPage.class);

    @FindBy(xpath = "//div[@class='article-hgroup']")
    private ExtendedWebElement headNamePage;

    @FindBy(xpath = "//div[@class='makers']//li")
    private List<ExtendedWebElement> deviceList;

    public PhonesPage(WebDriver driver) {
        super(driver);
    }

    public DevicePage openRandomDevice() {
        Random random = new Random();
        int randomDevice = random.nextInt(deviceList.size());
        LOGGER.info("Go to '" + deviceList.get(randomDevice).getText() + "' page.");
        deviceList.get(randomDevice).click();
        return new DevicePage(driver);
    }

    @Override
    public boolean isPageOpened() {
        return headNamePage.isElementWithTextPresent("phones");
    }
}
