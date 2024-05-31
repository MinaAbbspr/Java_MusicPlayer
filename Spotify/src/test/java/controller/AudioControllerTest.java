package controller;

import model.audio.AudioModel;
import model.audio.type.MusicModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioControllerTest {

    private static List<AudioModel> audios;

    @BeforeAll
    public static void setup(){
        audios = new ArrayList<>();
        audios.add(new MusicModel("I love U dangerously","Charles Otto Puth", "Pop",
                "https://ts2.tarafdari.com/contents/user478021/content-sound/dangerously_-_charlie_puth.mp3",
                Objects.requireNonNull(HelloApplication.class.getResource("img/cover/Charlie_Puth_-_Dangerously.jpg")).toExternalForm(),
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
                        Baby, I loved you dangerously"""));
        audios.add(new MusicModel("We don't talk anymore ","Charles Otto Puth", "Pop",
                "https://ts9.tarafdari.com/contents/user678699/content-sound/charlie_puth_-_we_dont_talk_anymore_lyrics_feat._selena_gomez.mp3",
                Objects.requireNonNull(HelloApplication.class.getResource("img/cover/We_Don't_Talk_Anymore.png")).toExternalForm(),
                """
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
                        Oh, it's such a shame"""));
        audios.add(new MusicModel("See You Again","Charles Otto Puth", "HipHop",
                "https://ts1.tarafdari.com/contents/user188286/content-sound/wiz_khalifa_ft._charlie_puth_-_see_you_again.mp3",
                Objects.requireNonNull(HelloApplication.class.getResource("img/cover/see you again.jpg")).toExternalForm(),
                     """
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
                     (Remember me when I'm gone)"""));
    }

    @Test
    public void testSearchWithArtistName(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>(audios);

        //Act
        List <AudioModel> actual = AudioController.getAudioController().search("Charles Otto Puth");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testSearchWithAudioName(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(audios.get(1));

        //Act
        List <AudioModel> actual = AudioController.getAudioController().search("We don't talk anymore ");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testSort(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(audios.get(0));
        expected.add(audios.get(2));
        expected.add(audios.get(1));

        //Act
        List <AudioModel> actual = AudioController.getAudioController().sort(audios);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testArtistFilter(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>(audios);

        //Act
        List <AudioModel> actual = AudioController.getAudioController().artistFilter(audios, "Charles Otto Puth");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testGenreFilter(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(audios.get(0));
        expected.add(audios.get(1));

        //Act
        List <AudioModel> actual = AudioController.getAudioController().genreFilter(audios, "Pop");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testDateFilter(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>(audios);

        //Act
        List <AudioModel> actual = AudioController.getAudioController().dateFilter(audios, LocalDate.now());

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testDateFilterNullAnswer(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();

        //Act
        List <AudioModel> actual = AudioController.getAudioController().dateFilter(audios, LocalDate.of(2023,10,12));

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testTwoDateFilter(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>(audios);

        //Act
        List <AudioModel> actual = AudioController.getAudioController().twoDateFilter(audios, LocalDate.of(2023,5,31),LocalDate.now());

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testIsGenre(){
        //Arrange
        boolean expected = true;

        //Act
        boolean actual = AudioController.getAudioController().isGenre("Jazz");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testIsGenreWrongAnswer(){
        //Arrange
        boolean expected = false;

        //Act
        boolean actual = AudioController.getAudioController().isGenre("jazz");

        //Assert
        assertEquals(expected,actual);
    }

}
