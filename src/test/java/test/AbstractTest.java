package test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.login.LoginPage;
import page.main.MainPage;

public abstract class AbstractTest {
    protected final WebDriver driver = new ChromeDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected MainPage mainPage = new MainPage(driver);

    @BeforeEach
    public void start(){
        driver.get("https://ok.ru");
    }

    @AfterEach
    public void end(){
        driver.close();
    }

}
