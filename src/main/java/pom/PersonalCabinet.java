package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalCabinet {

    private final By inputFields = By.className("input__textfield");
    private final WebDriver driver;
    private final By buttonConstrator = By.xpath("//p[contains(text(),'Конструктор')]");
    private final By mainLogo = By.className("AppHeader_header__logo__2D0X2");
    private final By buttonExit = By.xpath("//button[contains(text(), 'Выход')]");
    public PersonalCabinet(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameField() {
        return driver.findElements(inputFields).get(0);
    }

    public void clickButtonConsctractor() {
        driver.findElement(buttonConstrator).click();
    }

    public void clickMainLogo() {
        driver.findElement(mainLogo).click();
    }

    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }
}
