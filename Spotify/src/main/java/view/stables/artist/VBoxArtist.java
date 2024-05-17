package view.stables.artist;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.user.type.artist.ArtistModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VBoxArtist implements Initializable {

    @FXML
    private ImageView img_account;

    @FXML
    private Label lbl_artistName;

    @FXML
    private Label lbl_bio;

    @FXML
    private VBox vBox;
    private ArtistModel artistModel;

    @FXML
    void showArtist(MouseEvent event) throws IOException {
        View.getView().setArtistModel(artistModel);
        View.getView().showMainPage("artistInfo.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.artistModel = View.getView().getArtistModel();
        img_account.setImage(new Image(HelloApplication.class.getResource("img/account/Account.png").toExternalForm()));
        lbl_artistName.setText(artistModel.getName());
        lbl_bio.setText(artistModel.getBio());
    }
}
