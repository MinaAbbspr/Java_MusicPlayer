package view;

import controller.userType.Artist.ArtistController;
import controller.userType.Artist.type.SingerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.audio.type.MusicModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        View.getView().setStage(stage);
        View.getView().showMainPage("home.fxml");
    }

    public static void main(String[] args) {
        SingerModel singerModel1 = new SingerModel("Adele", "Ad88", "Adele Adkins", "Adele.Adkins@gmail.com", "09945632105", LocalDate.of(1988,5,5) ,"adele.com");
        SingerModel singerModel2 = new SingerModel("Ali66", "12345fGGG@", "Ali Ahmadi", "hsnn56@gmail.com", "09911039121", LocalDate.of(2004,10,12) ,"here");
        SingerModel singerModel3 = new SingerModel("Reza66", "1224fGGG@", "Reza Ahmadi", "hsn56@exmail.com", "09910039122", LocalDate.of(2004,9,13) ,"hello");

        PodcasterModel podcasterModel = new PodcasterModel("sarahBrown", "S@r@h1234", "Sarah Brown", "sarah.brown@example.com", "09456789012", LocalDate.of(1992,3,20),"Coffee lover ☕");

        SingerController.getSingerController().loginArtist("Adele");
        SingerController.getSingerController().newAlbum("25");
        SingerController.getSingerController().publishing("Hello", "Jazz", "Hello, it's me\n" +
                "I was wondering if after all these years you'd like to meet\nTo go over everything\n" +
                "They say that time's supposed to heal ya, but I ain't done much healing",
                "https://ts1.tarafdari.com/contents/user360611/content-sound/adele_-_hello_mytextmusic.com_.mp3",
                HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().publishing("When we were young", "Pop",
                "Everybody loves the things you doFrom the way you talk\nTo the way you move\n" +
                        "Everybody here is watching you\n'Cause you feel like home\nYou're like a dream come true\n" +
                        "But if by chance you're here alone\nCan I have a moment?\nBefore I go?\n'Cause I've been by myself all night long\n" +
                        "Hoping you're someone I used to know\nYou look like a movie\nYou sound like a song" ,
                "https://ts15.tarafdari.com/contents/user687779/content-sound/when_we_were_young.mp3",HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().publishing("Send My Love", "Jazz",
                "This was all you, none of it me\nYou put your hands all over my body and told me, umm\n" +
                "You told me you were ready\nFor the big one, for the big jump\nI'd be your last love everlasting you and me\n" +
                "That was what you told me\nI'm giving you up\nI've forgiven it all",
                "https://ts2.tarafdari.com/contents/user6984/content-sound/04_-_send_my_love_to_your_new_lover.mp3",
                HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().newAlbum("30");
        SingerController.getSingerController().publishing("Easy on ME", "Pop", "There ain't no gold in this river\n" +
                "That I've been washin' my hands in forever\nI know there is hope in these waters\nBut I can't bring myself to swim\n" +
                "When I am drowning in this silence\nBaby, let me in\n", "https://ts10.tarafdari.com/contents/user493647/content-sound/easy_on_me_-_adele_320.mp3",
                HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins302");
        launch();
    }
}