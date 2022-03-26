import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.login.LoginPage;
import page.main.MainPage;
import login.data.User;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPageObject {

    private final WebDriver driver = new ChromeDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage = new MainPage(driver);
    private final User user = new User("79697115322", "doom800300", "Niki Niko");

    @Before
    public void start(){
        driver.get("https://ok.ru");
    }

    @Test
    public void authorization(){
        mainPage = loginPage.isAuth(user);
        assertTrue(mainPage.intoMainPage(user));
    }

    @Test
    public void authorizationAndLogOutTest() {
        mainPage = loginPage.isAuth(user);
        assertTrue(mainPage.intoMainPage(user));
        assertTrue(mainPage.logOut().intoLoginPage());
        /*мое тестирую xpath
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(MainPageTopNavigator.MUSIC.getXpath())).click();*/
    }
}

