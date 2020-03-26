package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.DevicePageYouWereLookingFor;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class DropDownSearchForm extends AbstractUIObject {
    Logger LOGGER = Logger.getLogger(DropDownSearchForm.class);

    @FindBy(xpath = ".//div[@class='autocomplete autocomplete-search autocomplete-large']")
    private ExtendedWebElement dropDownSearchForm;

    @FindBy(xpath = "//div[@class='phone-results']//li//span")
    private List<ExtendedWebElement> devicesInForm;

    public DropDownSearchForm(WebDriver driver) {
        super(driver);
    }

    public DropDownSearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isDropDownSearchFormIsVisible() {
        return dropDownSearchForm.isVisible();
    }

    public boolean verifyListDevicesHaveText(String text) {
        if (!devicesInForm.isEmpty()) {
            LOGGER.info("Information was found with `" + text + "`.");
            for (ExtendedWebElement webElement: devicesInForm){
                if (StringUtils.containsIgnoreCase(webElement.getText(), text)) {
                    LOGGER.info("`" + webElement.getText() + "` contains - `" + text + "`.");
                } else {
                    LOGGER.error("`" + webElement.getText() + "` don't contains - `" + text + "`.");
                    return false;
                }
            }
        } else {
            LOGGER.error("Information was not found with `" + text + "`.");
            return false;
        }
        return true;
    }

    public DevicePageYouWereLookingFor openRandomDevicePage() {
        Random random = new Random();
        devicesInForm.get(random.nextInt(devicesInForm.size())).click();
        return new DevicePageYouWereLookingFor(driver);
    }
}
