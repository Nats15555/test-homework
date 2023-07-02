package page.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.LoadableComponent;

public class GroupPage implements LoadableComponent {
    private final WebDriver driver;
    private final By firstGroupButton = By.xpath("//*[@class=\"button-pro group-join_btn __small __sec\"]");
    private final By enteredCorrectly = By.xpath("//span[contains(text(), 'Вы в группе')]");

    public GroupPage(WebDriver driver) {
        this.driver = driver;
    }

    public GroupPage subscribeToGroup() {
        chekLoadComponent(driver, 5, firstGroupButton);
        driver.findElement(firstGroupButton).click();
        return this;
    }

    public boolean checkSubscribeToGroup() {
        chekLoadComponent(driver, 5, enteredCorrectly);
        return driver.findElement(enteredCorrectly).isDisplayed();
    }
}
