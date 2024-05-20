package model.user.type.listener.type;

import model.Database;
import model.user.type.listener.ListenerModel;

import java.time.LocalDate;

public class FreeModel extends ListenerModel {
    private static final int numberOfPlaylist = 3;
    private static final int numberOfMusic = 10;

    public FreeModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate) {
        super(userName, password, name, email, phoneNumber, birthDate);
        super.setCredit(50);
        Database.getDatabase().getUserAccounts().add(this);
    }

    public static int getNumberOfPlaylist() {
        return numberOfPlaylist;
    }
    public static int getNumberOfMusic() {
        return numberOfMusic;
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
