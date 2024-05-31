package controller;

import controller.user.userType.artist.type.SingerController;
import model.audio.AudioModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.SingerModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StableControllerTest {

    private static SingerModel singerModel;

    @BeforeAll
    public static void setup(){
        HelloApplication.fillDatabase();
        singerModel = new SingerModel("Charlie Puth", "1224fGGG@", "Charles Otto Puth", "Charles_Puth@gmail.com", "09910039122", LocalDate.of(1991,12,2) ,"charlieputh.lnk.to/Hero");

        SingerController.getSingerController().loginArtist("Charlie Puth");
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
                Objects.requireNonNull(HelloApplication.class.getResource("img/cover/Charlie_Puth_-_Dangerously.jpg")).toExternalForm());
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
                Objects.requireNonNull(HelloApplication.class.getResource("img/cover/We_Don't_Talk_Anymore.png")).toExternalForm());
        SingerController.getSingerController().publishing("See You Again", "HipHop", """
                     It's been a long day without you, my friend
                     And I'll tell you all about it when I see you again
                     We've come a long way from where we began
                     Oh, I'll tell you all about it when I see you again
                     When I see you again
                     … Damn, who knew?
                     All the planes we flew, good things we been through
                     That I'd be standing right here talking to you
                     'Bout another path, I know we loved to hit the road and laugh
                     But something told me that it wouldn't last
                     Had to switch up, look at things different, see the bigger picture
                     Those were the days, hard work forever pays
                     Now I see you in a better place (see you in a better place)
                     Uh
                     … How can we not talk about family when family's all that we got?
                     Everything I went through, you were standing there by my side
                     And now you gon' be with me for the last ride
                     … It's been a long day without you, my friend
                     And I'll tell you all about it when I see you again (I'll see you again)
                     We've come a long way (yeah, we came a long way)
                     From where we began (you know we started)
                     Oh, I'll tell you all about it when I see you again (I'll tell you)
                     When I see you again
                     … First, you both go out your way and the vibe is feeling strong
                     And what's small turned to a friendship, a friendship turned to a bond
                     And that bond will never be broken, the love will never get lost
                     (The love will never get lost)
                     And when brotherhood come first, then the line will never be crossed
                     Established it on our own when that line had to be drawn
                     And that line is what we reached, so remember me when I'm gone
                     (Remember me when I'm gone)"""
                ,"https://ts1.tarafdari.com/contents/user188286/content-sound/wiz_khalifa_ft._charlie_puth_-_see_you_again.mp3",
                Objects.requireNonNull(HelloApplication.class.getResource("img/cover/see you again.jpg")).toExternalForm());
    }

    @Test
    public void testArtistsInfo(){
        //Arrange
        List<ArtistModel> expected = new ArrayList<>();
        expected.add(singerModel);
        expected.add(new SingerModel("Adele", "Ad88", "Adele Adkins", "Adele.Adkins@gmail.com", "09945632105", LocalDate.of(1988, 5, 5), "Musician\nadele.com"));
        expected.add(new SingerModel("bad omens", "12345fGGG@", "bad omens band", "bad_omens@gmail.com", "09911039121", LocalDate.of(2004, 10, 12), "BAD OMENS\nCONCRETE\nbadomensofficial.com"));
        expected.add(new SingerModel("Sasha Sloan", "slo", "Sasha Alex Sloan", "Sasha_Sloan@gmail.com", "09910039182", LocalDate.of(1995, 3, 11), "voted most creative in\nmy 9th grade yearbook"));

        //Act
        List <ArtistModel> actual = StableController.getStableController().artistsInfo();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testArtistList(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>(singerModel.getMusicList());


        //Act
        List<AudioModel> actual = StableController.getStableController().artistList(singerModel);

        //Assert
        assertEquals(expected,actual);
    }
}
