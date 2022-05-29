package page.idea;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.LoadableComponent;

public class IdeaPage implements LoadableComponent {//+
    private final WebDriver driver;
    private final By textIdea = By.xpath("//*[contains(@class,\"feeling-layer_form\")]/div[position() = 1]/div/div/textarea");
    private final By buttonIdea = By.xpath("//*[contains(@class,\"feeling-layer_form\")]/div[position() = 2]/button");
    private final By correctAlert = By.xpath("//*[@id=\"hook_Block_TipBlock\"]/div/div/div");
    private final By emotion = By.className("scroll-slider_item");

    public IdeaPage(WebDriver driver) {
        this.driver = driver;
    }

    public IdeaPage shareMood() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(emotion).click();
        return this;
    }

    public IdeaPage addNewMessageWithEmotion(String message) {
        chekLoadComponent(driver, 5, textIdea);
        chekLoadComponent(driver, 5, buttonIdea);
        driver.findElement(textIdea).sendKeys(message);
        driver.findElement(buttonIdea).click();
        return this;
    }

    public boolean chekCorrectExecution() {
        chekLoadComponent(driver, 5, correctAlert);
        return driver.findElement(correctAlert).isDisplayed();
    }


}
