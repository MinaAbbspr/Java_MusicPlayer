package model;
import model.user.UserAccountModel;
import model.audio.AudioModel;

import java.util.ArrayList;

public class Database {
    private static Database database;
    private ArrayList <UserAccountModel> userAccounts;
    private ArrayList <AudioModel> audios;
    private ArrayList<Report> reports;

    private Database() {
        userAccounts = new ArrayList<>();
        audios = new ArrayList<>();
        reports = new ArrayList<>();
    }

    public static Database getDatabase() {
        if(database == null)
            database = new Database();
        return database;
    }

    public ArrayList<UserAccountModel> getUserAccounts() {
        return userAccounts;
    }
    public void setUserAccounts(ArrayList<UserAccountModel> userAccounts) {
        this.userAccounts = userAccounts;
    }
    public ArrayList<AudioModel> getAudios() {
        return audios;
    }
    public void setAudios(ArrayList<AudioModel> audios) {
        this.audios = audios;
    }
    public ArrayList<Report> getReports() {
        return reports;
    }
    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
}
