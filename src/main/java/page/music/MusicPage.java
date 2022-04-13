package page.music;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.music.Music;

public class MusicPage {
    private final MusicBlock musicBlock;

    public MusicPage(WebDriver driver) {
        this.musicBlock = new MusicBlock(driver) ;
    }

    public boolean addTreeSongsAndCheck(){
        List<Music> musicList = musicBlock.addThreeTrendingSong();
        musicBlock.clickMyMusic();
        List<Music> myMusicList = musicBlock.getMusic();
        return (int) musicList.stream().filter(myMusicList::contains).count() == 3;
    }
}
