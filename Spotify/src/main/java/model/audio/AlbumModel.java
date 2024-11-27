package model.audio;

import model.audio.type.MusicModel;

import java.util.ArrayList;

public class AlbumModel {
    private static int code = 1;
    private final String ID;
    private String albumName;
    private String singerName;
    private ArrayList<MusicModel> musicList;

    public AlbumModel(String albumName, String singerName) {
        this.albumName = albumName;
        this.singerName = singerName;
        musicList = new ArrayList <>();
        ID = getCode();
    }
    //Getter
    private String getCode() {
        StringBuilder stringBuilder = new StringBuilder(this.singerName);
        stringBuilder.append(code++);
        return String.valueOf(stringBuilder);
    }
    public String getID() {
        return ID;
    }
    public String getAlbumName() {
        return albumName;
    }
    public String getSingerName() {
        return singerName;
    }
    public ArrayList<MusicModel> getMusicList() {
        return musicList;
    }
    //Setter
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
    public void setMusicList(ArrayList<MusicModel> musicList) {
        this.musicList = musicList;
    }
    @Override
    public String toString(){
        return "album name: " + albumName + "\tsinger name: " + singerName + "\tID: " + ID + "\tnumber of music: " + musicList.size();
    }
}
