package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.ParagraphElement;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Test glossary on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */

public class WebGlossaryGSMArenaTest extends AbstractTest {
    @Test(description = "Test glossary")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testGlossary() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page was not opened");

        //List<ExtendedWebElement> paragraphGlossaries = glossaryPage.getParagraphGlossary().getParagraphGlossaryElements();
        //List<String> stringList = Arrays.asList(paragraphGlossary.readParagraphText().split(" | "));
        //for (ExtendedWebElement s: paragraphGlossaries) {
        //    System.out.println(s.);
        //}
        List<ParagraphElement> paragraphElementList = glossaryPage.getParagraphGlossary();
        List<ExtendedWebElement> h3 = glossaryPage.getH3();
        glossaryPage.getParagraphElements().abcd(paragraphElementList, h3);

        /*for (ParagraphElement p: paragraphElementList) {
            List<ExtendedWebElement> extendedWebElementList = p.getLinkElements();
            for (ExtendedWebElement e: extendedWebElementList) {
                if (StringUtils.indexOfIgnoreCase(e.getText(),"a") == 0)
                    System.out.println(e.getText());

                if (StringUtils.indexOfIgnoreCase(e.getText(),"b") == 0)
                    System.out.println(e.getText());
            }
        }*/
    }
}
