package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.xml.crypto.Data;

public class LoginPage {

    private final String url = "https://stellarburgers.nomoreparties.site/login";
    private final WebDriver driver;
    public final By loginHeader = By.xpath("//div[@class='Auth_login__3hAey']/h2[contains(text(), 'Вход')]");
    private final By buttonEnter = By.className("button_button__33qZ0");
    private By inputFields = By.className("input__textfield");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(url);
        return this;
    }

    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }

    public boolean isLoginHeaderDisplayed() {
        boolean result;
            try {
                return driver.findElement(loginHeader).isDisplayed();
            }
            catch (Exception e) {
                return false;
            }
    }

    public void fillLoginForm(String name, String password) {
        driver.findElements(inputFields).get(0).sendKeys(name);
        driver.findElements(inputFields).get(1).sendKeys(password);
    }

}
