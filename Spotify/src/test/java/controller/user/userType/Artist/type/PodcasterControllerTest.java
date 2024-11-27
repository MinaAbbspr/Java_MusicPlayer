package controller.user.userType.artist.type;

import model.audio.AudioModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PodcasterControllerTest {

    @BeforeAll
    public static void setup(){
        HelloApplication.fillDatabase();
        PodcasterController.getPodcasterController().loginArtist("RokhPodcast");
    }

    @Test
    public void testShowNumberOfPlayed() {
        //Arrange
        int expected = 0;

        //Act
        int actual = PodcasterController.getPodcasterController().showNumberOfPlayed();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testCalculateEarnings() {
        //Arrange
        String expected = "your income is 0.0 dollars" ;

        //Act
        String actual = PodcasterController.getPodcasterController().calculateEarnings();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testPublishingNullPointException(){
        //Arrange
        String expected = "write all information";


        //Act
        NullPointerException actual = assertThrows(NullPointerException.class, () -> {
             PodcasterController.getPodcasterController().publishing("", "History", "caption", "link", "cover");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testPublishing() {
        //Arrange
        String expected = "podcast published successfully";
        //Act
        String actual = PodcasterController.getPodcasterController().publishing("name","History","caption","link","cover");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testGetAudios() {
        //Arrange
        List<AudioModel> expected = new ArrayList<>();

        //Act
        List<AudioModel> actual = PodcasterController.getPodcasterController().getAudios();

        //Assert
        assertEquals(expected,actual);
    }
}
