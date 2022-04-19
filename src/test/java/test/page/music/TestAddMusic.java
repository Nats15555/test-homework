package test.page.music;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.AbstractTest;

public class TestAddMusic extends AbstractTest {

    @DisplayName("Тест на добавления 3 песен к себе")
    @Test
    public void addThreeSongs() {
        assertTrue(mainPage.openMusicOnMainPage()
                .addTreeSongsAndCheck());
    }

}
