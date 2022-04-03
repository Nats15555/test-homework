package page.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.login.User;
import page.login.LoginPage;
import page.massage.MassagePage;


public class MainPage {

    private final WebDriver driver;
    private final String xpathTopBar = "//*[contains(@class,\"ucard-mini toolbar_ucard js-toolbar-menu\")]";
    private final String logOutButton = "//*[contains(@data-l,\"t,logout\")]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean authMainPage(User user) {
        String getData = driver.findElement(By.xpath(MainPageRightNavigator.PAGE.getXpath() + "/div")).getText();
        if (getData.equals(user.getNameAndSurname())) {
            return true;
        }

        return false;
    }

    public LoginPage logOut() {
        driver.findElement(By.xpath(xpathTopBar)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath(logOutButton)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
        return new LoginPage(driver);
    }

    public MassagePage openMassagePage(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(MainPageTopNavigator.MESSAGES.getXpath())).click();
        return new MassagePage(driver);//передавать сюда то от чего мы отталкиваемся
    }


}
