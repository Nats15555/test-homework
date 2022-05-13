package page.idea;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IdeaPage {
    private final WebDriver driver;

    public IdeaPage(WebDriver driver) {
        this.driver = driver;
    }

    public IdeaPage shareMood() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("scroll-slider_item")));
        WebElement firstEmotion = driver.findElement(By.className("scroll-slider_item"));
        firstEmotion.click();

        return this;
    }

    public IdeaPage addNewMessageWithEmotion(String message) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,\"feeling-layer_form\")]")));

        driver.findElement(By.xpath("//*[contains(@class,\"feeling-layer_form\")]/div[position() = 1]/div/div/textarea")).sendKeys(message);
        driver.findElement(By.xpath("//*[contains(@class,\"feeling-layer_form\")]/div[position() = 2]/button")).click();

        return this;
    }

    public boolean chekCorrectExecution() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hook_Block_TipBlock\"]/div/div/div")));

        return driver.findElement(By.xpath("//*[@id=\"hook_Block_TipBlock\"]/div/div/div")).isDisplayed();

    }
}
