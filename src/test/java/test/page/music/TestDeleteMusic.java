package test.page.music;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import data.music.Music;
import page.music.MusicPage;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDeleteMusic extends AbstractTest {
    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на удаление песен, которые были переданы")
    @Test
    public void deleteSongs() {
        MusicPage musicPage = mainPage.openMusicOnMainPage();
        List<Music> musicList = musicPage.addTreeSongs();
        assertTrue(musicList.containsAll(musicPage.clickMyMusic().deleteSongsFromList(musicList)));
    }
}
