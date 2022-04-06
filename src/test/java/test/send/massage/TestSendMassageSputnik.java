package test.send.massage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import data.login.User;
import page.login.LoginPage;
import page.main.MainPage;

public class TestSendMassageSputnik implements TestSendMassage{

    //это частный случай уже с моими данными (тут у меня не было ботов и тестировал на спутнике) сюда не надо смотерть)

    protected final WebDriver driver = new ChromeDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected final User user = new User("79697115322", "doom800300", "Niki Niko");

    @Before
    public void start(){
        driver.get("https://ok.ru");
        mainPage = loginPage.isAuth(user);
    }

    @Test
    public void sendMassage() {
        String massage = "My test20";
        boolean chek = mainPage.openMassagePageUseTopMenu()
                .openDialog("-82680697280182")
                .sendMassage(massage)
                .chekMassage(massage);
        System.out.println(chek);
        driver.close();
        Assert.assertTrue(chek);//разобраться с тестом
    }
}
