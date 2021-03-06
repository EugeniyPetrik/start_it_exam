package pageobjects;

import api.HttpModule;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.io.IOException;

public class DisclaimerPage extends BasePage {

    @iOSFindBy(accessibility = "I agree")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.Button[@text=\"I AGREE\"]")
    private MobileElement iAgreeButton;

    public InfoPage clickIAgreeButtonIfDisplayed() throws IOException {
        if (HttpModule.methodPostLogin().equals("true")) iAgreeButton.click();

        return new InfoPage(driver);
    }

    public DisclaimerPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public BasePage initializePage() {
        return null;
    }

}
