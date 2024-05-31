package controller;

import model.Database;
import model.audio.AudioModel;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;

import java.util.*;

public class StableController {
    private static StableController stableController;

    private StableController() {}

    public static StableController getStableController() {
        if(stableController == null)
            stableController = new StableController();
        return stableController;
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
        if(artistModel instanceof SingerModel singerModel){
            audios.addAll(singerModel.getMusicList());
        }
        else {
            audios.addAll(((PodcasterModel) artistModel).getPodcastList());
        }
        return audios;
    }

}
