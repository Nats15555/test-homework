package page.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePage implements MessagePageInterface {

    private final WebDriver driver;
    private final MailBlock mailBlock;
    private final By messageBlock = By.xpath("//*[@id=\"msg_layer\"]");
    private final By sendMessageField = By.xpath("//*[@data-l=\"t,msgInput\"]");
    private final By sendButton = By.xpath("//*[@data-l=\"t,sendButton\"]");

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.mailBlock = new MailBlock(driver);
    }

    protected void checkLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageBlock));
    }

    public MessagePage openDialog(String identification) {
        checkLoaded();
        driver.findElement(By.xpath(messageBlock + "//*[contains(@data-item-id,'" + identification + "')]")).click();
        return this;
    }

    protected void checkLoadedMessages() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendMessageField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendButton));
    }

    public MessagePage sendMessage(String message) {
        checkLoadedMessages();
        driver.findElement(sendMessageField).sendKeys(message);
        driver.findElement(sendButton).click();
        return this;
    }

    public boolean chekMessage(String message) {
        return mailBlock.getUserMassages().stream().anyMatch(massage1 -> massage1.getMassageContent().equals(message));
    }

}
