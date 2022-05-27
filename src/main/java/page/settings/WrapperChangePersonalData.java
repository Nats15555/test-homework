package page.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.LoadableComponent;

public class WrapperChangePersonalData implements LoadableComponent {
    private final WebDriver driver;
    private final WebElement changePersonalDataBlock;
    private final By fieldTxtName = By.id("field_name");
    private final By fieldTxtSurname = By.id("field_surname");
    private final By buttonSave = By.id("hook_FormButton_button_savePopLayerEditUserProfileNew");

    public WrapperChangePersonalData(WebDriver driver) {
        this.driver = driver;
        chekLoadComponent(driver,5, By.className("modal-new_center"));
        changePersonalDataBlock = driver.findElement(By.className("modal-new_center"));
    }

    public SettingsPage changeNameAndSurname(String name, String surname){
        chekLoadComponent(driver,5, fieldTxtName);
        chekLoadComponent(driver,5, fieldTxtSurname);
        chekLoadComponent(driver,5, buttonSave);
        changePersonalDataBlock.findElement(fieldTxtName).clear();
        changePersonalDataBlock.findElement(fieldTxtName).sendKeys(name);
        changePersonalDataBlock.findElement(fieldTxtSurname).clear();
        changePersonalDataBlock.findElement(fieldTxtSurname).sendKeys(surname);
        changePersonalDataBlock.findElement(buttonSave).click();
        return new SettingsPage(driver);
    }

}
