package controller.userType.Listener.type;

import controller.userType.Listener.ListenerController;
import model.Database;
import model.Report;
import model.Subscription;
import model.audio.AudioModel;
import model.audio.PlaylistModel;
import model.exceptions.FreeAccountLimitException;
import model.exceptions.NotEnoughBalanceException;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;
import model.user.type.listener.ListenerModel;
import model.user.type.listener.type.FreeModel;
import model.user.type.listener.type.PremiumModel;

import java.time.LocalDate;

public class FreeController extends ListenerController {
    private FreeModel free;
    private static FreeController freeController;

    private FreeController() {
        super();
    }

    public FreeModel getFree() {
        return free;
    }
    public void setFree(FreeModel free) {
        this.free = free;
    }
    public static FreeController getFreeController() {
        if(freeController == null)
            freeController = new FreeController();
        return freeController;
    }

    @Override
    public void loginListener(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())) {
                ListenerController.getListenerController().setListener((ListenerModel) user);
                setFree((FreeModel) user);
                setListenerController(this);
                break;
            }
    }
    @Override
    public void makePlaylist(String playlistName) throws Exception {
        if(getFree().getPlaylists().size() == FreeModel.getNumberOfPlaylist())
            throw new FreeAccountLimitException("you can not make new playlist");

        for(PlaylistModel playlist : getFree().getPlaylists())
            if(playlistName.equals(playlist.getPlaylistName()))
                throw new Exception("playlist with this name has already been created");

        PlaylistModel playlist = new PlaylistModel(playlistName, getFree().getUserName());
        getFree().getPlaylists().add(playlist);
    }
    @Override
    public String addAudioToPlaylist(String playlistName, long ID) throws FreeAccountLimitException {
        PlaylistModel playlistModel = null;
        for(PlaylistModel playlist : getFree().getPlaylists())
            if(playlistName.equals(playlist.getPlaylistName()))
                playlistModel = playlist;

        if(playlistModel == null)
            throw new NullPointerException("There is no playlist with this name");

        AudioModel audioModel = null;
        for(AudioModel audio : Database.getDatabase().getAudios())
            if(ID == audio.getID())
                audioModel = audio;

        if(audioModel == null)
            throw new NullPointerException("There is no Audio with this ID");

        if(playlistModel.getAudioList().contains(audioModel))
            return "you have already added this Audio to playlist";

        if(playlistModel.getAudioList().size() == FreeModel.getNumberOfMusic())
            throw new FreeAccountLimitException("you can not add new audio to this playlist");

        playlistModel.getAudioList().add(audioModel);
        return "Audio added to playlist successfully";
    }
    @Override
    public  String getPremium (String pack) throws NotEnoughBalanceException {
        if(isPackage(pack)) {
            Subscription subscription = makePackage(pack);

            if(getFree().getCredit()-subscription.getFee() < 0)
                throw new NotEnoughBalanceException();

            getFree().setCredit(getFree().getCredit() - subscription.getFee());
            makePremium(subscription.getDays());
            return "Operation was completed. You have become a premium user.";
        }
        return "your entry is not valid";
    }
    private void makePremium(int days){
        PremiumModel premium = new PremiumModel(getFree().getUserName(),getFree().getPassword(),getFree().getName(),
                getFree().getEmail(),getFree().getPhoneNumber(),getFree().getBirthDate(),days,getFree().getCredit());
        premium.setAudiosLiked(getFree().getAudiosLiked());
        premium.setAudiosPlayed(getFree().getAudiosPlayed());
        premium.setPlaylists(getFree().getPlaylists());
        premium.setGenres(getFree().getGenres());
        LocalDate date = LocalDate.now();
        premium.setSubscriptionExpirationDate(date.plusDays(days));

        for (UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel){
                ArtistModel artist = (ArtistModel) user;
                if(artist.getFollowers().contains(getFree())) {
                    artist.getFollowers().remove(free);
                    artist.getFollowers().add(premium);
                }
            }
        for (Report report : Database.getDatabase().getReports())
            if(report.getListenr().getUserName().equals(getFree().getUserName()))
                report.setListenr(premium);

        Database.getDatabase().getUserAccounts().remove(getFree());
        PremiumController.getPremiumController().loginListener(getFree().getUserName());
    }
}
