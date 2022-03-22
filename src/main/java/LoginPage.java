import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import login.data.User;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage isAuth(User user){
        MainPage mainPage = new MainPage(driver);
        driver.findElement(By.id("field_email")).sendKeys(user.getLogin());
        driver.findElement(By.id("field_password")).sendKeys(user.getPassword());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(@class,\"login-form-actions\")]/input")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return mainPage;
    }
}
