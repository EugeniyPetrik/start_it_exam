import enums.Platform;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

public class RegisterTest extends BaseTest {

    @Test(description = "Register user with correct params")
    public void registerAsUserWithCorrectParams() throws Exception {

        LoginPage loginUserPage = new LoginPage(driver);

        if (BasePage.platform.equals(Platform.ANDROID)) loginUserPage.closeDismissPopUp();

        loginUserPage
                .clickToSignUpButton()
                .fillFirstName("First name")
                .fillLastName("Last name")
                .fillUserEmail()
                .fillPassword("qwerty@13")
                .fillConfirmPassword("qwerty@13")
                .selectDiagnosis("None")
                .selectCountry("Ukraine")
                .fillPhoneNumber("0981234567")
                .clickButtonContinue()
                .fillAlternativeEmail()
                .fillAlternativePhoneNumber("0984561237")
                .selectGender("Male")
                .fillAddress("Avenue Street 15/A")
                .fillCity("New York City")
                .clickSignUpUser();

        ConfirmRegisterPage confirmPage = new ConfirmRegisterPage(driver);

        if (BasePage.platform.equals(Platform.ANDROID)) Assert.assertTrue(confirmPage
                .isAccountCreatedIconDisplayed());

        Assert.assertTrue(confirmPage
                .isAccountCreatedTitleDisplayed("Check your mailbox."));
        Assert.assertTrue(confirmPage
                .isAccountCreatedMessageDisplayed("Please, check your inbox for further instructions."));
        Assert.assertTrue(confirmPage
                .isEmailIsNotReceivedButtonDisplayed());

    }

    @Test(description = "Register user with correct params and Log In")
    public void registerAsUserWithCorrectParamsAndLogIn() throws Exception {

        LoginPage loginUserPage = new LoginPage(driver);

        if (BasePage.platform.equals(Platform.ANDROID)) loginUserPage.closeDismissPopUp();

        loginUserPage
                .clickToSignUpButton()
                .fillFirstName("First name")
                .fillLastName("Last name")
                .fillUserEmail()
                .fillPassword("qwerty@13")
                .fillConfirmPassword("qwerty@13")
                .selectDiagnosis("None")
                .selectCountry("Ukraine")
                .fillPhoneNumber("0981234567")
                .clickButtonContinue()
                .fillAlternativeEmail()
                .fillAlternativePhoneNumber("0984561237")
                .selectGender("Male")
                .fillAddress("Avenue Street 15/A")
                .fillCity("New York City")
                .clickSignUpUser()
                .clickTheButtonLogIn();

        new LoginPage(driver)
                .fillUserEmail("maventests+patient+1@gmail.com")
                .fillUserPassword("Password11")
                .clickTheButtonLogIn();

        new DisclaimerPage(driver)
                .clickIAgreeButtonIfDisplayed()
                .closeAdIfDisplayed();

        if (BasePage.platform.equals(Platform.IOS)) new SimplifyLoginPage(driver).clickSkipSimplifyLogin();

        Assert.assertTrue(new AppMainPage(driver)
                .isPageTitleDisplayed("Patient20 Patient"));

    }

}
