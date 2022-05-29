package page;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Интерфейс показывает, что класс использует паттерн LoadableComponent
 */
public interface LoadableComponent {

    default void chekLoadComponent(WebDriver driver, long timeoutInSeconds, By checkedElement) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkedElement));
    }

    default void chekLoadComponents(WebDriver driver, long timeoutInSeconds, Collection<By> checkedElement) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        for(By temp: checkedElement){
            wait.until(ExpectedConditions.visibilityOfElementLocated(temp));
        }
    }
}
