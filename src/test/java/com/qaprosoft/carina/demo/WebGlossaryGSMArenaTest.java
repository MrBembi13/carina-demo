package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        Assert.assertTrue(glossaryPage.verifyParagraphElementsByFirstLetter(), "Link element in Glossary page didn't in alphabetical order!");
    }
}
