package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.PhonesPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PhoneFinder extends AbstractUIObject {

    @FindBy(xpath = ".//li")
    private List<ExtendedWebElement> phonesLinks;

    public PhoneFinder(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PhonesPage getPhonesPage() {
        Random random = new Random();
        phonesLinks.get(random.nextInt(phonesLinks.size())).click();
        return new PhonesPage(driver);
    }
}
