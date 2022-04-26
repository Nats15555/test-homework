package page.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.main.MainPage;
import data.login.User;

public class LoginPage {
    private final By idEmail = By.id("field_email");
    private final By idPassword = By.id("field_password");
    private final By xpathBottom = By.xpath("//*[contains(@class,\"login-form-actions\")]/input");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage doLogin(User user) {
        MainPage mainPage = new MainPage(driver);
        driver.findElement(idEmail).sendKeys(user.getLogin());
        driver.findElement(idPassword).sendKeys(user.getPassword());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(xpathBottom).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return mainPage;
    }

    public MainPage doLogin(String login, String password) {
        User user = new User.UserBuilder()
                .withLogin(login)
                .withPassword(password)
                .build();
        return doLogin(user);
    }

    public boolean intoLoginPage(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver.findElement(idEmail).isDisplayed();
    }
}
