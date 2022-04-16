package test.page.music;

import org.junit.Assert;
import org.junit.Test;

import test.AbstractTest;

public class TestAddMusic extends AbstractTest {

    @Test
    public void addThreeSongs() {
        Assert.assertTrue(mainPage.openMusicOnMainPage()
                .addTreeSongsAndCheck());
    }

}
