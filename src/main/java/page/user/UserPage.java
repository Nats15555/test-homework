package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import page.LoadableComponent;
import page.settings.SettingsPage;

public class UserPage implements LoadableComponent {
    private final WebDriver driver;
    private final By buttonSettings = By.xpath("//*[contains(@class,\"u-menu_a \")]");

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public SettingsPage clickSettingsPage(){
        chekLoadComponent(driver,5,buttonSettings);
        Actions action = new Actions(driver);
        WebElement hiddenButtonSettings = driver.findElement(buttonSettings);
        action.moveToElement(hiddenButtonSettings);
        action.perform();
        chekLoadComponent(driver,5, buttonSettings);
        driver.findElement(buttonSettings).click();
        return new SettingsPage(driver);
    }

}
