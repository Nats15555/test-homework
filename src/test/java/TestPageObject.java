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

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    @Before
    public void start(){
        driver.get("https://ok.ru");
    }

    @Test
    public void authorizationAndLogOutTest() {
        User user = new User("79697115322", "doom800300", "Niki Niko");
        assertTrue(loginPage.isAuth(user).intoMainPage(user));
        assertTrue(mainPage.logOut().intoLoginPage());
        /*мое тестирую xpath
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(MainPageTopNavigator.MUSIC.getXpath())).click();*/
    }

    /*@Test
    public void logOutTest(){
        assertTrue(mainPage.logOut().intoLoginPage());
    }*/
}

