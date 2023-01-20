import main.BrowserRule;
import main.User;
import org.junit.*;
import pom.LoginPage;
import pom.MainPage;
import pom.PersonalCabinet;

public class PersonalCabinetLinksTest {

    private User user;

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void setUp() {
        user = new User();
        user.register();
    }

    @Test
    public void linkFromMainPageToPersonalCabinetNonAuthorisedTest() {

        MainPage objMainPage = new MainPage(browserRule.getDriver());

        objMainPage.open();
        objMainPage.clickButtonPersonalCabinet();
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());

        Assert.assertTrue(objLoginPage.isLoginHeaderDisplayed());
    }

    @Test
    public void linkFromMainPageToPersonalCabinetTestAuthorisedTest() throws InterruptedException {

        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet objPersonalCabinet = new PersonalCabinet(browserRule.getDriver());

        objMainPage.open();
        objMainPage.clickButtonEnterAccount();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();
        objMainPage.clickButtonPersonalCabinet();

        Assert.assertEquals(user.getNAME(), objPersonalCabinet.getNameField().getAttribute("value"));
    }

    @Test
    public void linkFromPersonalCabinetToConstructorViaButtonTest() {

        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet objPersonalCabinet = new PersonalCabinet(browserRule.getDriver());

        objMainPage.open();
        objMainPage.clickButtonEnterAccount();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();
        objMainPage.clickButtonPersonalCabinet();
        objPersonalCabinet.clickButtonConsctractor();

        Assert.assertTrue(objMainPage.isSectionBurgerIngredientsVisible());
    }

    @Test
    public void linkFromPersonalCabinetToConstructorViaMainLogoTest() {

        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet objPersonalCabinet = new PersonalCabinet(browserRule.getDriver());

        objMainPage.open();
        objMainPage.clickButtonEnterAccount();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();
        objMainPage.clickButtonPersonalCabinet();
        objPersonalCabinet.clickMainLogo();

        Assert.assertTrue(objMainPage.isSectionBurgerIngredientsVisible());
    }

    @Test
    public void clickExitButtonFromCabinetTest() throws InterruptedException {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        LoginPage objLoginPage = new LoginPage(browserRule.getDriver());
        PersonalCabinet objPersonalCabinet = new PersonalCabinet(browserRule.getDriver());

        objMainPage.open();
        objMainPage.clickButtonEnterAccount();
        objLoginPage.fillLoginForm(user.getEMAIL(), user.getPASSWORD());
        objLoginPage.clickButtonEnter();
        objMainPage.clickButtonPersonalCabinet();
        objPersonalCabinet.clickButtonExit();

        Assert.assertTrue(objLoginPage.isLoginHeaderDisplayed());
    }

    @After
    public void clearUp() {
        user.deleteUser(user.getAccessToken(user.login()));
    }
}
