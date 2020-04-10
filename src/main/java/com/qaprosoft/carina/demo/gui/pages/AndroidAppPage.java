package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.Constants;
import cucumber.api.java.cs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AndroidAppPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='gb_qc']")
    private ExtendedWebElement headerName;

    @FindBy(xpath = "//h1[@class='AHFaub']")
    private ExtendedWebElement nameApp;

    @FindBy(xpath = "//c-wiz[@jsrenderer='GxnCG']")
    private ExtendedWebElement rates;

    public AndroidAppPage(WebDriver driver) {
        super(driver);
    }

    public String getStringNameApp() {
        return nameApp.getText();
    }

    public void verifyComponentsOnAppPage() {
        Assert.assertTrue(getStringNameApp().equalsIgnoreCase(Constants.NAME_WEBSITE), "Name app didn't equal name website!");
        Assert.assertTrue(rates.isElementPresent(), "Rates wasn't found on page!");
    }

    @Override
    public boolean isPageOpened() {
        return headerName.isElementPresent();
    }
}
