package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    public final String url = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final WebDriver driver;
    private By textButtonEnter = By.className("Auth_link__1fOlj");

    public RestorePasswordPage(WebDriver driver) {this.driver = driver;}

    public String getUrl() {return url;}

    public RestorePasswordPage open() {
        driver.get(url);
        return this;
    }

    public void clickTextButtonEnter() {
        driver.findElement(textButtonEnter).click();
    }
}
