package page.message;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.message.Message;
import page.LoadableComponent;

public class MailBlock implements LoadableComponent {//+
    private final WebDriver driver;
    private final WebElement webMailElement;
    public final By xpathMessage = By.xpath("//*[contains(@data-tsid,\"message_root\")]");

    public MailBlock(WebDriver driver) {
        this.driver = driver;
        chekLoadComponent(driver, 5, By.id("msg_layer"));
        webMailElement = driver.findElement(By.id("msg_layer"));
    }

    public List<Message> getUserMassages() {
        chekLoadComponent(driver, 5, xpathMessage);
        List<WebElement> allMessage = webMailElement.findElements(xpathMessage);
        List<Message> messageList = new ArrayList<>();

        for (WebElement temp : allMessage) {
            String[] messageFields = temp.getText().split("\\n");
            messageList.add(new Message(messageFields[0], messageFields[1]));
        }

        return messageList;
    }
}
