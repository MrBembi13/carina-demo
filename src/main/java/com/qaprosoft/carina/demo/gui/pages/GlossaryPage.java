package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ParagraphElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlossaryPage extends AbstractPage {
    Logger LOGGER = Logger.getLogger(GlossaryPage.class);

    @FindBy(xpath = "//div[@class='st-text']//p")
    private List<ParagraphElement> paragraphGlossaryLinks;

    @FindBy(xpath = "//div[@class='st-text']//h3")
    private List<ExtendedWebElement> paragraphGlossaryNames;

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/glossary.php3");
    }

    public boolean verifyParagraphElementsByFirstLetter() {
        if (paragraphGlossaryLinks.size() == paragraphGlossaryNames.size()) {
            for (int i = 0; i < paragraphGlossaryLinks.size(); i++) {
                List<String> stringElementList = paragraphGlossaryLinks.get(i).getParagraphElementsString();
                for (String str : stringElementList) {
                    if (str.toUpperCase().charAt(0) == paragraphGlossaryNames.get(i).getText().charAt(0) ||
                            (Character.isDigit(str.charAt(0)) && Character.isDigit(paragraphGlossaryNames.get(i).getText().charAt(0)))) {
                        LOGGER.info("Paragraph " + paragraphGlossaryNames.get(i).getText() + ": " + str + ".");
                    } else {
                        LOGGER.error("Paragraph (" + paragraphGlossaryNames.get(i).getText() + ") can not have (" + str + ")!");
                        return false;
                    }
                }
            }
        } else {
            LOGGER.error("Paragraph's number headers and number texts did not equals!");
            return false;
        }
        return true;
    }

    public boolean verifyParagraphTextByAlphabet() {
        for (ParagraphElement paragElem: paragraphGlossaryLinks) {
            List<String> stringElementsList = paragElem.getParagraphElementsString();
            for (int i = 0; i < stringElementsList.size()-1; i++) {
                for (int j = i+1; j < stringElementsList.size(); j++) {
                    if (stringElementsList.get(i).compareToIgnoreCase(stringElementsList.get(j)) < 0) {
                        LOGGER.info("Paragraph's element: (" + stringElementsList.get(i) + ") lower than (" + stringElementsList.get(j) + ") by alphabet!");
                    } else {
                        LOGGER.error("Paragraph's element: (" + stringElementsList.get(i) + ") upper than (" + stringElementsList.get(j) + ") by alphabet!");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
