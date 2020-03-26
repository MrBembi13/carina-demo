package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ParagraphElement extends AbstractUIObject {
    Logger LOGGER = Logger.getLogger(ParagraphElement.class);

    @FindBy(xpath = ".//a")
    private List<ExtendedWebElement> linkElements;

    public ParagraphElement(WebDriver driver) {
        super(driver);
    }

    public ParagraphElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<String> getParagraphElementsString() {
        List<String> linkElementsString = new ArrayList<>();
        for (ExtendedWebElement eWebElem: linkElements) {
                linkElementsString.add(eWebElem.getText());
        }
        LOGGER.info("Method return List<String>: " + linkElementsString);
        return linkElementsString;
    }
}
