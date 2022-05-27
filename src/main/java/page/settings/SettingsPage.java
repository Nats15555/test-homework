package page.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.LoadableComponent;

public class SettingsPage implements LoadableComponent {
    private final WebDriver driver;
    private final By xpathPersonalData = By.className("user-settings_i_n");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WrapperChangePersonalData openChangePersonalData(){
        chekLoadComponent(driver,5,xpathPersonalData);
        driver.findElement(xpathPersonalData).click();
        return new WrapperChangePersonalData(driver);
    }

    public boolean checkChangePersonalData(String name, String surname){
        chekLoadComponent(driver,5,xpathPersonalData);
        System.out.println(driver.findElement(xpathPersonalData).getText());
        return driver.findElement(xpathPersonalData).getText().contains(name)
                && driver.findElement(xpathPersonalData).getText().contains(surname);
    }

}
