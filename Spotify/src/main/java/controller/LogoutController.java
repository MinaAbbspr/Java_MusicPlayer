package controller;

import model.Database;
import model.audio.AlbumModel;
import model.audio.AudioModel;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;

import java.util.*;

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

    public List<ArtistModel> artistsInfo(){
        List<ArtistModel> artists = new ArrayList<>();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel)
                artists.add((ArtistModel) user);

        return artists;
    }

    public List<AudioModel> artistList(ArtistModel artistModel){
        List<AudioModel> audios = new ArrayList<>();
        if(artistModel instanceof SingerModel){
            for (AlbumModel album : ((SingerModel) artistModel).getAlbumList()){
                for(AudioModel audio : album.getMusicList())
                    audios.add(audio);
            }
        }
        else {
            for(AudioModel audio : ((PodcasterModel)artistModel).getPodcastList()){
                audios.add(audio);
            }
        }
        return audios;
    }

    public List<AudioModel> getSorted() {
        return sorted;
    }
    public int getMaxLength() {
        return maxLength;
    }
}
