package model.audio.type;

import model.Database;
import model.audio.AudioModel;

public class MusicModel extends AudioModel {
    private String lyric;
    private String albumID;

    public MusicModel(String audioName, String artistName, String genre, String link, String cover, String lyric, String albumID) {
        super(audioName, artistName, genre, link, cover);
        this.lyric = lyric;
        this.albumID = albumID;
        Database.getDatabase().getAudios().add(this);
    }

    //Getter
    public String getLyric() {
        return lyric;
    }
    public String getAlbumID() {
        return albumID;
    }
    //Setter
    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }
    @Override
    public String toString(){
        return super.toString() + "\talbum ID: " + albumID;
    }
}
