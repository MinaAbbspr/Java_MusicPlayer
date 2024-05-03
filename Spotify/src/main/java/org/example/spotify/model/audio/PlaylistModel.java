package model.audio;

import java.util.ArrayList;
public class PlaylistModel {
    private static int code = 0;
    private final int ID;
    private String playlistName;
    private String user_Name;
    private ArrayList <AudioModel> audioList;

    public PlaylistModel(String playlistName, String user_Name) {
        this.playlistName = playlistName;
        this.user_Name = user_Name;
        ID = getCode();
        audioList = new ArrayList<>();
    }
    //Getter
    private int getCode(){
        code++;
        return code;
    }
    public int getID() {
        return ID;
    }
    public String getPlaylistName() {
        return playlistName;
    }
    public String getUser_Name() {
        return user_Name;
    }
    public ArrayList<AudioModel> getAudioList() {
        return audioList;
    }
    //Setter
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
    public void setUser_Name(String userName) {
        this.user_Name = userName;
    }
    public void setAudioList(ArrayList<AudioModel> audioList) {
        this.audioList = audioList;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("playlist name: " + playlistName + "\tuser name: " + user_Name +
                "\tID: " + ID);
        if(!audioList.isEmpty()) {
            stringBuilder.append( "\naudio list: ");
            for (AudioModel audio : audioList)
                stringBuilder.append(audio.getAudioName() + "   ");
        }
        return String.valueOf(stringBuilder);
    }
}
