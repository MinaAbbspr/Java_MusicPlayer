package view;

import controller.AudioController;
import controller.LogoutController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.audio.AudioModel;
import model.audio.PlaylistModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlaylistsAudio implements Initializable {

    @FXML
    private GridPane gridPane;

    @FXML
    private Label lbl_playListName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_playListName.setText(View.getView().getPlaylist().getPlaylistName());
        setVBox();
    }

    private void setVBox(){
        int counter = 0;
        for(AudioModel audio : View.getView().getPlaylist()){
            AudioController.getAudioController().setAudio(audio);
            try {
                gridPane.add(new FXMLLoader(HelloApplication.class.getResource("vBoxAudio.fxml")).load(),counter%4, counter++/4);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
