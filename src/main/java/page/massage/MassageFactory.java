package page.massage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MassageFactory {

    public MassagePageInterface get(WebDriver driver){
        if(isButtonPresent(driver)){
            return new MassagePage(driver);
        }
        return null;//потому что у нас всего 1 страница
    }

    private boolean isButtonPresent(WebDriver driver){
        if(driver.findElement(By.xpath("//*[@id=\"msg_layer\"]")).isDisplayed()){
            return true;
        }
        return false;
    }
}
