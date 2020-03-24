package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ParagraphElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlossaryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='st-text']//p")
    private List<ParagraphElement> paragraphGlossaryElements;

    @FindBy(xpath = "//div[@class='st-text']//h3")
    private List<ExtendedWebElement> h3;

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/glossary.php3");
    }

    public ParagraphElement getParagraphElements() {
        return new ParagraphElement(driver);
    }

    public List<ParagraphElement> getParagraphGlossary() {
        return paragraphGlossaryElements;
    }

    public List<ExtendedWebElement> getH3() {
        return h3;
    }
}
