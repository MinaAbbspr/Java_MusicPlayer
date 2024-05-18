package view;

import controller.userType.Artist.type.SingerController;
import controller.userType.Listener.type.FreeController;
import javafx.application.Application;
import javafx.stage.Stage;
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
        SingerController.getSingerController().publishing("Hello", "Jazz", """
                        Hello, it's me
                        I was wondering if after all these years you'd like to meet
                        To go over everything
                        They say that time's supposed to heal ya, but I ain't done much healing
                        Hello, can you hear me?
                        I'm in California dreaming about who we used to be
                        When we were younger and free
                        I've forgotten how it felt before the world fell at our feet
                        There's such a difference between us
                        And a million miles
                        Hello from the other side
                        I must've called a thousand times
                        To tell you I'm sorry for everything that I've done
                        But when I call, you never seem to be home
                        Hello from the outside
                        At least I can say that I've tried
                        To tell you I'm sorry for breaking your heart
                        But it don't matter, it clearly doesn't tear you apart anymore""",
                "https://ts1.tarafdari.com/contents/user360611/content-sound/adele_-_hello_mytextmusic.com_.mp3",
                HelloApplication.class.getResource("img/cover/hello.png").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().publishing("When we were young", "Pop",
                """
                        Everybody loves the things you do
                        From the way you talk
                        To the way you move
                        Everybody here is watching you
                        'Cause you feel like home
                        You're like a dream come true
                        But if by chance you're here alone
                        Can I have a moment?
                        Before I go?
                        'Cause I've been by myself all night long
                        Hoping you're someone I used to know
                        You look like a movie
                        You sound like a song
                        My God this reminds me, of when we were young
                        Let me photograph you in this light
                        In case it is the last time
                        That we might be exactly like we were
                        Before we realized
                        We were scared of getting old
                        It made us restless
                        It was just like a movie
                        It was just like a song
                        I was so scared to face my fears
                        Nobody told me that you'd be here
                        And I'd swear you moved overseas
                        That's what you said, when you left me""",
                "https://ts15.tarafdari.com/contents/user687779/content-sound/when_we_were_young.mp3",
                HelloApplication.class.getResource("img/cover/when we were young.jpg").toExternalForm(),"Adele Adkins251");
        SingerController.getSingerController().publishing("Send My Love", "Jazz",
                """
                        This was all you, none of it me
                        You put your hands all over my body and told me, umm
                        You told me you were ready
                        For the big one, for the big jump
                        I'd be your last love everlasting you and me
                        That was what you told me
                        I'm giving you up
                        I've forgiven it allYou set me free
                        Send my love to your new lover
                        Treat her better
                        We've gotta let go of all of our ghosts
                        We both know we ain't kids no more
                        Send my love to your new lover
                        Treat her better
                        We've gotta let go of all of our ghosts
                        We both know we ain't kids no more
                        I was too strong, you were trembling
                        You couldn't handle the hot heat rising (rising), mmm
                        Baby, I'm still rising
                        I was running, you were walking
                        You couldn't keep up, you were falling down (down), mmm
                        There's only one way down""",
                "https://ts2.tarafdari.com/contents/user6984/content-sound/04_-_send_my_love_to_your_new_lover.mp3",
                HelloApplication.class.getResource("img/cover/send my love.jpg").toExternalForm(), "Adele Adkins251");
        SingerController.getSingerController().newAlbum("30");
        SingerController.getSingerController().publishing("Easy on ME", "Pop", """
                        There ain't no gold in this river
                        That I've been washin' my hands in forever
                        I know there is hope in these waters
                        But I can't bring myself to swim
                        When I am drowning in this silence
                        Baby, let me in
                        Go easy on me, baby
                        I was still a child
                        Didn't get the chance to
                        Feel the world around me
                        I had no time to choose
                        What I chose to do
                        So go easy on me
                        There ain't no room for things to change
                        When we are both so deeply stuck in our ways
                        You can't deny how hard I've tried
                        I changed who I was to put you both first
                        But now I give up
                        Go easy on me, baby
                        I was still a child
                        Didn't get the chance to
                        Feel the world around me
                        Had no time to choose
                        What I chose to do
                        So go easy on me""",
                "https://ts10.tarafdari.com/contents/user493647/content-sound/easy_on_me_-_adele_320.mp3",
                HelloApplication.class.getResource("img/cover/easy on me.jpg").toExternalForm(), "Adele Adkins302");

        SingerController.getSingerController().loginArtist("bad omens");
        SingerController.getSingerController().newAlbum("The Death of Peace of Mind");
        SingerController.getSingerController().publishing("Just Pretend", "Rock",
                """
                        I'm not afraid of the war you've come to wage against my sins
                        I'm not okay, but I can try my best to just pretend
                        So will you wait me out
                        Or will you drown me out?
                        So will you wait me out
                        Or will you drown me out? (at the bottom)
                        I can wait for you at the bottom
                        I can stay away if you want me to
                        I can wait for years if I gotta
                        Heaven knows I ain't getting over you""", "https://ts13.tarafdari.com/contents/user742612/content-sound/bad_omens_-_just_pretend.mp3",
                HelloApplication.class.getResource("img/cover/just pretend.jpg").toExternalForm(), "bad omens bandThe Death of Peace of Mind3");
        SingerController.getSingerController().publishing("The Death of Peace of Mind", "Rock",
                """
                        Thought I could make it out
                        Promises break, need to hear you say
                        You're gonna keep it now
                        I miss the way you say my name
                        The way you bend, the way you break
                        Your makeup running down your face
                        The way you touch, the way you taste
                        When the curtains call the time
                        Will we both go home alive?
                        It wasn't hard to realize
                        Love's the death of peace of mind
                        You're in the walls that I made with crosses and frames
                        Hanging upside down
                        For granted, in vain, I took everything
                        I ever cared about"""
                , "https://ts13.tarafdari.com/contents/user823957/content-sound/bad-omens-the-death-of-peace-of-mind.mp3",
                HelloApplication.class.getResource("img/cover/the death of peace of mind.jpg").toExternalForm(), "bad omens bandThe Death of Peace of Mind3");
        SingerController.getSingerController().publishing("Take My First", "Rock",
                """
                        Oh God, I tried but I don't know how
                        I want to be someone you used to hate
                        Without the memory of the pain
                        I went too far, now we can't restart
                        It's like we cut the brakes, tore 'em off the car
                        Ninety miles inside the dark
                        Familiar scars, and electric hearts
                        I know I'm gonna die in this bed I made
                        And I'm drowning in a dream that I can't escape
                        If I could wake up I'd hesitate
                        But it's too late to turn back now
                        Oh God, I tried but I don't know how
                        If I could escape it
                        I'd trade in the blame, you can take it
                        If I doesn't take me first
                        If I doesn't take me first""","https://ts15.tarafdari.com/contents/user810598/content-sound/13_-_take_me_first_-_bad_omens_128.mp3",
                HelloApplication.class.getResource("img/cover/take my first.jpg").toExternalForm(), "bad omens bandThe Death of Peace of Mind3");

        SingerController.getSingerController().loginArtist("Charlie Puth");
        SingerController.getSingerController().newAlbum("Nine Track Mind");
        SingerController.getSingerController().publishing("I love U dangerously", "Pop",
                """
                        This is gonna hurt, but I blame myself first
                        'Cause I ignored the truth
                        Drunk off of that love, it my head up
                        There's no forgetting you
                        You've awoken me, but you're choking me
                        I was so obsessed
                        Gave you all of me
                        And now, honestly, I got nothing left
                        I loved you dangerously
                        More than the air that I breathe
                        Knew we would crash at the speed that we were going
                        Didn't care if the explosion ruined me (me, me)
                        Baby, I loved you dangerously
                        Mm, mm
                        I loved you dangerously
                        Usually, I hold the power with both my hands tied behind my back
                        Look at how things change
                        'Cause now you're the train
                        And I'm tied to the track
                        You've awoken me, but you're choking me
                        I was so obsessed
                        Gave you all of me
                        And now, honestly, I got nothing left
                        'Cause I loved you dangerously
                        More than the air that I breathe
                        Knew we would crash at the speed that we were going
                        Didn't care if the explosion ruined me (me, me)
                        Baby, I loved you dangerously""",
                "https://ts2.tarafdari.com/contents/user478021/content-sound/dangerously_-_charlie_puth.mp3",
                HelloApplication.class.getResource("img/cover/Charlie_Puth_-_Dangerously.jpg").toExternalForm(), "Charles Otto PuthNine Track Mind4");
        SingerController.getSingerController().publishing("We don't talk anymore ", "Pop", """
                        We don't talk anymore
                        We don't talk anymore
                        We don't talk anymore
                        Like we used to do
                        We don't love anymore
                        What was all of it for?
                        Oh, we don't talk anymore
                        Like we used to do
                        I just heard you found the one you've been looking
                        You've been looking for
                        I wish I would have known that wasn't me
                        'Cause even after all this time, I still wonder
                        Why I can't move on
                        Just the way you did so easily
                        Don't wanna know
                        Kind of dress you're wearing tonight
                        If he's holding onto you so tight
                        The way I did before
                        I overdosed
                        Should've known your love was a game
                        Now I can't get you out of my brain
                        Oh, it's such a shame"""
                ,"https://ts9.tarafdari.com/contents/user678699/content-sound/charlie_puth_-_we_dont_talk_anymore_lyrics_feat._selena_gomez.mp3",
                HelloApplication.class.getResource("img/cover/We_Don't_Talk_Anymore.png").toExternalForm(), "Charles Otto PuthNine Track Mind4");

        FreeController.getFreeController().signupListener("Mina","mnbbspr","Mina Abbaspour", "Mina@gmail.com","09133138555",LocalDate.of(2005,1,2));

        launch();
    }
}