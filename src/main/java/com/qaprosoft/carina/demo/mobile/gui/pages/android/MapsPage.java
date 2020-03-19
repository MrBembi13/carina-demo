package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MapsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom in']")
    private ExtendedWebElement zoomInButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Zoom out']")
    private ExtendedWebElement zoomOutButton;

    public MapsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return zoomInButton.isElementPresent();
    }

    @Override
    public boolean isZoomInWork() {
        return zoomInButton.clickIfPresent();
    }

    @Override
    public boolean isZoomOutWork() {
        return zoomOutButton.clickIfPresent();
    }

    @Override
    public boolean isZoomOutLowerZoomIn() {
        return zoomInButton.getLocation().y < zoomOutButton.getLocation().y;
    }
}
