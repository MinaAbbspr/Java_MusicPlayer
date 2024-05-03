package model.user.type.listener;

import model.audio.PlaylistModel;
import model.audio.Genre;
import model.user.UserAccountModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListenerModel extends UserAccountModel {
    private double credit;
    private ArrayList<PlaylistModel> playlists;
    private Map<Long, Integer > AudiosPlayed;
    private ArrayList <Long> AudiosLiked;
    private LocalDate subscriptionExpirationDate;
    private ArrayList <Genre> genres;
    private static int maxIndexGenre = 4;

    public ListenerModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate) {
        super(userName, password, name, email, phoneNumber, birthDate);
        playlists = new ArrayList<>();
        AudiosPlayed = new HashMap<>();
        AudiosLiked = new ArrayList<>();
        genres = new ArrayList<>();
        subscriptionExpirationDate = null;
    }

    public double getCredit() {
        return credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }
    public ArrayList<PlaylistModel> getPlaylists() {
        return playlists;
    }
    public void setPlaylists(ArrayList<PlaylistModel> playlists) {
        this.playlists = playlists;
    }
    public LocalDate getSubscriptionExpirationDate() {
        return subscriptionExpirationDate;
    }
    public void setSubscriptionExpirationDate(LocalDate subscriptionExpirationDate) {
        this.subscriptionExpirationDate = subscriptionExpirationDate;
    }
    public Map<Long, Integer> getAudiosPlayed() {
        return AudiosPlayed;
    }
    public void setAudiosPlayed(Map<Long, Integer> audiosPlayed) {
        AudiosPlayed = audiosPlayed;
    }
    public ArrayList<Long> getAudiosLiked() {
        return AudiosLiked;
    }
    public void setAudiosLiked(ArrayList<Long> audiosLiked) {
        AudiosLiked = audiosLiked;
    }
    public static int getMaxIndexGenre() {
        return maxIndexGenre;
    }
    public static void setMaxIndexGenre(int maxIndexGenre) {
        ListenerModel.maxIndexGenre = maxIndexGenre;
    }
    public ArrayList<Genre> getGenres() {
        return genres;
    }
    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }
    @Override
    public String toString(){
        return super.toString() + "\tcredit: " + credit;
    }
}
