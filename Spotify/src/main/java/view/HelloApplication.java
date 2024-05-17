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
        SingerModel singerModel2 = new SingerModel("bad omens", "12345fGGG@", "bad omens band", "bad_omens@gmail.com", "09911039121", LocalDate.of(2004,10,12) ,"here");
        SingerModel singerModel3 = new SingerModel("Charlie Puth", "1224fGGG@", "Charles Otto Puth", "Charles_Puth@gmail.com", "09910039122", LocalDate.of(1991,12,2) ,"hello");

        PodcasterModel podcasterModel = new PodcasterModel("sarahBrown", "S@r@h1234", "Sarah Brown", "sarah.brown@example.com", "09456789012", LocalDate.of(1992,3,20),"Coffee lover ☕");

        SingerController.getSingerController().loginArtist("Adele");
        SingerController.getSingerController().newAlbum("25");
        SingerController.getSingerController().publishing("Hello", "Jazz", "Hello, it's me\n" +
                        "I was wondering if after all these years you'd like to meet\nTo go over everything\n" +
                        "They say that time's supposed to heal ya, but I ain't done much healing\nHello, can you hear me?\n" +
                        "I'm in California dreaming about who we used to be\nWhen we were younger and free\n" +
                        "I've forgotten how it felt before the world fell at our feet\nThere's such a difference between us\n" +
                        "And a million miles\nHello from the other side\nI must've called a thousand times\n" +
                        "To tell you I'm sorry for everything that I've done\nBut when I call, you never seem to be home\n" +
                        "Hello from the outside\nAt least I can say that I've tried\nTo tell you I'm sorry for breaking your heart\n" +
                        "But it don't matter, it clearly doesn't tear you apart anymore",
                "https://ts1.tarafdari.com/contents/user360611/content-sound/adele_-_hello_mytextmusic.com_.mp3",
                HelloApplication.class.getResource("img/cover/hello.png").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().publishing("When we were young", "Pop",
                "Everybody loves the things you do\nFrom the way you talk\nTo the way you move\nEverybody here is watching you\n" +
                        "'Cause you feel like home\nYou're like a dream come true\nBut if by chance you're here alone\n" +
                        "Can I have a moment?\nBefore I go?\n'Cause I've been by myself all night long\nHoping you're someone I used to know\n" +
                        "You look like a movie\nYou sound like a song\nMy God this reminds me, of when we were young\n" +
                        "Let me photograph you in this light\nIn case it is the last time\nThat we might be exactly like we were\n" +
                        "Before we realized\nWe were scared of getting old\nIt made us restless\nIt was just like a movie\n" +
                        "It was just like a song\nI was so scared to face my fears\nNobody told me that you'd be here\n" +
                        "And I'd swear you moved overseas\nThat's what you said, when you left me" ,
                "https://ts15.tarafdari.com/contents/user687779/content-sound/when_we_were_young.mp3",HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().publishing("Send My Love", "Jazz",
                "This was all you, none of it me\nYou put your hands all over my body and told me, umm\n" +
                "You told me you were ready\nFor the big one, for the big jump\nI'd be your last love everlasting you and me\n" +
                "That was what you told me\nI'm giving you up\nI've forgiven it allYou set me free\nSend my love to your new lover\n" +
                "Treat her better\nWe've gotta let go of all of our ghosts\nWe both know we ain't kids no more\n" +
                "Send my love to your new lover\nTreat her better\nWe've gotta let go of all of our ghosts\n" +
                "We both know we ain't kids no more\nI was too strong, you were trembling\nYou couldn't handle the hot heat rising (rising), mmm\n" +
                "Baby, I'm still rising\nI was running, you were walking\nYou couldn't keep up, you were falling down (down), mmm\n" +
                "There's only one way down",
                "https://ts2.tarafdari.com/contents/user6984/content-sound/04_-_send_my_love_to_your_new_lover.mp3",
                HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().newAlbum("30");
        SingerController.getSingerController().publishing("Easy on ME", "Pop", "There ain't no gold in this river\n" +
                "That I've been washin' my hands in forever\nI know there is hope in these waters\nBut I can't bring myself to swim\n" +
                "When I am drowning in this silence\nBaby, let me in\nGo easy on me, baby\nI was still a child\n" +
                "Didn't get the chance to\nFeel the world around me\nI had no time to choose\nWhat I chose to do\n" +
                "So go easy on me\nThere ain't no room for things to change\nWhen we are both so deeply stuck in our ways\n" +
                "You can't deny how hard I've tried\nI changed who I was to put you both first\nBut now I give up\n" +
                "Go easy on me, baby\nI was still a child\nDidn't get the chance to\nFeel the world around me\n" +
                "Had no time to choose\nWhat I chose to do\nSo go easy on me",
                "https://ts10.tarafdari.com/contents/user493647/content-sound/easy_on_me_-_adele_320.mp3",
                HelloApplication.class.getResource("").toExternalForm(), "Adele Adkins302");

        SingerController.getSingerController().loginArtist("bad omens");
        SingerController.getSingerController().newAlbum("The Death of Peace of Mind");
        SingerController.getSingerController().publishing("Just Pretend", "Rock",
                "I'm not afraid of the war you've come to wage against my sins\nI'm not okay, but I can try my best to just pretend\n" +
                        "So will you wait me out\nOr will you drown me out?\nSo will you wait me out\nOr will you drown me out? (at the bottom)\n" +
                        "I can wait for you at the bottom\nI can stay away if you want me to\nI can wait for years if I gotta\n" +
                        "Heaven knows I ain't getting over you", "https://ts13.tarafdari.com/contents/user742612/content-sound/bad_omens_-_just_pretend.mp3",
                HelloApplication.class.getResource("img/cover/just pretend.jpg").toExternalForm(), "bad omens bandThe Death of Peace of Mind3");
       SingerController.getSingerController().publishing("The Death of Peace of Mind", "Rock",
                       "Thought I could make it out\nPromises break, need to hear you say\nYou're gonna keep it now\n" +
                       "I miss the way you say my name\nThe way you bend, the way you break\nYour makeup running down your face\n" +
                       "The way you touch, the way you taste\nWhen the curtains call the time\nWill we both go home alive?\n" +
                       "It wasn't hard to realize\nLove's the death of peace of mind\nYou're in the walls that I made with crosses and frames\n" +
                       "Hanging upside down\nFor granted, in vain, I took everything\nI ever cared about"
                , "https://ts13.tarafdari.com/contents/user823957/content-sound/bad-omens-the-death-of-peace-of-mind.mp3",
                HelloApplication.class.getResource("img/cover/the death of peace of mind.jpg").toExternalForm(), "bad omens bandThe Death of Peace of Mind3");
        SingerController.getSingerController().publishing("Take My First", "Rock",
                        "Oh God, I tried but I don't know how\nI want to be someone you used to hate\n" +
                        "Without the memory of the pain\nI went too far, now we can't restart\n" +
                        "It's like we cut the brakes, tore 'em off the car\nNinety miles inside the dark\n" +
                        "Familiar scars, and electric hearts\nI know I'm gonna die in this bed I made\n" +
                        "And I'm drowning in a dream that I can't escape\nIf I could wake up I'd hesitate\n" +
                        "But it's too late to turn back now\nOh God, I tried but I don't know how\n" +
                        "If I could escape it\nI'd trade in the blame, you can take it\nIf I doesn't take me first\n" +
                        "If I doesn't take me first","https://ts15.tarafdari.com/contents/user810598/content-sound/13_-_take_me_first_-_bad_omens_128.mp3",
                HelloApplication.class.getResource("").toExternalForm(), "bad omens bandThe Death of Peace of Mind3");

        SingerController.getSingerController().loginArtist("Charlie Puth");
        SingerController.getSingerController().newAlbum("Nine Track Mind");
        SingerController.getSingerController().publishing("I love U dangerously", "Pop",
                "This is gonna hurt, but I blame myself first\n'Cause I ignored the truth\n" +
                        "Drunk off of that love, it my head up\nThere's no forgetting you\n" +
                        "You've awoken me, but you're choking me\nI was so obsessed\n" +
                        "Gave you all of me\nAnd now, honestly, I got nothing left\nI loved you dangerously\n" +
                        "More than the air that I breathe\nKnew we would crash at the speed that we were going\n" +
                        "Didn't care if the explosion ruined me (me, me)\nBaby, I loved you dangerously\nMm, mm\n" +
                        "I loved you dangerously\nUsually, I hold the power with both my hands tied behind my back\n" +
                        "Look at how things change\n'Cause now you're the train\nAnd I'm tied to the track\n" +
                        "You've awoken me, but you're choking me\nI was so obsessed\nGave you all of me\n" +
                        "And now, honestly, I got nothing left\n'Cause I loved you dangerously\n" +
                        "More than the air that I breathe\nKnew we would crash at the speed that we were going\n" +
                        "Didn't care if the explosion ruined me (me, me)\nBaby, I loved you dangerously",
                "https://ts2.tarafdari.com/contents/user478021/content-sound/dangerously_-_charlie_puth.mp3",
                HelloApplication.class.getResource("img/cover/Charlie_Puth_-_Dangerously.jpg").toExternalForm(), "Charles Otto PuthNine Track Mind4");

        SingerController.getSingerController().publishing("We don't talk anymore ", "Pop", "We don't talk anymore\n" +
                        "We don't talk anymore\nWe don't talk anymore\nLike we used to do\nWe don't love anymore\n" +
                        "What was all of it for?\nOh, we don't talk anymore\nLike we used to do\n" +
                        "I just heard you found the one you've been looking\nYou've been looking for\n" +
                        "I wish I would have known that wasn't me\n'Cause even after all this time, I still wonder\n" +
                        "Why I can't move on\nJust the way you did so easily\nDon't wanna know\n" +
                        "Kind of dress you're wearing tonight\nIf he's holding onto you so tight\n" +
                        "The way I did before\nI overdosed\nShould've known your love was a game\n" +
                        "Now I can't get you out of my brain\nOh, it's such a shame"
                ,"https://ts9.tarafdari.com/contents/user678699/content-sound/charlie_puth_-_we_dont_talk_anymore_lyrics_feat._selena_gomez.mp3",
                HelloApplication.class.getResource("img/cover/We_Don't_Talk_Anymore.png").toExternalForm(), "Charles Otto PuthNine Track Mind4");

        launch();
    }
}