package test;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import data.login.User;
import page.login.LoginPage;
import page.main.MainPage;

public abstract class AbstractTest {
    protected final WebDriver driver = new ChromeDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected final User user = new User("technopolisBot145", "technopolis16"
            , "technopolisBot1 technopolisBot1");

    @Before
    public void start(){
        driver.get("https://ok.ru");
        mainPage = loginPage.isAuth(user);
    }


}
