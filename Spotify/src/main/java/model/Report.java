package model;

import model.user.type.artist.ArtistModel;
import model.user.type.listener.ListenerModel;

public class Report {
    private ListenerModel listener;
    private ArtistModel artist;
    private final String explanation;

    public Report(ListenerModel listener, ArtistModel artist, String explanation) {
        this.listener = listener;
        this.artist = artist;
        this.explanation = explanation;
        Database.getDatabase().getReports().add(this);
    }

    public void setListener(ListenerModel listener) {
        this.listener = listener;
    }
    public ListenerModel getListener() {
        return listener;
    }
    public ArtistModel getArtist() {
        return artist;
    }
    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }

    @Override
    public String toString(){
        return "listener's username: " + listener.getUserName() + "\nartist's username: " + artist.getUserName() + "\nexplanation: " + explanation;
    }
}
