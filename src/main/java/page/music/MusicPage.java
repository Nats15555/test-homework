package page.music;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.music.Music;

public class MusicPage {
    private final MusicBlock musicBlock;

    public MusicPage(WebDriver driver) {
        this.musicBlock = new MusicBlock(driver);
    }

    public List<Music> addTreeSongs() {
        return musicBlock.addThreeTrendingSong();
    }

    public boolean checkCountSongs(List<Music> addMusicList, int count) {
        musicBlock.clickMyMusic();
        List<Music> myMusicList = musicBlock.getMusic();
        return (int) addMusicList.stream().filter(myMusicList::contains).count() == count;
    }
}
