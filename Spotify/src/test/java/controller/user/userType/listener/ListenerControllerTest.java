package controller.user.userType.listener;

import model.Database;
import model.audio.AudioModel;
import model.audio.PlaylistModel;
import model.user.type.artist.ArtistModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListenerControllerTest {

    @BeforeAll
    public static void setup() throws Exception {
        HelloApplication.fillDatabase();
        ListenerController.getListenerController().loginListener("Mina");
        ListenerController.getListenerController().followArtist("Adele");
    }

    @Test
    public void testShowFollowings(){
        //Arrange
        List<ArtistModel> expected = new ArrayList<>();
        expected.add((ArtistModel) Database.getDatabase().getUserAccounts().get(1));

        //Act
        List<ArtistModel> actual = ListenerController.getListenerController().showFollowings();

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testFollowArtistException(){
        //Arrange
        String expected = "you already follow Artist";

        //Act
        Exception actual = assertThrows(Exception.class, () -> ListenerController.getListenerController().followArtist("Adele"));

        //Assert
        assertEquals(expected,actual.getMessage());
    }
}
