package controller.user.userType;

import model.Database;
import model.Report;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private static AdminController adminController;

    public static AdminController getAdminController() {
        if(adminController == null)
            adminController = new AdminController();
        return adminController;
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
}
