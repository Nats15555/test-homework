package page.music;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.music.Music;
import page.LoadableComponent;

public class MusicPage implements LoadableComponent {//+
    private final WebDriver driver;
    private final MusicBlock musicBlock;
    private final By xpathClickMyMusic = By.xpath("//*[contains(@data-tsid,\"library\")]");

    public MusicPage(WebDriver driver) {
        this.driver = driver;
        this.musicBlock = new MusicBlock(driver);
    }

    public List<Music> addTreeSongs() {
        return musicBlock.addThreeTrendingSong();
    }

    public void clickMyMusic() {
        chekLoadComponent(driver, 5, xpathClickMyMusic);
        driver.findElement(xpathClickMyMusic).click();
    }

    public boolean checkCountSongs(List<Music> addMusicList, int count) {
        clickMyMusic();
        List<Music> myMusicList = musicBlock.getMusic();
        return (int) addMusicList.stream().filter(myMusicList::contains).count() == count;
    }
}
