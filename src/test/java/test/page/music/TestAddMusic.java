package test.page.music;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import page.music.MusicPage;
import test.AbstractTest;

public class TestAddMusic extends AbstractTest {

    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на добавления 3 песен к себе")
    @Test
    public void addThreeSongs() {
        MusicPage musicPage = mainPage.openMusicOnMainPage();
        assertTrue(musicPage.checkCountSongs(musicPage.addTreeSongs(), 3));
    }

}
