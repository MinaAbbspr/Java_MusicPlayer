package model.user.type.artist.type;

import model.Database;
import model.audio.type.PodcastModel;
import model.user.type.artist.ArtistModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class PodcasterModel extends ArtistModel {
    private ArrayList<PodcastModel> podcastList;

    public PodcasterModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio) {
        super(userName, password, name, email, phoneNumber, birthDate, bio);
        podcastList = new ArrayList<>();
        Database.getDatabase().getUserAccounts().add(this);
    }

    public ArrayList<PodcastModel> getPodcastList() {
        return podcastList;
    }
    @Override
    public String toString(){
        return super.toString() + "\tnumber of podcast: " + podcastList.size();
    }
}
