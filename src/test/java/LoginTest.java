import main.BrowserRule;
import main.User;
import org.junit.*;
import pom.*;


public class LoginTest {

    private User user;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void setUp() {
        user = new User();
        user.register();
    }

    @Test
    public void loginThroughButtonEnterAccountOnMainPage() {

        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());
        objMainPage.open();

        objMainPage.clickButtonEnterAccount();

        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();

        Assert.assertTrue(objMainPage.isButtonPlaceOrderVisible());
    }

    @Test
    public void loginThroughButtonPersonalCabinet() {

        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());

        objMainPage.open();
        objMainPage.clickButtonPersonalCabinet();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();

        Assert.assertTrue(objMainPage.isButtonPlaceOrderVisible());
    }

    @Test
    public void loginThroughButtonInRegistrationForm() {

        RegistrationPage objRegistrationPage = new RegistrationPage(browserRule.getDriver());
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());

        objRegistrationPage.open();
        objRegistrationPage.clickTextButtonEnter();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();

        Assert.assertTrue(objMainPage.isButtonPlaceOrderVisible());
    }

    @Test
    public void loginThroughButtonRestorePasswordForm() {

        RestorePasswordPage objRestorePasswordPage = new RestorePasswordPage(browserRule.getDriver());
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());

        objRestorePasswordPage.open();
        objRestorePasswordPage.clickTextButtonEnter();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();

        Assert.assertTrue(objMainPage.isButtonPlaceOrderVisible());
    }

    @After
    public void setDown() {
        user.deleteUser(user.getAccessToken(user.login()));
    }

}
