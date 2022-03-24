package page.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import login.data.User;
import page.login.LoginPage;


public class MainPage {

    private final WebDriver driver;
    private final String xpathTopBar = "//*[contains(@class,\"ucard-mini toolbar_ucard js-toolbar-menu\")]";
    private final String logOutButton = "//*[contains(@data-l,\"t,logout\")]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean intoMainPage(User user) {
        String getData = driver.findElement(By.xpath(MainPageRightNavigator.PAGE.getXpath() + "/div")).getText();
        if (getData.equals(user.getNameAndSurname())) {
            return true;
        }

        return false;
    }

    public LoginPage logOut() {
        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(By.xpath(xpathTopBar)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(logOutButton)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
        return loginPage;
    }


}
