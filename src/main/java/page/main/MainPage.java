package page.main;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import data.login.User;
import data.post.Post;
import page.LoadableComponent;
import page.group.GroupPage;
import page.idea.IdeaPage;
import page.login.LoginPage;
import page.message.MessageFactory;
import page.message.MessagePage;
import page.message.MessagePageInterface;
import page.music.MusicPage;
import page.photo.PhotoPage;
import page.post.PostPage;
import page.user.UserPage;


public class MainPage implements LoadableComponent {

    private final WebDriver driver;
    private final By xpathTopBar = By.xpath("//*[contains(@class,\"ucard-mini toolbar_ucard js-toolbar-menu\")]");
    private final By logOutButton = By.xpath("//*[contains(@data-l,\"t,logout\")]");
    private final By hiddenLogOutButton = By.id("hook_FormButton_logoff.confirm_not_decorate");
    private final By ideaButton = By.xpath("//*[contains(@class,\"add-stub al add-stub__hor __motivator-showcase-btn\")]");
    private final By postField = By.xpath("//*[contains(@class,\"pf-head_itx\")]");
    private final By firstOnlineFriend = By.xpath("//*[contains(@class,\"online-fr_i h-mod online-fr_hide-icons\")]");
    private final By mailButton = By.xpath("//*[contains(@data-l,\"t,sendMessage\")]");
    private PostBlock postBlock = null;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAuth(User user) {
        chekLoadComponent(driver, 5, By.xpath(MainPageRightNavigator.PAGE.getXpath() + "/div"));
        return driver.findElement(By.xpath(MainPageRightNavigator.PAGE.getXpath() + "/div")).getText().equals(user.getNameAndSurname());
    }

    public LoginPage logOut() {
        chekLoadComponent(driver, 5, xpathTopBar);
        chekLoadComponent(driver, 5, logOutButton);
        chekLoadComponent(driver, 5, hiddenLogOutButton);
        driver.findElement(xpathTopBar).click();
        driver.findElement(logOutButton).click();
        driver.findElement(hiddenLogOutButton).click();
        return new LoginPage(driver);
    }

    public UserPage openUserPage(){
        chekLoadComponent(driver, 5, By.xpath(MainPageRightNavigator.PAGE.getXpath()));
        driver.findElement(By.xpath(MainPageRightNavigator.PAGE.getXpath())).click();
        return new UserPage(driver);
    }

    public GroupPage openGroupPage(){
        chekLoadComponent(driver, 5, By.xpath(MainPageRightNavigator.GROUPS.getXpath()));
        driver.findElement(By.xpath(MainPageRightNavigator.GROUPS.getXpath())).click();
        return new GroupPage(driver);
    }

    @Deprecated
    public MessagePage openMassagePageUseTopMenu() {//метод просто для тесов себя
        chekLoadComponent(driver, 5, By.xpath(MainPageTopNavigator.MESSAGES.getXpath()));
        driver.findElement(By.xpath(MainPageTopNavigator.MESSAGES.getXpath())).click();
        return new MessagePage(driver);
    }

    public MessagePageInterface openMessageFriendOnMainPage() {
        chekLoadComponent(driver,5, firstOnlineFriend);
        Actions action = new Actions(driver);
        WebElement hiddenMessageButton = driver.findElement(firstOnlineFriend);
        action.moveToElement(hiddenMessageButton);
        action.perform();
        chekLoadComponent(driver,5, mailButton);
        driver.findElement(mailButton).click();
        MessageFactory massageFactory = new MessageFactory();
        return massageFactory.get(driver);
    }

    public MusicPage openMusicOnMainPage() {
        chekLoadComponent(driver, 5, By.xpath(MainPageTopNavigator.MUSIC.getXpath()));
        driver.findElement(By.xpath(MainPageTopNavigator.MUSIC.getXpath())).click();
        return new MusicPage(driver);
    }

    public PhotoPage openPhotoPage() {
        chekLoadComponent(driver, 5, By.xpath(MainPageRightNavigator.PHOTO.getXpath()));
        driver.findElement(By.xpath(MainPageRightNavigator.PHOTO.getXpath())).click();
        return new PhotoPage(driver);
    }

    public IdeaPage openIdeaPage() {
        chekLoadComponent(driver, 5, ideaButton);
        driver.findElement(ideaButton).click();
        return new IdeaPage(driver);
    }

    public PostPage openPostPage() {
        chekLoadComponent(driver, 5, postField);
        driver.findElement(postField).click();
        return new PostPage(driver);
    }

    public boolean checkPostDisplay(Post post){
        postBlock = new PostBlock(driver);
        return postBlock.getAllPost().contains(post);
    }
}
