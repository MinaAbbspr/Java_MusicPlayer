package controller.user.userType.artist.type;

import model.Database;
import model.audio.AudioModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingerControllerTest {
    @BeforeAll
    public static void setup(){
        HelloApplication.fillDatabase();
        SingerController.getSingerController().loginArtist("Adele");
    }

    @Test
    public void testShowNumberOfPlayed() {
        //Arrange
        int expected = 0;

        //Act
        int actual = SingerController.getSingerController().showNumberOfPlayed();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testCalculateEarnings() {
        //Arrange
        String expected = "your income is 0.0 dollars" ;

        //Act
        String actual = SingerController.getSingerController().calculateEarnings();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testPublishingNullPointException(){
        //Arrange
        String expected = "write all information";


        //Act
        NullPointerException actual = assertThrows(NullPointerException.class, () -> {
            SingerController.getSingerController().publishing("", "Pop", "lyrics", "link", "cover");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testPublishing() {
        //Arrange
        String expected = "music published successfully";
        //Act
        String actual = SingerController.getSingerController().publishing("name", "Pop", "caption", "link", "cover");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testGetAudios() {
        //Arrange
        List<AudioModel> expected = new ArrayList<>();
        expected.add(Database.getDatabase().getAudios().get(0));
        expected.add(Database.getDatabase().getAudios().get(1));
        expected.add(Database.getDatabase().getAudios().get(2));
        expected.add(Database.getDatabase().getAudios().get(3));
        expected.add(Database.getDatabase().getAudios().get(4));

        //Act
        List<AudioModel> actual = SingerController.getSingerController().getAudios();

        //Assert
        assertEquals(expected,actual);
    }
}
