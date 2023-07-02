package page.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import data.post.Post;
import page.LoadableComponent;

public class PostBlock implements LoadableComponent {
    private final WebDriver driver;
    private final WebElement webPostElement;
    private final By xpathPosts = By.xpath("//*[contains(@data-l,\"t,.c\")]");
    private final By firstPost = By.className("feed_b");

    public PostBlock(WebDriver driver) {
        this.driver = driver;
        chekLoadComponent(driver, 5, By.id("hook_Block_MainFeedsWrapper"));
        this.webPostElement = driver.findElement(By.id("hook_Block_MainFeedsWrapper"));
    }

    public List<Post> getAllPost() {
        chekLoadComponent(driver, 5, xpathPosts);
        List<WebElement> allPost = webPostElement.findElements(xpathPosts);
        List<Post> postList = new ArrayList<>();

        chekLoadComponent(driver, 5, firstPost);
        postList.add(new Post(webPostElement.findElement(firstPost).getText()));

        for (WebElement temp : allPost) {
            postList.add(new Post(temp.getText()));
        }

        return postList;
    }
}
