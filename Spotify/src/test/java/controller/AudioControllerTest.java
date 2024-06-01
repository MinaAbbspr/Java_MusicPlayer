package controller;

import model.Database;
import model.audio.AudioModel;
import model.user.type.artist.type.SingerModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioControllerTest {

    private static List<AudioModel> audios;

    @BeforeAll
    public static void setup(){
        HelloApplication.fillDatabase();
        SingerModel singerModel = (SingerModel) Database.getDatabase().getUserAccounts().get(3);
        audios = new ArrayList<>(singerModel.getMusicList());
    }

    @Test
    public void testSearchWithArtistName(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(audios.get(0));
        expected.add(audios.get(2));
        expected.add(audios.get(1));


        //Act
        List <AudioModel> actual = AudioController.getAudioController().search("Charlie Puth");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testSearchWithAudioName(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(audios.get(2));

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
        List <AudioModel> actual = AudioController.getAudioController().artistFilter(audios, "Charlie Puth");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testGenreFilter(){
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(audios.get(0));
        expected.add(audios.get(2));

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
