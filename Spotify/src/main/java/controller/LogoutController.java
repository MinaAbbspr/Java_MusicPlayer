package controller;

import model.Database;
import model.audio.AudioModel;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogoutController {
    private static LogoutController logoutController;
    private List<AudioModel> sorted;
    private final int maxLength = 12;

    private LogoutController() {}

    public static LogoutController getLogoutController() {
        if(logoutController == null)
            logoutController = new LogoutController();
        return logoutController;
    }

    public void setSorted(){
        Comparator<AudioModel> byLike = Comparator.comparingInt(AudioModel::getNumberOfLikes);
        List<AudioModel> sorted = Database.getDatabase().getAudios().stream().sorted(byLike).toList();
        this.sorted = sorted;
    }

    public List<AudioModel> getSorted() {
        return sorted;
    }
    public int getMaxLength() {
        return maxLength;
    }
}
