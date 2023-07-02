package page.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageFactory {

    public MessagePageInterface get(WebDriver driver) {
        if (isButtonPresent(driver)) {
            return new MessagePage(driver);
        }
        return null;
    }

    private boolean isButtonPresent(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"msg_layer\"]")).isDisplayed();
    }
}
