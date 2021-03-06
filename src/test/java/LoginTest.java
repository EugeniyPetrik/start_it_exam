import enums.Platform;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;

public class LoginTest extends BaseTest {

    @Test(description = "Log In with correct credentials")
    public void loginWithCorrectCredentials() throws Exception {

            new LoginPage(driver)
                .closeDismissPopUp()
                .fillUserEmail("maventests+patient+20@gmail.com")
                .fillUserPassword("Password11")
                .clickTheButtonLogIn()
                .clickIAgreeButtonIfDisplayed()
                .closeAdIfDisplayed();

        new SimplifyLoginPage(driver).clickSkipSimplifyLogin();

        Assert.assertTrue(new AppMainPage(driver)
                .isPageTitleDisplayed("Patient20 Patient"));
    }

    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
                { "some.email@example.com", "" },
                { "maventests+patient+1@gmail.com", "PasswordQWERTY" },
                { "", "Password11"},
                { "", "" }
        };
    }

    @Test(description = "Log In with incorrect credentials", dataProvider = "credentials")
    public void loginWithIncorrectCredentials(String email, String password) throws Exception {

        new LoginPage(driver)
                .closeDismissPopUp()
                .fillUserEmail(email)
                .fillUserPassword(password)
                .clickTheButtonLogIn();

        LoginPage loginUserPage = new LoginPage(driver);

        Assert.assertTrue(loginUserPage
                .isLoginFailedPopUpDisplayed());
        Assert.assertTrue(loginUserPage
                .isLoginIsFailedTextDisplayed("Log In failed"));
        Assert.assertTrue(loginUserPage
                .isEmailAndOrPasswordIncorrectTextDisplayed("Email and/or password incorrect!"));
    }
}
