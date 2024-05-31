package controller.user.userType.artist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArtistControllerTest {

    @BeforeAll
    public static void setup(){
        HelloApplication.fillDatabase();
        ArtistController.getArtistController().loginArtist("Adele");
    }

    @Test
    public void testShowFollowersNullPointerException(){
        //Arrange
        String expected = "you have no followers!";


        //Act
        NullPointerException actual = assertThrows(NullPointerException.class, () -> {
            ArtistController.getArtistController().showFollowers();
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }
}
