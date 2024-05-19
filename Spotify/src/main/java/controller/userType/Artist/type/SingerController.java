package controller.userType.Artist.type;

import controller.userType.Artist.ArtistController;
import model.Database;
import model.audio.AlbumModel;
import model.audio.AudioModel;
import model.audio.type.MusicModel;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.SingerModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SingerController extends ArtistController {
    private SingerModel singer;
    private static SingerController singerController;

    private SingerController() {
    }

    public SingerModel getSinger() {
        return singer;
    }
    public void setSinger(SingerModel singer) {
        this.singer = singer;
    }
    public static SingerController getSingerController() {
        if(singerController == null)
            singerController = new SingerController();
        return singerController;
    }

    @Override
    public void loginArtist(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())) {
                ArtistController.getArtistController().setArtist((ArtistModel) user);
                setSinger((SingerModel) user);
                setArtistController(this);
                break;
            }
    }
    @Override
    public void signupArtist(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio){
        SingerModel singerModel = new SingerModel(userName, password, name, email, phoneNumber, birthDate, bio);
        setSinger(singerModel);
        setArtist(singerModel);
    }
    @Override
    //پلی شدن آثار
    public int showNumberOfPlayed(){
        int counter = 0;
        for(AlbumModel album : getSinger().getAlbumList())
            for (AudioModel audio : album.getMusicList())
                counter += audio.getNumberOfPlays();

        return counter;
    }
    @Override
    //محاسبه درآمد
    public String calculateEarnings(){
        getSinger().setIncome( showNumberOfPlayed() * 0.4);
        return  "your income is "+ getSinger().getIncome() + " dollars";
    }
    @Override
    //آلبوم جدید
    public String newAlbum(String name){
        AlbumModel album = new AlbumModel(name, getSinger().getName());
        getSinger().getAlbumList().add(album);
        return "new Album created successfully";
    }
    @Override
    //انتشار آهنگ
    public String publishing(String audioName, String genre, String lyric, String link, String cover){
        MusicModel music = new MusicModel(audioName,getSinger().getUserName(),genre,link,cover,lyric,SingerController.getSingerController().getSinger().getAlbumList().getFirst().getID());
        SingerController.getSingerController().getSinger().getAlbumList().getFirst().getMusicList().add(music);
        return "music published successfully";
    }
    @Override
    public List<AudioModel> getAudios(){
        List<AudioModel> list = new ArrayList<>();
        for(AlbumModel albumModel : getSinger().getAlbumList())
            for(MusicModel music : albumModel.getMusicList())
                list.add(music);

        return list;
    }
}
