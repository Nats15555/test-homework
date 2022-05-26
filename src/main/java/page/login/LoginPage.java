package page.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.LoadableComponent;
import page.main.MainPage;
import data.login.User;

public class LoginPage implements LoadableComponent {//+
    private final By idEmail = By.id("field_email");
    private final By idPassword = By.id("field_password");
    private final By xpathBottom = By.xpath("//*[contains(@class,\"login-form-actions\")]/input");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage doLogin(User user) {
        chekLoadComponent(driver, 3, idEmail);
        chekLoadComponent(driver, 3, idPassword);
        chekLoadComponent(driver, 3, xpathBottom);
        driver.findElement(idEmail).sendKeys(user.getLogin());
        driver.findElement(idPassword).sendKeys(user.getPassword());
        driver.findElement(xpathBottom).click();
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
