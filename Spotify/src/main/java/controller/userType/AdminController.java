package controller.userType;

import model.Database;
import model.Report;
import model.user.UserAccountModel;
import model.user.type.AdminModel;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private AdminModel admin;
    private static AdminController adminController;

    private AdminController() {
        admin = AdminModel.getAdmin();
    }

    public AdminModel getAdmin() {
        return admin;
    }
    public void setAdmin(AdminModel admin) {
        this.admin = admin;
    }
    public static AdminController getAdminController() {
        if(adminController == null)
            adminController = new AdminController();
        return adminController;
    }
    //ورود به پنل
    public void loginAdmin(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())) {
                setAdmin((AdminModel) user);
                break;
            }
    }

    //گزارش
    public List<String> reportInfo(){
        List<String> list = new ArrayList<>();
        for(Report report : Database.getDatabase().getReports())
            list.add(report.toString());

        if(list.isEmpty())
            throw new NullPointerException("There is no report");

        return list;
    }
    //اطلاعات
    public String showInfo(){
        return getAdmin().toString();
    }
}
