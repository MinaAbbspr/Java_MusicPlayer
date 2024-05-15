package view;

import controller.AudioController;
import controller.LogoutController;
import controller.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.audio.AudioModel;
import model.user.type.artist.ArtistModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ArtistInfo implements Initializable {

    @FXML
    private Button btn_follow;

    @FXML
    private Button btn_report;

    @FXML
    private HBox hBox;

    @FXML
    private ImageView img;

    @FXML
    private Label lbl_bio;

    @FXML
    private Label lbl_username;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void follow(MouseEvent event) {
        if(View.getView().isLogin() && View.getView().isListener()){
            ListenerController.getListenerController().followArtist(artistModel.getUserName());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("please Login as Listener");
            alert.setHeaderText("you can't follow artist");
            alert.showAndWait();
        }
    }

    @FXML
    void report(MouseEvent event) {

    }

    private ArtistModel artistModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artistModel = View.getView().getArtistModel();
        lbl_bio.setText(View.getView().getArtistModel().getBio());
        lbl_username.setText(View.getView().getArtistModel().getUserName());
    }

    private void hBoxFiller(){
        List<AudioModel> audios = LogoutController.getLogoutController().artistList(artistModel);
        for(AudioModel audioModel :audios){
            AudioController.getAudioController().setAudio(audioModel);
            try {
                hBox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("vBoxAudio.fxml")).load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
