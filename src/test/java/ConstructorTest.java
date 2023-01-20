import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.with;

public class ConstructorTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void moveToFillerConstructorSectionTest() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open();

        int minY = objMainPage.getHeaderSectionBreadLocationY() - 50;
        int maxY = objMainPage.getHeaderSectionBreadLocationY() + 50;

        objMainPage.clickTabButtonFiller();

        with().pollDelay(100, TimeUnit.MILLISECONDS).await().atMost
                (10, TimeUnit.SECONDS).untilAsserted(() -> Assert.assertTrue(
                        objMainPage.getHeaderSectionFillerLocationY() < maxY &
                        objMainPage.getHeaderSectionFillerLocationY() > minY));
    }

    @Test
    public void moveToSauceConstructorSectionTest() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open();

        int minY = objMainPage.getHeaderSectionBreadLocationY() - 50;
        int maxY = objMainPage.getHeaderSectionBreadLocationY() + 50;

        objMainPage.clickTabButtonSauce();

        with().pollDelay(100, TimeUnit.MILLISECONDS).await().atMost
                (10, TimeUnit.SECONDS).untilAsserted(() -> Assert.assertTrue(
                objMainPage.getHeaderSectionSauceLocation() < maxY &
                        objMainPage.getHeaderSectionSauceLocation() > minY));
    }

    @Test
    public void moveToFillerAndBackToBreadSectionTest() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open();

        int minY = objMainPage.getHeaderSectionBreadLocationY() - 50;
        int maxY = objMainPage.getHeaderSectionBreadLocationY() + 50;

        objMainPage.clickTabButtonFiller();

        with().pollDelay(100, TimeUnit.MILLISECONDS).await().atMost
                (10, TimeUnit.SECONDS).until(() ->
                objMainPage.getHeaderSectionFillerLocationY() < maxY &
                        objMainPage.getHeaderSectionFillerLocationY() > minY);

        objMainPage.clickTabButtonBread();

        with().pollDelay(100, TimeUnit.MILLISECONDS).await().atMost
                (10, TimeUnit.SECONDS).untilAsserted(() -> Assert.assertTrue(
                objMainPage.getHeaderSectionBreadLocationY() < maxY &
                        objMainPage.getHeaderSectionBreadLocationY() > minY));
    }

    @Test
    public void moveToFillerAndBackToSauceSectionTest() {
        MainPage objMainPage = new MainPage(browserRule.getDriver());
        objMainPage.open();

        int minY = objMainPage.getHeaderSectionBreadLocationY() - 50;
        int maxY = objMainPage.getHeaderSectionBreadLocationY() + 50;

        objMainPage.clickTabButtonFiller();

        with().pollDelay(100, TimeUnit.MILLISECONDS).await().atMost
                (10, TimeUnit.SECONDS).until(() ->
                objMainPage.getHeaderSectionFillerLocationY() < maxY &
                        objMainPage.getHeaderSectionFillerLocationY() > minY);

        objMainPage.clickTabButtonSauce();

        with().pollDelay(100, TimeUnit.MILLISECONDS).await().atMost
                (10, TimeUnit.SECONDS).untilAsserted(() -> Assert.assertTrue(
                objMainPage.getHeaderSectionSauceLocation() < maxY &
                        objMainPage.getHeaderSectionSauceLocation() > minY));
    }

}


