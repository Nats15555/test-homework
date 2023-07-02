package page.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.LoadableComponent;
import page.main.MainPage;
import data.login.User;

public class LoginPage implements LoadableComponent {
    private static final By ID_EMAIL = By.id("field_email");
    private static final By ID_PASSWORD = By.id("field_password");
    private static final By LOGIN_BTN = By.xpath("//*[contains(@class,\"login-form-actions\")]/input");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage doLogin(User user) {
        chekLoadComponent(driver, 3, ID_EMAIL);
        chekLoadComponent(driver, 3, ID_PASSWORD);
        chekLoadComponent(driver, 3, LOGIN_BTN);
        driver.findElement(ID_EMAIL).sendKeys(user.getLogin());
        driver.findElement(ID_PASSWORD).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BTN).click();
        return new MainPage(driver);
    }

    public MainPage doLogin(String login, String password) {
        User user = new User.UserBuilder()
                .withLogin(login)
                .withPassword(password)
                .build();
        return doLogin(user);
    }
}
