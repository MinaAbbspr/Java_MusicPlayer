package controller.user.userType.listener.type;

import model.Database;
import model.Subscription;
import model.audio.PlaylistModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PremiumControllerTest {

    @BeforeAll
    public static void setup() throws Exception {
        HelloApplication.fillDatabase();
        FreeController.getFreeController().loginListener("Mina");
        FreeController.getListenerController().makePlaylist("a");
        FreeController.getListenerController().addAudioToPlaylist("a", Database.getDatabase().getAudios().get(0));
        FreeController.getListenerController().addAudioToPlaylist("a", Database.getDatabase().getAudios().get(1));
        FreeController.getListenerController().getPremium(Subscription.Package60Days);
        PremiumController.getPremiumController().loginListener("Mina");
    }

    @Test
    public void testSelectPlaylist() {
        //Arrange
        PlaylistModel expected = PremiumController.getPremiumController().getPremium().getPlaylists().getFirst();

        //Act
        PlaylistModel actual = PremiumController.getPremiumController().selectPlaylist("a");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testMakePlaylistRepeatedNameException() {
        //Arrange
        String expected = "playlist with this name has already been created";

        //Act
        Exception actual = assertThrows(Exception.class, () -> {
            PremiumController.getPremiumController().makePlaylist("a");
        });

        //Assert
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void testAddAudioToPlaylistRepeatedAudioException() {
        //Arrange
        String expected = "you have already added this Audio to playlist";

        //Act
        Exception actual = assertThrows(Exception.class, () -> {
            PremiumController.getPremiumController().addAudioToPlaylist("a", Database.getDatabase().getAudios().getFirst());
        });

        //Assert
        assertEquals(expected, actual.getMessage());
    }

    @Test
    public void testAddAudioToPlaylist() throws Exception {
        //Arrange
        String expected = "Audio added to playlist successfully";

        //Act
        String actual = PremiumController.getPremiumController().addAudioToPlaylist("a", Database.getDatabase().getAudios().get(10));

        //Assert
        assertEquals(expected, actual);
    }
}
