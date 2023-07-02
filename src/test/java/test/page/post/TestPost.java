package test.page.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import data.post.Post;
import generator.post.GeneratorPost;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPost extends AbstractTest {
    private final Post post = new Post(new GeneratorPost().random());

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на выкладывание поста")
    @Test
    public void addNewPost() {
        assertTrue(mainPage.openPostPage().cratePost(post).checkPostDisplay(post));
    }

}
