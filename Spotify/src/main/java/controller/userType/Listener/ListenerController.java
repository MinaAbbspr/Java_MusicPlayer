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
    public String addAudioToPlaylist(String playlistName, long ID) throws FreeAccountLimitException {return "Polymorphism method";}

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

    //جست و جو
    public StringBuilder search(String name){
        List <AudioModel> result1 = Database.getDatabase().getAudios()
                .stream().filter(n -> n.getArtistName().equals(name)).toList();
        List <AudioModel> result2 = Database.getDatabase().getAudios()
                .stream().filter(n -> n.getAudioName().equals(name)).toList();

        StringBuilder stringBuilder = new StringBuilder();
        for(AudioModel audio : result1)
            stringBuilder.append("audio name: " + audio.getAudioName() + "\tID: " + audio.getID()).append("\n");

        for (AudioModel audio : result2)
            stringBuilder.append("audio name: " + audio.getAudioName() + "\tID: " + audio.getID()).append("\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("Nothing found!");

        return stringBuilder;
    }

    //مرتب سازی
    public StringBuilder sort(){
        List <AudioModel> sorted = Database.getDatabase().getAudios();
        Arrays.sort(sorted.toArray());

        StringBuilder stringBuilder = new StringBuilder();
        for(int i= sorted.size()-1; i>=0; i--)
            stringBuilder.append("Audio name: " + sorted.get(i).getAudioName() + "\tID: " + sorted.get(i).getID() + "\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("there is no audio");

        return stringBuilder;
    }

    //فیلتر
    public StringBuilder artistFilter (String name){
        List <AudioModel> filtered = Database.getDatabase().getAudios()
                .stream().filter(a -> a.getArtistName().equals(name)).toList();

        StringBuilder stringBuilder = new StringBuilder();
        for(AudioModel audio : filtered)
            stringBuilder.append("name: " + audio.getAudioName() + "\tID: " + audio.getID() + "\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("this artist has NO audio");
        return stringBuilder;
    }
    public StringBuilder genreFilter(String filter){
        StringBuilder stringBuilder = new StringBuilder();
        List <AudioModel> filtered = Database.getDatabase().getAudios()
                .stream().filter(a -> a.getGenre().toString().equals(filter)).toList();

        for(AudioModel audio : filtered)
            stringBuilder.append("name: " + audio.getAudioName() + "\tID: " + audio.getID() + "\n");

        if(stringBuilder.isEmpty())
            throw new NullPointerException("this Genre has NO audio");

        return stringBuilder;
    }
    public StringBuilder dateFilter(LocalDate localDate){
        List <AudioModel> filtered = Database.getDatabase().getAudios()
                .stream().filter(a -> a.getDateOfRelease().equals(localDate)).toList();

        StringBuilder stringBuilder = new StringBuilder();
        for(AudioModel audio : filtered)
            stringBuilder.append("name: " + audio.getAudioName() + "\tID: " + audio.getID() + "\n");

        if(stringBuilder.isEmpty())
            stringBuilder.append(localDate + " has NO audio\n");
        return stringBuilder;
    }
    public StringBuilder twoDateFilter(LocalDate firstDate , LocalDate secondDate){
        StringBuilder stringBuilder = new StringBuilder();
        if(!firstDate.isBefore(secondDate)) {
            stringBuilder.append("The first date must be before the second date");
            return stringBuilder;
        }

        int day = 0;
        while (!secondDate.isBefore(firstDate.plusDays(day))){
            stringBuilder.append(dateFilter(firstDate.plusDays(day)));
            day ++;
        }
        return stringBuilder;
    }

    //مشاهده following
    public StringBuilder showFollowings(){
        StringBuilder stringBuilder = new StringBuilder();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel) {
                ArtistModel artist = (ArtistModel) user;
                if(artist.getFollowers().contains(getListener())){
                    stringBuilder.append("artist username: " + artist.getUserName()+"\n");
                }
            }
        if(stringBuilder.isEmpty())
            stringBuilder.append("you do not have any following");
        return stringBuilder;
    }

    //گزارش آرتیست
    public String reportArtist(String artistUsername, String explanation){
        ArtistModel artist = null;
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(artistUsername.equals(user.getUserName())) {
                if(user instanceof SingerModel || user instanceof PodcasterModel)
                    artist = (ArtistModel) user;
                else
                    return "username is not for an artist";
            }
        if(artist == null)
            return "artist was not found with this username";
        Report report = new Report(getListener(),artist,explanation);
        return "making Report Completed Successfully";
    }

    //مشاهده لیست آرتیست ها
    public StringBuilder showArtists(){
        StringBuilder stringBuilder = new StringBuilder();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts()){
            if(user instanceof SingerModel singer) {
                stringBuilder.append("singer username: " + singer.getUserName() + "\n");
            }
            else if(user instanceof PodcasterModel podcaster){
                stringBuilder.append("podcaster username: " + podcaster.getUserName() + "\n");
            }
        }
        if(stringBuilder.isEmpty())
            stringBuilder.append("There is no artist");
        return stringBuilder;
    }
    public StringBuilder showArtistInfo(String username){
        StringBuilder stringBuilder = new StringBuilder();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts()){
            if(user instanceof SingerModel singer && username.equals(user.getUserName())) {
                stringBuilder.append(singer + "\n");
                for(AlbumModel album : singer.getAlbumList()){
                    stringBuilder.append("album:" + album.getAlbumName()+"\n");
                    for(MusicModel music : album.getMusicList())
                        stringBuilder.append("\tmusic :" + music.getAudioName()+"\n");
                }
                break;
            }
            else if(user instanceof PodcasterModel podcaster && username.equals(user.getUserName())){
                stringBuilder.append(podcaster + "\n");
                for(PodcastModel podcast : podcaster.getPodcastList())
                    stringBuilder.append("podcast: " + podcast.getAudioName() + "\n");
                break;
            }
        }
        if(stringBuilder.isEmpty())
            stringBuilder.append("There is no artist with this username");
        return stringBuilder;
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

    //مشاهده پلی لیست
    public StringBuilder showPlaylists(){
        StringBuilder stringBuilder = new StringBuilder();
        for(PlaylistModel playlist : getListener().getPlaylists())
            stringBuilder.append("playlist name: " + playlist.getPlaylistName() + "\n");
        if(stringBuilder.isEmpty())
            stringBuilder.append("There is no playlist");
        return stringBuilder;
    }
    public StringBuilder selectPlaylist(String playlistName){
        StringBuilder stringBuilder = new StringBuilder();
        for(PlaylistModel playlist : getListener().getPlaylists())
            if(playlistName.equals(playlist.getPlaylistName())) {
                 stringBuilder.append(playlist + "\n");

                 if(playlist.getPlaylistName().isEmpty())
                     stringBuilder.append("playlist has no audio");
                 else {
                     stringBuilder.append("Audios:");
                     for (AudioModel audio : playlist.getAudioList())
                         stringBuilder.append("\n\tname: " + audio.getAudioName() + "\tID: " + audio.getID());
                 }
                 break;
            }

        if(stringBuilder.isEmpty())
            stringBuilder.append("There is no playlist with this name");

        return stringBuilder;
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
    private Map.Entry<AudioModel,Integer>[] sortMapByValue(Map<AudioModel , Integer> suggest){
        Map.Entry<AudioModel,Integer>[] sort = suggest.entrySet().toArray(new Map.Entry[suggest.size()]);
        for(int i=0; i<sort.length-1; i++)
            for (int j = i; j<sort.length; j++)
                if(sort[i].getValue() < sort[j].getValue()){
                    Map.Entry<AudioModel, Integer> tmp = sort[i];
                    sort[i] = sort [j];
                    sort[j] = tmp;
                }

        return sort;
    }

    //اطلاعات کاربر
    public String showInfo(){
        return getListener().toString();
    }

    //افزایش اعتبار
    public String increaseCredit(double amount){
        amount += getListener().getCredit();
        getListener().setCredit(amount);
        return "operation was completed";
    }
    //خرید یا تمدید اشتراک
    public String getPremium (String pack) throws NotEnoughBalanceException { return  "Polymorphism method";}
    public boolean isPackage(String pack){
        return pack.equals("30") || pack.equals("60") || pack.equals("180");
    }
    public Subscription makePackage(String pack){
        if(pack.equals("30"))
            return Subscription.Package30Days;
        if(pack.equals("60"))
            return Subscription.Package60Days;
        return Subscription.Package180Days;
    }
}
