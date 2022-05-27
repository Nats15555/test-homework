package page.post;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.post.Post;
import page.LoadableComponent;
import page.main.MainPage;

public class PostPage implements LoadableComponent {//+

    private final WebDriver driver;
    private final By postBlock = By.xpath("//*[contains(@class,\"posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler\")]");
    private final By postButton = By.xpath("//*[contains(@data-l,\"t,button.submit\")]");

    public PostPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage cratePost(Post post) {
        chekLoadComponent(driver, 3, postBlock);
        chekLoadComponent(driver, 3, postButton);
        driver.findElement(postBlock).sendKeys(post.getContent());
        driver.findElement(postButton).click();
        return new MainPage(driver);
    }


}
