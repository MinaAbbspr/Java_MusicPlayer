package model.user.type.listener.type;

import model.Database;
import model.user.type.listener.ListenerModel;

import java.time.LocalDate;

public class PremiumModel extends ListenerModel {
    private int numberOfDaysLeft;

    public PremiumModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, int numberOfDaysLeft, double credit) {
        super(userName, password, name, email, phoneNumber, birthDate);
        this.numberOfDaysLeft = numberOfDaysLeft;
        super.setCredit(credit);
        Database.getDatabase().getUserAccounts().add(this);
    }

    public int getNumberOfDaysLeft() {
        return numberOfDaysLeft;
    }
    public void setNumberOfDaysLeft(int numberOfDaysLeft) {
        this.numberOfDaysLeft = numberOfDaysLeft;
    }
    @Override
    public String toString(){
        return super.toString() + "\tnumber of days left: " + numberOfDaysLeft;
    }
}
