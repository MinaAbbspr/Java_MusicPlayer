package controller.user.userType.listener.type;

import exceptions.FreeAccountLimitException;
import model.Database;
import model.audio.PlaylistModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FreeControllerTest {

    @BeforeAll
    public static void setup() throws Exception {
        HelloApplication.fillDatabase();
        FreeController.getFreeController().loginListener("Mina");
        FreeController.getListenerController().makePlaylist("a");
        FreeController.getListenerController().makePlaylist("b");
        FreeController.getListenerController().makePlaylist("c");
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(0));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(1));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(2));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(3));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(4));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(5));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(6));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(7));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(8));
        FreeController.getListenerController().addAudioToPlaylist("a" ,Database.getDatabase().getAudios().get(9));
    }

    @Test
    public void testSelectPlaylist(){
        //Arrange
        PlaylistModel expected = FreeController.getFreeController().getFree().getPlaylists().get(1);


        //Act
        PlaylistModel actual = FreeController.getFreeController().selectPlaylist("b");

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void testMakePlaylistEFreeAccountLimitException(){
        //Arrange
        String expected = "you can not make new playlist";


        //Act
        FreeAccountLimitException actual = assertThrows(FreeAccountLimitException.class, () -> {
            FreeController.getListenerController().makePlaylist("d");
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testAddAudioToPlaylistRepeatedAudioException(){
        //Arrange
        String expected = "you have already added this Audio to playlist";


        //Act
        Exception actual = assertThrows(Exception.class, () -> {
            FreeController.getListenerController().addAudioToPlaylist("a", Database.getDatabase().getAudios().getFirst());
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testAddAudioToPlaylistFreeAccountLimitException(){
        //Arrange
        String expected = "you can not add new audio to this playlist";


        //Act
        FreeAccountLimitException actual = assertThrows(FreeAccountLimitException.class, () -> {
            FreeController.getListenerController().addAudioToPlaylist("a", Database.getDatabase().getAudios().get(10));
        });

        //Assert
        assertEquals(expected,actual.getMessage());
    }

    @Test
    public void testAddAudioToPlaylist() throws Exception {
        //Arrange
        String expected = "Audio added to playlist successfully";


        //Act
        String actual = FreeController.getListenerController().addAudioToPlaylist("b", Database.getDatabase().getAudios().get(10));

        //Assert
        assertEquals(expected,actual);
    }
}
