package page.photo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhotoPage {
    private final WebDriver driver;
    private final By loadingBox = By.cssSelector("div#hook_Block_PhotoVitrineBlock div input[type=file]");
    private final By correctDownloadMessage = By.xpath("//*[contains(@data-l,\"t,create-post\")]");

    public PhotoPage(WebDriver driver) {
        this.driver = driver;
    }


    public PhotoPage addNewPhoto(String path) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// не получилось брать не работало другое ожидание
        driver.findElement(loadingBox).sendKeys(path);
        return this;
    }

    public boolean checkAddingPhoto() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(correctDownloadMessage).isDisplayed();
    }
}
