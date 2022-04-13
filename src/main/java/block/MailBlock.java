package block;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.message.Message;

public class MailBlock {
    private final WebElement mainXpathBlock;

    public MailBlock(WebDriver driver) {
        mainXpathBlock = driver.findElement(By.xpath("//*[@id=\"msg_layer\"]"));
    }

    public List<Message> getUserMassages() {
        List<WebElement> allMessage = mainXpathBlock.findElements(By.xpath("//*[contains(@data-tsid,\"message_root\")]"));
        List<Message> messageList = new ArrayList<>();

        for (WebElement temp : allMessage) {
            String[] messageFields = temp.getText().split("\\n");
            messageList.add(new Message(messageFields[0], messageFields[1]));
        }

        return messageList;
    }
}
