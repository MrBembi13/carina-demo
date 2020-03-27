package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test glossary on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */

public class WebGlossaryGSMArenaTest extends AbstractTest {
    private HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @Test(description = "Test glossary paragraph's header and text by first letter")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testGlossaryParagraphHeaderAndTextByFirstLetter() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page was not opened");

        Assert.assertTrue(glossaryPage.verifyParagraphElementsByFirstLetter(), "Link element in Glossary page didn't in alphabetical order!");
    }

    @Test(description = "Test glossary paragraph's text by alphabet")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testGlossaryParagraphTextByAlphabet() {
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened!");

        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page was not opened");

        Assert.assertTrue(glossaryPage.verifyParagraphTextByAlphabet(), "Paragraph's text did not sort by alphabet!");
    }
}
