package model;

import model.audio.AudioModel;
import model.user.UserAccountModel;

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
    public ArrayList<AudioModel> getAudios() {
        return audios;
    }
    public ArrayList<Report> getReports() {
        return reports;
    }
}
