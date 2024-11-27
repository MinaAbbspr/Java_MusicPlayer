package controller;

import model.Database;
import model.audio.AudioModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.SingerModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.HelloApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StableControllerTest {

    private static SingerModel singerModel;

    @BeforeAll
    public static void setup(){
        HelloApplication.fillDatabase();
        singerModel = (SingerModel) Database.getDatabase().getUserAccounts().get(1);
    }

    @Test
    public void testArtistsInfo(){
        //Arrange
        List<ArtistModel> expected = new ArrayList<>();
        expected.add((ArtistModel) Database.getDatabase().getUserAccounts().get(1));
        expected.add((ArtistModel) Database.getDatabase().getUserAccounts().get(2));
        expected.add((ArtistModel) Database.getDatabase().getUserAccounts().get(3));
        expected.add((ArtistModel) Database.getDatabase().getUserAccounts().get(4));
        expected.add((ArtistModel) Database.getDatabase().getUserAccounts().get(5));


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
