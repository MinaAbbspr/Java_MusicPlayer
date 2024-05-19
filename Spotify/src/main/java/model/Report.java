package model;

import model.user.type.artist.ArtistModel;
import model.user.type.listener.ListenerModel;

public class Report {
    private ListenerModel listenr;
    private ArtistModel artist;
    private String explanation;

    public Report(ListenerModel listenr, ArtistModel artist, String explanation) {
        this.listenr = listenr;
        this.artist = artist;
        this.explanation = explanation;
        Database.getDatabase().getReports().add(this);
    }

    public void setListenr(ListenerModel listenr) {
        this.listenr = listenr;
    }
    public ListenerModel getListenr() {
        return listenr;
    }
    public ArtistModel getArtist() {
        return artist;
    }
    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }
    public String getExplanation() {
        return explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    @Override
    public String toString(){
        return "listener's username: " + listenr.getUserName() + "\nartist's username: " + artist.getUserName() + "\nexplanation: " + explanation;
    }
}
