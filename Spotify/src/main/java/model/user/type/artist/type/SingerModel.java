package model.user.type.artist.type;

import model.Database;
import model.audio.AlbumModel;
import model.user.type.artist.ArtistModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class SingerModel extends ArtistModel {
    private ArrayList <AlbumModel> albumList;

    public SingerModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio) {
        super(userName, password, name, email, phoneNumber, birthDate, bio);
        albumList = new ArrayList<>();
        albumList.add(new AlbumModel("",name));
        Database.getDatabase().getUserAccounts().add(this);
    }

    public ArrayList<AlbumModel> getAlbumList() {
        return albumList;
    }
    public void setAlbumList(ArrayList<AlbumModel> albumList) {
        this.albumList = albumList;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder(super.toString() + "\tnumber of album: " + albumList.size());
        if(!albumList.isEmpty()){
            for(AlbumModel album : albumList)
                stringBuilder.append("\n\talbum name: " + album.getAlbumName() + "\tID: " + album.getID());
        }
        return String.valueOf(stringBuilder);
    }
}
