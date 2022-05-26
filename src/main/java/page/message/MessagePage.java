package page.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.LoadableComponent;

public class MessagePage implements MessagePageInterface, LoadableComponent {//+

    private final WebDriver driver;
    private final MailBlock mailBlock;
    private final By messageBlock = By.xpath("//*[@id=\"msg_layer\"]");
    private final By sendMessageField = By.xpath("//*[@data-l=\"t,msgInput\"]");
    private final By sendButton = By.xpath("//*[@data-l=\"t,sendButton\"]");

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.mailBlock = new MailBlock(driver);
    }

    public MessagePage openDialog(String identification) {
        chekLoadComponent(driver, 3, messageBlock);
        driver.findElement(By.xpath(messageBlock + "//*[contains(@data-item-id,'" + identification + "')]")).click();
        return this;
    }

    public MessagePage sendMessage(String message) {
        chekLoadComponent(driver, 3, sendMessageField);
        chekLoadComponent(driver, 3, sendButton);
        driver.findElement(sendMessageField).sendKeys(message);
        driver.findElement(sendButton).click();
        return this;
    }

    public boolean chekMessage(String message) {
        return mailBlock.getUserMassages().stream().anyMatch(massage1 -> massage1.getMassageContent().equals(message));
    }

}
