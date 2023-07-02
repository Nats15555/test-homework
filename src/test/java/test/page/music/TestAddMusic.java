package test.page.music;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import data.music.Music;
import page.music.MusicPage;
import test.AbstractTest;

public class TestAddMusic extends AbstractTest {

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на добавления 3 песен к себе")
    @Test
    public void addThreeSongs() {
        MusicPage musicPage = mainPage.openMusicOnMainPage();
        List<Music> musicList = musicPage.addTreeSongs();
        assertTrue(musicPage.clickMyMusic().checkCountSongs(musicList, 3));
    }

}
