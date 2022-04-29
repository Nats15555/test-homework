package page.music;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import data.music.Music;

public class MusicBlock {
    private final WebDriver driver;
    private final WebElement webMusicElement;

    public MusicBlock(WebDriver driver) {
        this.driver = driver;
        webMusicElement = driver.findElement(By.id("music_layer_holder"));
    }

    public List<Music> getMusic() {
        List<WebElement> allMusic = webMusicElement.findElements(By.xpath("//*[contains(@data-l,\"t,tracks\")]"+
                "/slot/wm-tracks-list/main/wm-track"));
        List<Music> musicList = new ArrayList<>();

        for (WebElement temp : allMusic) {
            String[] musicFields = temp.getText().split("\\n");
            musicList.add(new Music(musicFields[0], musicFields[1]));
        }

        return musicList;
    }

    public List<Music> addThreeTrendingSong() {
        List<WebElement> allMusic = webMusicElement.findElements(By.xpath("//*[contains(@data-l,\"t,top_tracks_list\")]" +
                "/slot/top-tracks-list/wm-tracks-list/main/wm-track[position() <= 3]"));
        List<Music> musicList = new ArrayList<>();

        Actions action = new Actions(driver);
        for (WebElement temp : allMusic) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            action.moveToElement(temp);
            action.perform();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            temp.findElement(By.xpath("//*[contains(@data-tsid,\"track_add\")]")).click();

            String[] musicFields = temp.getText().split("\n");
            musicList.add(new Music(musicFields[0], musicFields[1].split(" – ")[0]));
        }

        return musicList;
    }

    public void clickMyMusic() {
        webMusicElement.findElement(By.xpath("//*[contains(@data-tsid,\"library\")]")).click();
    }

}
