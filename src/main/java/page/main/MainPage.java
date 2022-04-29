package page.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.login.User;
import page.login.LoginPage;
import page.message.MessageFactory;
import page.message.MessagePage;
import page.message.MessagePageInterface;
import page.music.MusicPage;
import page.photo.PhotoPage;


public class MainPage {

    private final WebDriver driver;
    private final By xpathTopBar = By.xpath("//*[contains(@class,\"ucard-mini toolbar_ucard js-toolbar-menu\")]");
    private final By logOutButton = By.xpath("//*[contains(@data-l,\"t,logout\")]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isAuth(User user) {
        String getData = driver.findElement(By.xpath(MainPageRightNavigator.PAGE.getXpath() + "/div")).getText();
        if (getData.equals(user.getNameAndSurname())) {
            return true;
        }

        return false;
    }

    protected void checkLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainPageRightNavigator.PAGE.getXpath())));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathTopBar));
    }

    public LoginPage logOut() {
        checkLoaded();
        driver.findElement(xpathTopBar).click();
        driver.findElement(logOutButton).click();
        driver.findElement(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
        return new LoginPage(driver);
    }

    @Deprecated
    public MessagePage openMassagePageUseTopMenu() {//метод просто для тесов себя
        checkLoaded();
        driver.findElement(By.xpath(MainPageTopNavigator.MESSAGES.getXpath())).click();
        return new MessagePage(driver);
    }

    public MessagePageInterface openMessageFriendOnMainPage() {
        checkLoaded();
        Actions action = new Actions(driver);
        WebElement hiddenMessageButton = driver.findElement(By.xpath("//*[contains(@class,\"online-fr_i h-mod online-fr_hide-icons\")]"));
        action.moveToElement(hiddenMessageButton);
        action.perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(@data-l,\"t,sendMessage\")]")).click();
        MessageFactory massageFactory = new MessageFactory();
        return massageFactory.get(driver);
    }

    public MusicPage openMusicOnMainPage() {
        checkLoaded();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(MainPageTopNavigator.MUSIC.getXpath())).click();
        return new MusicPage(driver);
    }

    public PhotoPage openPhotoPage() {
        checkLoaded();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(MainPageRightNavigator.PHOTO.getXpath())).click();

        return new PhotoPage(driver);
    }


}
