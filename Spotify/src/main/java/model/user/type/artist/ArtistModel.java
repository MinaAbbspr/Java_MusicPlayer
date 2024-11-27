package model.user.type.artist;

import model.user.UserAccountModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArtistModel extends UserAccountModel {
    private double income;
    private ArrayList <UserAccountModel> followers;
    private String bio;

    public ArtistModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio) {
        super(userName, password, name, email, phoneNumber, birthDate);
        this.bio = bio;
        income = 0;
        followers = new ArrayList<>();
    }

    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    public ArrayList<UserAccountModel> getFollowers() {
        return followers;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    @Override
    public String toString(){
        return super.toString() + "\tincome: " + income + "\tnumber of follower: " + followers.size() +
                "\n\tbio: " + bio ;
    }
}
