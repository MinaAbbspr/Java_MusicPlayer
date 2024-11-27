package view.listener.components;

import controller.user.userType.listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.user.type.artist.ArtistModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Following implements Initializable {
    @FXML
    private GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVBoxArtist(ListenerController.getListenerController().showFollowings());
        gridPane.setBackground(Background.fill(Color.WHITE));
    }

    private void setVBoxArtist(List<ArtistModel> list){
        int counter = 0;
        for(ArtistModel artist : list){
            View.getView().setArtistModel(artist);
            try {
                gridPane.add(new FXMLLoader(HelloApplication.class.getResource("vBoxArtist.fxml")).load(),counter%4, counter++/4);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
