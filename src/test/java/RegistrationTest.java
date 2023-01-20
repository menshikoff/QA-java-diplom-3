import main.BrowserRule;
import main.User;
import org.junit.*;
import pom.LoginPage;
import pom.RegistrationPage;


public class RegistrationTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void registerUserWithWrongPassword() throws InterruptedException {
        RegistrationPage objRegistrationPage = new RegistrationPage(browserRule.getDriver());

        objRegistrationPage.open();
        objRegistrationPage.fillInTheRegistrationForm(user.getNAME(), user.getEMAIL(), "1q2w");
        objRegistrationPage.clickButtonRegister();

        Assert.assertTrue(objRegistrationPage.isTextWrongPasswordIsVisible());
    }

    @Test
    public void registrationUserTest() throws InterruptedException {
        RegistrationPage objRegistrationPage = new RegistrationPage(browserRule.getDriver());

        objRegistrationPage.open();
        objRegistrationPage
                .fillInTheRegistrationForm(user.getNAME(), user.getEMAIL(), user.getPASSWORD());
        objRegistrationPage.clickButtonRegister();

        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());
        Assert.assertTrue(objLoginPage.isLoginHeaderDisplayed());
    }

    @After
    public void deleteUserData() {
        try {
        user.deleteUser(user.getAccessToken(user.login()));}
        catch (Exception e) {};
    }

}
