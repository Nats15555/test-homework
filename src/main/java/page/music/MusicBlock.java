package page.music;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import data.music.Music;
import page.LoadableComponent;

public class MusicBlock implements LoadableComponent {//+
    private final WebDriver driver;
    private final WebElement webMusicElement;
    private final By xpathTopTracks = By.xpath("//*[contains(@data-l,\"t,top_tracks_list\")]");
    private final By xpathAddMusic = By.xpath("//*[contains(@data-tsid,\"track_add\")]");
    private final By xpathAllMusic = By.xpath("//*[contains(@data-l,\"t,tracks\")]");

    public MusicBlock(WebDriver driver) {
        this.driver = driver;
        webMusicElement = driver.findElement(By.id("music_layer_holder"));
    }

    public List<Music> getMusic() {
        chekLoadComponent(driver, 5, xpathAllMusic);
        List<WebElement> allMusic = webMusicElement.findElements(By.xpath("//*[contains(@data-l,\"t,tracks\")]" +
                "/slot/wm-tracks-list/main/wm-track"));
        List<Music> musicList = new ArrayList<>();

        for (WebElement temp : allMusic) {
            String[] musicFields = temp.getText().split("\\n");
            musicList.add(new Music(musicFields[0], musicFields[1]));
        }

        return musicList;
    }

    public List<Music> addThreeTrendingSong() {
        chekLoadComponent(driver, 3, xpathTopTracks);
        List<WebElement> allMusic = webMusicElement.findElements(By.xpath("//*[contains(@data-l,\"t,top_tracks_list\")]"
                + "/slot/top-tracks-list/wm-tracks-list/main/wm-track[position() <= 3]"));
        List<Music> musicList = new ArrayList<>();

        Actions action = new Actions(driver);
        for (WebElement temp : allMusic) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            action.moveToElement(temp);
            action.perform();
            chekLoadComponent(driver, 3, xpathAddMusic);
            temp.findElement(xpathAddMusic).click();

            String[] musicFields = temp.getText().split("\n");
            musicList.add(new Music(musicFields[0], musicFields[1].split(" – ")[0]));
        }

        return musicList;
    }

}
