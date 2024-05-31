package model.audio.type;

import model.Database;
import model.audio.AudioModel;

public class MusicModel extends AudioModel {
    private final String lyric;

    public MusicModel(String audioName, String artistName, String genre, String link, String cover, String lyric) {
        super(audioName, artistName, genre, link, cover);
        this.lyric = lyric;
        Database.getDatabase().getAudios().add(this);
    }

    //Getter
    public String getLyric() {
        return lyric;
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
