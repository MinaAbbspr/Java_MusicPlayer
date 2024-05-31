package controller.user.userType.Artist;

import controller.user.UserAccountController;
import model.audio.AudioModel;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtistController extends UserAccountController {
    private ArtistModel artist;
    private static ArtistController artistController;

    protected ArtistController() {
    }

    public static ArtistController getArtistController() {
        if(artistController == null)
            artistController = new ArtistController();
        return artistController;
    }

    public static void setArtistController(ArtistController artistController) {
        ArtistController.artistController = artistController;
    }

    public ArtistModel getArtist() {
        return artist;
    }
    public void setArtist(ArtistModel artist) {
        this.artist = artist;
    }
    //ثبت نام کاربر
    public void signupArtist(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio){}
    //ورود به حساب کاربری
    public void loginArtist(String username){}
    //مشاهده دنبال کننده ها
    public List<String> showFollowers(){
        List<String> list = new ArrayList<>();
        for (UserAccountModel user : getArtist().getFollowers())
            list.add(user.getUserName());

        if(list.isEmpty())
            throw new NullPointerException("you have no followers!");

        return list;
    }
    public List<AudioModel> getAudios(){return null;}
    //پلی شدن آثار
    public int showNumberOfPlayed(){return 0;}
    //محاسبه درآمد
    public String calculateEarnings(){return "Polymorphism method";}
    public String publishing(String audioName, String genre, String lyric, String link, String cover){ return "Polymorphism method";}
}
