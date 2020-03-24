package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ParagraphElement extends AbstractUIObject {

    @FindBy(xpath = ".//a")
    private List<ExtendedWebElement> linkElements;

    private List<String> linkElementsString = new ArrayList<>();

    public ParagraphElement(WebDriver driver) {
        super(driver);
    }

    public ParagraphElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<String> getParagraphGlossaryElements() {
        for (int i = 0; i < linkElements.size(); i++) {
            linkElementsString.add(i, linkElements.get(i).getText());
        }
        return linkElementsString;
    }
}
