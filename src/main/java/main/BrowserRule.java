package main;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserRule extends ExternalResource {

    private WebDriver driver;

    public WebDriver getDriver() { return driver;}

    @Override
    protected void before() {

        if (System.getProperties().getProperty("browser").equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.yandex");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/etc/alternatives/yandex-browser");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}
        else {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}
    }

    @Override
    protected void after() {driver.quit();}
}
