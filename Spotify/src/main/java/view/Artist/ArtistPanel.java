package view.artist;

import controller.user.userType.Artist.ArtistController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import model.audio.AudioModel;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArtistPanel implements Initializable {

    @FXML
    private Label lbl_bio;

    @FXML
    private Label lbl_birthDate;

    @FXML
    private Label lbl_credit;

    @FXML
    private Label lbl_email;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_phoneNumber;

    @FXML
    private Label lbl_username;

    @FXML
    private ListView<String> listView;

    @FXML
    private AnchorPane root;

    @FXML
    void followers(MouseEvent event) throws IOException {
        View.getView().showMainPage("followers.fxml");
    }

    @FXML
    void publish(MouseEvent event) throws IOException {
        View.getView().showMainPage("publish.fxml");
    }

    @FXML
    void statistics(MouseEvent event) throws IOException {
        View.getView().showMainPage("statistics.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArtistController.getArtistController().calculateEarnings();
        lbl_name.setText("name: " + ArtistController.getArtistController().getArtist().getName());
        lbl_username.setText("username: " + ArtistController.getArtistController().getArtist().getUserName());
        lbl_credit.setText("income: " + ArtistController.getArtistController().getArtist().getIncome());
        lbl_email.setText("email: " + ArtistController.getArtistController().getArtist().getEmail());
        lbl_phoneNumber.setText("phone number: " + ArtistController.getArtistController().getArtist().getPhoneNumber());
        lbl_birthDate.setText("birth date: " + ArtistController.getArtistController().getArtist().getBirthDate());
        lbl_bio.setText("bio: " + ArtistController.getArtistController().getArtist().getBio());

        for(AudioModel audio : ArtistController.getArtistController().getAudios()) {
            listView.getItems().add(audio.getAudioName());
        }

        root.setBackground(Background.fill(Color.WHITE));
    }
}
