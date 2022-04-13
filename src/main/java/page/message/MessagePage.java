package page.message;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import block.MailBlock;

public class MessagePage implements MessagePageInterface {

    private final WebDriver driver;
    private final MailBlock mailBlock;

    public MessagePage(WebDriver driver) {
        this.driver = driver;
        this.mailBlock = new MailBlock(driver);
    }

    public MessagePage openDialog(String identification) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"msg_layer\"]//*[contains(@data-item-id,'" + identification + "')]")).click();
        return this;
    }

    public MessagePage sendMessage(String message) {//отправка сообщения
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"msg_layer\"]//*[@data-l=\"t,msgInput\"]")).sendKeys(message);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"msg_layer\"]//*[@data-l=\"t,sendButton\"]")).click();
        return this;
    }

    public boolean chekMessage(String message) {
        return mailBlock.getUserMassages().stream().anyMatch(massage1 -> massage1.getMassageContent().equals(message));
    }

}
