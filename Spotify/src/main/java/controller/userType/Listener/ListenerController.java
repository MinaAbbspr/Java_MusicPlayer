package controller.userType.Listener;

import controller.UserAccountController;
import model.Database;
import model.Report;
import model.Subscription;
import model.audio.AlbumModel;
import model.audio.AudioModel;
import model.audio.Genre;
import model.audio.PlaylistModel;
import model.audio.type.MusicModel;
import model.audio.type.PodcastModel;
import model.exceptions.FreeAccountLimitException;
import model.exceptions.NotEnoughBalanceException;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;
import model.user.type.listener.ListenerModel;
import model.user.type.listener.type.FreeModel;

import java.time.LocalDate;
import java.util.*;

public class ListenerController extends UserAccountController {
    private ListenerModel listener;
    private static ListenerController listenerController;

    protected ListenerController() {
    }

    public static ListenerController getListenerController() {
        if(listenerController == null)
            listenerController = new ListenerController();
        return listenerController;
    }

    public static void setListenerController(ListenerController listenerController) {
        ListenerController.listenerController = listenerController;
    }

    public ListenerModel getListener() {
        return listener;
    }
    public void setListener(ListenerModel listener) {
        this.listener = listener;
    }
    //ثبت نام کاربر
    public void signupListener(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate){
        FreeModel freeModel = new FreeModel(userName, password, name, email, phoneNumber, birthDate);
        setListener(freeModel);
    }
    public void addGenre(ArrayList<String> genres){
        for(String genre : genres) {
            Genre genre1 = Genre.valueOf(genre);
            getListener().getGenres().add(genre1);
        }
    }
    //ورود به حساب کاربری
    public void loginListener(String username){}

    //ایجاد پلی لیست و افزودن فایل صوتی
    public void makePlaylist(String playlistName) throws Exception {}
    public String addAudioToPlaylist(String playlistName, AudioModel audioModel) throws Exception {return "Polymorphism method";}

    //پخش فایل صوتی
    public void playAudio(long ID){
        for(AudioModel audio : Database.getDatabase().getAudios())
            if(ID == audio.getID()) {
                if(getListener().getAudiosPlayed().containsKey(ID)){
                    int value = getListener().getAudiosPlayed().get(ID) + 1;
                    getListener().getAudiosPlayed().replace(ID,value);
                }
                else
                    getListener().getAudiosPlayed().put(ID,1);
            }
    }

    //مشاهده following
    public List<ArtistModel> showFollowings(){
        List<ArtistModel> artists = new ArrayList<>();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel) {
                ArtistModel artist = (ArtistModel) user;
                if(artist.getFollowers().contains(getListener())){
                    artists.add(artist);
                }
            }
        return artists;
    }

    //گزارش آرتیست
    public void reportArtist(ArtistModel artist, String explanation){
        Report report = new Report(getListener(),artist,explanation);
    }

    //دنبال کردن آرتیست
    public String followArtist(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())){
                if(user instanceof SingerModel || user instanceof PodcasterModel){
                    ArtistModel artist = (ArtistModel) user;
                    artist.getFollowers().add(getListener());
                    return "operation was completed";
                }
                else
                    return "username is not for an artist";
            }
        return "artist was not found with this username";
    }

    //انتخاب پلی لیست
    public PlaylistModel selectPlaylist(String playlistName){
        for(PlaylistModel playlist : getListener().getPlaylists())
            if(playlistName.equals(playlist.getPlaylistName())) {
                return playlist;
            }
        return null;
    }

    //پیشنهاد فایل صوتی
    public List<AudioModel> getSuggestion(){
        Map<AudioModel , Integer> suggest = new HashMap<>();
        for(AudioModel audio : Database.getDatabase().getAudios()) {
            //play 1 score
            suggest.put(audio, getListener().getAudiosPlayed().getOrDefault(audio.getID(), 0));
            //like 2 score
            if(getListener().getAudiosLiked().contains(audio.getID()))
                suggest.replace(audio, suggest.get(audio)+2);
            //genre 3 score
            if(getListener().getGenres().contains(audio.getGenre()))
                suggest.replace(audio, suggest.get(audio)+3);
            //artist following 1 score
            for(UserAccountModel user : Database.getDatabase().getUserAccounts())
                if(user instanceof SingerModel || user instanceof PodcasterModel){
                    ArtistModel artist = (ArtistModel) user;
                    if(artist.getUserName().equals(audio.getArtistName())){
                        if(artist.getFollowers().contains(getListener()))
                            suggest.replace(audio, suggest.get(audio)+1);
                        break;
                    }
                }
        }
        Map.Entry<AudioModel,Integer>[] sorted = sortMapByValue(suggest);
        ArrayList<AudioModel> answer = new ArrayList<>();
        for(Map.Entry<AudioModel,Integer> s : sorted){
            answer.add(s.getKey());
        }
        return answer;
    }
    private Map.Entry<AudioModel,Integer>[] sortMapByValue(Map<AudioModel , Integer> suggest) {
        Map.Entry<AudioModel, Integer>[] sort = suggest.entrySet().toArray(new Map.Entry[suggest.size()]);
        for (int i = 0; i < sort.length - 1; i++)
            for (int j = i; j < sort.length; j++)
                if (sort[i].getValue() < sort[j].getValue()) {
                    Map.Entry<AudioModel, Integer> tmp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = tmp;
                }

        return sort;
    }


    //خرید یا تمدید اشتراک
    public ListenerModel getPremium (Subscription subscription) throws NotEnoughBalanceException {return null;}
}
