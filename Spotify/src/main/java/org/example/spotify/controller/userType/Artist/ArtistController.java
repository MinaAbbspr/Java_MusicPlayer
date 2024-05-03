package controller.userType.Artist;

import controller.UserAccountController;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;

import java.time.LocalDate;
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
    public StringBuilder showFollowers(){
        StringBuilder stringBuilder = new StringBuilder();
        for (UserAccountModel user : getArtist().getFollowers())
            stringBuilder.append("listener username: ").append(user.getUserName()).append("\n");

        if(stringBuilder.isEmpty())
            stringBuilder.append("you have no followers");

        return stringBuilder;
    }
    //پلی شدن آثار
    public int showNumberOfPlayed(){return 0;}
    //محاسبه درآمد
    public String calculateEarnings(){return "Polymorphism method";}
    public String showInfo(){
        return getArtist().toString();
    }
    public String newAlbum(String name){ return "Polymorphism method";}
    public String publishing(String audioName, String genre, String lyric, String link, String cover, String ID){ return "Polymorphism method";}
}
