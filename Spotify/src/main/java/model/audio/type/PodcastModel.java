package model.audio.type;

import model.Database;
import model.audio.AudioModel;

public class PodcastModel extends AudioModel {
    private final String caption;

    public PodcastModel(String audioName, String artistName, String genre, String link, String cover, String caption) {
        super(audioName, artistName, genre, link, cover);
        this.caption = caption;
        Database.getDatabase().getAudios().add(this);
    }

    //Getter
    public String getCaption() {
        return caption;
    }
    @Override
    public String toString(){
        return super.toString() + "\tcaption: " + caption;
    }
}
