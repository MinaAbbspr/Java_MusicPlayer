package controller.user.userType.Listener.type;

import controller.user.userType.Listener.ListenerController;
import model.Database;
import model.Report;
import model.Subscription;
import model.audio.AudioModel;
import model.audio.PlaylistModel;
import exceptions.NotEnoughBalanceException;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;
import model.user.type.listener.ListenerModel;
import model.user.type.listener.type.FreeModel;
import model.user.type.listener.type.PremiumModel;
import view.View;

import java.util.Timer;
import java.util.TimerTask;

public class PremiumController extends ListenerController {
    private PremiumModel premium;
    private static PremiumController premiumController;

    private PremiumController() {
        super();
        reductionOfSubscriptionDays();
    }

    public PremiumModel getPremium() {
        return premium;
    }
    public void setPremium(PremiumModel premium) {
        this.premium = premium;
    }
    public static PremiumController getPremiumController() {
        if(premiumController == null)
            premiumController = new PremiumController();
        return premiumController;
    }

    @Override
    public void loginListener(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())) {
                setPremium((PremiumModel) user);
                ListenerController.getListenerController().setListener(premium);
                setListenerController(this);
                break;
            }
    }
    @Override
    public void makePlaylist(String playlistName) throws Exception {
        for(PlaylistModel playlist : getPremium().getPlaylists())
            if(playlistName.equals(playlist.getPlaylistName()))
                throw new Exception("playlist with this name has already been created");

        PlaylistModel playlist = new PlaylistModel(playlistName);
        getPremium().getPlaylists().add(playlist);
    }
    @Override
    public String addAudioToPlaylist(String playlistName, AudioModel audioModel) throws Exception {
        PlaylistModel playlistModel = null;
        for(PlaylistModel playlist : getPremium().getPlaylists())
            if(playlistName.equals(playlist.getPlaylistName()))
                playlistModel = playlist;

        if(playlistModel.getAudioList().contains(audioModel))
            throw new Exception("you have already added this Audio to playlist");

        playlistModel.getAudioList().add(audioModel);
        return "Audio added to playlist successfully";
    }
    @Override
    public  ListenerModel getPremium (Subscription subscription) throws NotEnoughBalanceException {
        if(getPremium().getCredit()-subscription.getFee() < 0)
            throw new NotEnoughBalanceException();

        getPremium().setCredit(getPremium().getCredit() - subscription.getFee());
        getPremium().setSubscriptionExpirationDate(getPremium().getSubscriptionExpirationDate().plusDays(subscription.getDays()));
        getPremium().setNumberOfDaysLeft(getPremium().getNumberOfDaysLeft() + subscription.getDays());
        return getPremium();
    }

    public void reductionOfSubscriptionDays(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                getPremium().setNumberOfDaysLeft(getPremium().getNumberOfDaysLeft() - 1);
                if(getPremium().getNumberOfDaysLeft() == 0)
                    makeFree();
            }
        };
        Timer timer = new Timer("timer");
        long delay = 1000L * 60L * 60L * 24L;
        long period = 1000L * 60L * 60L * 24L;
        timer.schedule(task, delay, period);

    }
    private void makeFree(){
        FreeModel free = new FreeModel(getPremium().getUserName(),getPremium().getPassword(),getPremium().getName(),
                getPremium().getEmail(),getPremium().getPhoneNumber(),getPremium().getBirthDate());
        free.setCredit(getPremium().getCredit());
        free.setAudiosLiked(getPremium().getAudiosLiked());
        free.setAudiosPlayed(getPremium().getAudiosPlayed());
        free.setGenres(getPremium().getGenres());
        free.setSubscriptionExpirationDate(null);
        //حذف پلی لیست اضافه
        while (getPremium().getPlaylists().size() > FreeModel.getNumberOfPlaylist() ){
            getPremium().getPlaylists().removeLast();
        }
        free.setPlaylists(getPremium().getPlaylists());
        //حذف فایل اضافه
        for(int i=0; i<free.getPlaylists().size(); i++){
            while (free.getPlaylists().get(i).getAudioList().size() > FreeModel.getNumberOfMusic())
                free.getPlaylists().get(i).getAudioList().removeLast();
        }

        for (UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel){
                ArtistModel artist = (ArtistModel) user;
                if(artist.getFollowers().contains(getPremium())) {
                    artist.getFollowers().remove(premium);
                    artist.getFollowers().add(free);
                }
            }
        for (Report report : Database.getDatabase().getReports())
            if(report.getListener().getUserName().equals(getPremium().getUserName()))
                report.setListener(free);

        Database.getDatabase().getUserAccounts().remove(getPremium());
        FreeController.getFreeController().loginListener(getPremium().getUserName());
        View.getView().setUserAccount(free);
    }
}
