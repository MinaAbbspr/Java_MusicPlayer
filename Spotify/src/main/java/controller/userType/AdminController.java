package controller.userType;

import model.Database;
import model.Report;
import model.audio.AudioModel;
import model.user.UserAccountModel;
import model.user.type.AdminModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;

import java.util.Comparator;
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

    //محبوب ترین فایل ها
    public StringBuilder showFavoriteAudios(){
        Comparator <AudioModel> byLike = Comparator.comparingInt(AudioModel::getNumberOfLikes);
        List <AudioModel> sorted = Database.getDatabase().getAudios().stream().sorted(byLike).toList();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i= sorted.size()-1; i>=0; i--)
            stringBuilder.append(sorted.get(i).getAudioName() + "\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("there is no Audio");
        return stringBuilder;
    }
    //مشاهده اطلاعات
    public StringBuilder artistsInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel)
                stringBuilder.append("Artist username: " + user.getUserName() + "\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("there is no Artist");

        return stringBuilder;
    }
    public String artistInfo(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if((user instanceof SingerModel || user instanceof PodcasterModel) && username.equals(user.getUserName()))
                return user.toString();
        throw new NullPointerException("There is no artist with this username");
    }
    ///////////////////
    public StringBuilder audiosInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for(AudioModel audio : Database.getDatabase().getAudios())
            stringBuilder.append(++counter + ". name: " + audio.getAudioName() + "\tID: " + audio.getID() + "\n");

        if (stringBuilder.isEmpty())
            throw new NullPointerException("there is no Audio");
        return stringBuilder;
    }
    public String audioInfo(long ID){
        for (AudioModel audio : Database.getDatabase().getAudios())
            if(ID == audio.getID())
                return audio.toString();
        throw new NullPointerException("There is no audio with this ID");
    }
    //گزارش
    public StringBuilder reportInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Report report : Database.getDatabase().getReports())
            stringBuilder.append(report.toString() + "\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("There is no report");

        return stringBuilder;
    }
    //اطلاعات
    public String showInfo(){
        return getAdmin().toString();
    }
}
