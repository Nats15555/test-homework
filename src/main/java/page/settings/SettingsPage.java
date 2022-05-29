package page.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.LoadableComponent;
import page.main.MainPage;

public class SettingsPage implements LoadableComponent {
    private final WebDriver driver;
    private final By xpathPersonalData = By.className("user-settings_i_cnt");
    private final By xpathImgOK = By.className("toolbar_logo_img");

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

    public SettingsPage refresh(){
        driver.navigate().refresh();
        return new SettingsPage(driver);
    }

    public MainPage clickImgOK(){
        chekLoadComponent(driver,5,xpathImgOK);
        driver.findElement(xpathImgOK).click();
        return new MainPage(driver);
    }
}
