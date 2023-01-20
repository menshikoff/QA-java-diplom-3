package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;
    public By buttonPersonalCabinet = By.xpath(".//a[@href='/account']");
    public By buttonEnterAccount = By.className("button_button__33qZ0");
    public By buttonPlaceOrder = By.xpath(".//button[text()='Оформить заказ']");
    public By sectionBurgerIngredients = By.className("BurgerIngredients_ingredients__1N8v2");
    private final By tabButtons = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]");

    public final By headerSectionFiller = By.xpath("//h2[text()='Начинки']");
    public final By headerSectionSauce = By.xpath("//h2[text()='Соусы']");
    public final By headerSectionBread = By.xpath("//h2[text()='Булки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(URL);
        return this;
    }
    public void clickButtonPersonalCabinet() {
        driver.findElement(buttonPersonalCabinet).click();
    }

    public void clickButtonEnterAccount() {
        driver.findElement(buttonEnterAccount).click();
    }

    public boolean isSectionBurgerIngredientsVisible() {
        return driver.findElement(sectionBurgerIngredients).isDisplayed();
    }

    public boolean isButtonPlaceOrderVisible() {

        return driver.findElement(buttonPlaceOrder).isDisplayed();
    }

    public WebElement getTabButtonBread() { return driver.findElements(tabButtons).get(0);}
    public WebElement getTabButtonSauce() { return driver.findElements(tabButtons).get(1);}
    public WebElement getTabButtonFiller() {return  driver.findElements(tabButtons).get(2);}

    public void clickTabButtonBread() {
        driver.findElements(tabButtons).get(0).click();
    }

    public void clickTabButtonSauce() {
        driver.findElements(tabButtons).get(1).click();
    }

    public void clickTabButtonFiller() {
        driver.findElements(tabButtons).get(2).click();
    }

    public int getHeaderSectionFillerLocationY() {
        return driver.findElement(headerSectionFiller).getLocation().y;
    }

    public int getHeaderSectionBreadLocationY() {
        return driver.findElement(headerSectionBread).getLocation().y;
    }

    public int getHeaderSectionSauceLocation() {
        return driver.findElement(headerSectionSauce).getLocation().y;
    }

    public WebElement getHeaderSectionSauce() { return driver.findElement(headerSectionSauce);}

    public WebElement getHeaderSectionBread() { return driver.findElement(headerSectionBread);}

    public WebElement getHeaderSectionFiller() { return driver.findElement(headerSectionFiller);}

}
