package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private final String url = "https://stellarburgers.nomoreparties.site/register";
    private final WebDriver driver;
    private By textButtonEnter = By.className("Auth_link__1fOlj");
    private By inputFields = By.className("input__textfield");
    private By buttonRegister = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");
    private By textWrongPassword = By.xpath("//p[contains(text(), 'Некорректный пароль')]");

    public RegistrationPage(WebDriver driver) {this.driver = driver;}

    public RegistrationPage open() {
        driver.get(url);
        return this;
    }

    public WebElement getTextButtonEnter() {
        return driver.findElement(textButtonEnter);
    }

    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    public void clickTextButtonEnter() {driver.findElement(textButtonEnter).click();}

    public boolean isTextWrongPasswordIsVisible() {
        return driver.findElement(textWrongPassword).isDisplayed();
    }
    public void fillInTheRegistrationForm(String name, String email, String password) throws InterruptedException {
        driver.findElements(inputFields).get(0).sendKeys(name);
        driver.findElements(inputFields).get(1).sendKeys(email);
        driver.findElements(inputFields).get(2).sendKeys(password);

    }

}
