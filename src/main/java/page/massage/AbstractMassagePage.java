package page.massage;

import org.openqa.selenium.WebDriver;

public interface AbstractMassagePage {

    static AbstractMassagePage getMassagePage(WebDriver driver){
        return new MassagePage(driver);
    }


}
