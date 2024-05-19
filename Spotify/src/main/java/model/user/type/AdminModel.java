package model.user.type;

import model.Database;
import model.user.UserAccountModel;

import java.time.LocalDate;

public class AdminModel extends UserAccountModel {
    private static AdminModel admin;
    private AdminModel(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate) {
        super(userName, password, name, email, phoneNumber, birthDate);
        Database.getDatabase().getUserAccounts().add(this);
    }

    public static AdminModel getAdmin() {
        if(admin == null) {
            LocalDate birthDate = LocalDate.of(1995,4,23);
            admin = new AdminModel("Admin", "A#45", "Ali Karimi", "Ali.Karimi@gmail.com", "09132581397", birthDate);
        }
        return admin;
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
