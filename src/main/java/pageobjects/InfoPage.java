package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class InfoPage extends BasePage {

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement closeAdsButton;

    @AndroidFindBy(id = "com.medicom.maven.debug:id/page_icon")
    private MobileElement pageIcon;

    @AndroidFindBy(id = "com.medicom.maven.debug:id/page_counter")
    private MobileElement pageCounter;

    @AndroidFindBy(id = "com.medicom.maven.debug:id/page_primary_text")
    private MobileElement pagePrimaryText;

    @AndroidFindBy(id = "com.medicom.maven.debug:id/page_secondary_text")
    private MobileElement pageSecondaryText;

    public AppMainPage closeAdIfDisplayed() {
        if (closeAdsButton.isDisplayed()) closeAdsButton.click();

        return new AppMainPage(driver);
    }

    public InfoPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public BasePage initializePage() {
        return null;
    }

}
