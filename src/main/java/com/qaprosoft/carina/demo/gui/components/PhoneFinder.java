package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.PhonesPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PhoneFinder extends AbstractUIObject {
    Logger LOGGER = Logger.getLogger(PhoneFinder.class);

    @FindBy(xpath = ".//li")
    private List<ExtendedWebElement> phonesLinks;

    public PhoneFinder(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PhonesPage openRandomPhonesPage() {
        Random random = new Random();
        int randomPhones = random.nextInt(phonesLinks.size());
        LOGGER.info("Go to '" + phonesLinks.get(randomPhones).getText() + "' phones.");
        phonesLinks.get(randomPhones).click();
        return new PhonesPage(driver);
    }
}
