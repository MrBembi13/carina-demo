package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ParagraphElement extends AbstractUIObject {

    @FindBy(xpath = ".//a")
    private List<ExtendedWebElement> linkElement;

    public ParagraphElement(WebDriver driver) {
        super(driver);
    }

    public ParagraphElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public List<ExtendedWebElement> getLinkElements() {
        return linkElement;
    }

    public void abcd(List<ParagraphElement> paragraphElementList, List<ExtendedWebElement> h3) {
        for (int i = 0; i < paragraphElementList.size(); i++) {
            List<ExtendedWebElement> extendedWebElementList = paragraphElementList.get(i).getLinkElements();
            for (ExtendedWebElement e: extendedWebElementList) {
                if (StringUtils.indexOfIgnoreCase(e.getText(), h3.get(i).getText()) == 0)
                    System.out.println(e.getText());

                //if (StringUtils.indexOfIgnoreCase(e.getText(),"b") == 0)
                //    System.out.println(e.getText());
            }
        }
    }








    /*
    public List<String> getParagraphGlossaryElements(List<ExtendedWebElement> linkElements, List<String> linkElementsString) {
        for (int i = 0; i < 344; i++) {
            linkElementsString.set(i, linkElements.get(i).getText());
        }
        return linkElementsString;
    }*/

    /*public String readParagraphText() {
        for (ExtendedWebElement p: linkElement) {
            return p.getElement().getText();
        }
        return "";
    }*/
}
