package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.audio.AudioModel;

import java.net.URL;
import java.util.ResourceBundle;

public class VBoxHome implements Initializable {

    @FXML
    private ImageView img_cover;

    @FXML
    private Label lbl_artistName;

    @FXML
    private Label lbl_audioName;

    @FXML
    private VBox vBox;

    private static AudioModel audio;

    public static void setAudio(AudioModel audio) {
        VBoxHome.audio = audio;
    }

    @FXML
    void playAudio(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_cover.setImage(new Image(audio.getCover()));
        lbl_artistName.setText(audio.getArtistName());
        lbl_audioName.setText(audio.getAudioName());
    }
}
