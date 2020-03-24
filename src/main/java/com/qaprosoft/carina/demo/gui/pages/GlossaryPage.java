package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ParagraphElement;
import org.apache.commons.lang3.StringUtils;
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
                List<String> stringElementList = paragraphGlossaryLinks.get(i).getParagraphGlossaryElements();
                for (String e : stringElementList) {
                    if (StringUtils.indexOfIgnoreCase(e, paragraphGlossaryNames.get(i).getText().substring(0, 1)) == 0) {
                        LOGGER.info("Paragraph " + paragraphGlossaryNames.get(i).getText() + ": " + e + ".");
                    } else if (paragraphGlossaryNames.get(i).getText().substring(0, 1).equalsIgnoreCase("0") &&
                                    (StringUtils.indexOfIgnoreCase(e,"0") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"1") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"2") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"3") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"4") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"5") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"6") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"7") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"8") == 0 ||
                                            StringUtils.indexOfIgnoreCase(e,"9") == 0 )) {
                        LOGGER.info("Paragraph " + paragraphGlossaryNames.get(i).getText() + ": " + e);
                    } else {
                        LOGGER.error("Paragraph (" + paragraphGlossaryNames.get(i).getText() + ") can not have (" + e + ")!");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
