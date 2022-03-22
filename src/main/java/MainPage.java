import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import login.data.User;


public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean intoMainPage(User user){
        String getData = driver.findElement(By.xpath("//*[contains(@class,\"nav-side_i  __with-ic __with-new-icons\")]/div")).getText();
        if(getData.equals(user.getNameAndSurname())){
            return true;
        }

        return false;
    }

}
