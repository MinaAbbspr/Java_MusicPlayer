package model.user.type.artist.type;

import model.Database;
import model.audio.type.MusicModel;
import model.user.type.artist.ArtistModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class SingerModel extends ArtistModel {
    private final ArrayList <MusicModel> musicList;

    public SingerModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio) {
        super(userName, password, name, email, phoneNumber, birthDate, bio);
        musicList = new ArrayList<>();
        Database.getDatabase().getUserAccounts().add(this);
    }

    public ArrayList<MusicModel> getMusicList() {
        return musicList;
    }
}
