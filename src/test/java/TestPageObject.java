import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import login.data.User;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPageObject {

    WebDriver driver = new ChromeDriver();

    @Test
    public void authorizationTest(){
        User user = new User("79697115322","0234569Zz", "Niki Niko");
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ok.ru");
        assertTrue(loginPage.isAuth(user).intoMainPage(user));
    }
}

