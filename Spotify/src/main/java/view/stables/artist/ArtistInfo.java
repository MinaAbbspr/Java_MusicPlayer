package view.stables.artist;

import controller.AudioController;
import controller.StableController;
import controller.user.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.audio.AudioModel;
import model.user.type.artist.ArtistModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ArtistInfo implements Initializable {

    @FXML
    private HBox hBox;

    @FXML
    private ImageView img;

    @FXML
    private Label lbl_bio;

    @FXML
    private Label lbl_username;

    @FXML
    private AnchorPane root;


    private ArtistModel artistModel;

    @FXML
    void Follow(MouseEvent event) {
        if(View.getView().isLogin() && View.getView().isListener()){
            ListenerController.getListenerController().followArtist(artistModel.getUserName());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("you Follow " + artistModel.getUserName());
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("please Login as Listener");
            alert.setHeaderText("you can't follow artist");
            alert.showAndWait();
        }
    }

    @FXML
    void report(MouseEvent event) throws IOException {
        if(View.getView().isLogin() && View.getView().isListener()){
            View.getView().showReport();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("please Login as Listener");
            alert.setHeaderText("you can't report artist");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artistModel = View.getView().getArtistModel();
        lbl_bio.setText(View.getView().getArtistModel().getBio());
        lbl_username.setText(View.getView().getArtistModel().getUserName());
        img.setImage(new Image(HelloApplication.class.getResource("img/account/Account.png").toExternalForm()));
        root.setBackground(Background.fill(Color.WHITE));
        hBox.setBackground(Background.fill(Color.WHITE));
        hBoxFiller();
    }

    private void hBoxFiller(){
        List<AudioModel> audios = StableController.getStableController().artistList(artistModel);
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
