package test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import data.login.User;
import page.login.LoginPage;
import page.main.MainPage;

public abstract class AbstractTest {
    protected final WebDriver driver = new ChromeDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();
//    protected final User user = new User("technopolisBot145", "technopolis16"
//            , "technopolisBot1 technopolisBot1"); //старый вариант без билдера

    @BeforeEach
    public void start(){
        driver.get("https://ok.ru");
        mainPage = loginPage.doLogin(user);
    }

    @AfterEach
    public void end(){
        driver.close();
    }

}
