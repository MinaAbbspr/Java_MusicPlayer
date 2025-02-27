package view.stables.audio;

import controller.AudioController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.audio.AudioModel;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VBoxAudio implements Initializable {

    @FXML
    private ImageView img_cover;

    @FXML
    private Label lbl_artistName;

    @FXML
    private Label lbl_audioName;

    private AudioModel audioModel;

    @FXML
    void playAudio(MouseEvent event) throws IOException {
        View.getView().setMediaPlayer(audioModel);
        View.getView().showPlayMusic();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_cover.setImage(new Image(AudioController.getAudioController().getAudio().getCover()));
        lbl_artistName.setText(AudioController.getAudioController().getAudio().getArtistName());
        lbl_audioName.setText(AudioController.getAudioController().getAudio().getAudioName());
        audioModel = AudioController.getAudioController().getAudio();
    }
}
