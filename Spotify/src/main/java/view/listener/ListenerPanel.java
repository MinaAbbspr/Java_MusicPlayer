package view.listener;

import controller.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.audio.PlaylistModel;
import model.user.type.listener.ListenerModel;
import model.user.type.listener.type.PremiumModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel implements Initializable {

    @FXML
    private Button btn_following;

    @FXML
    private Button btn_premium;

    @FXML
    private ImageView img_between;

    @FXML
    private ImageView img_left;

    @FXML
    private ImageView img_right;

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
    private Label lbl_numberOfDays;

    @FXML
    private Label lbl_username;

    @FXML
    private ListView<String> listView;

    private ListenerModel listener;

    @FXML
    void getPremium(MouseEvent event) {

    }

    @FXML
    void openPlaylist(MouseEvent event) throws IOException {
        String playlistName = listView.getSelectionModel().getSelectedItem();
        if(playlistName == null){}
        else if(playlistName.equals("+ create new playlist...")) {
            View.getView().showAddPlaylist();
        }
        else{
            View.getView().setPlaylist(ListenerController.getListenerController().selectPlaylist(playlistName));
            View.getView().showMainPage("playlistsAudio.fxml");
        }
    }

    @FXML
    void showFollowing(MouseEvent event) throws IOException {
        View.getView().showMainPage("following.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_right.setImage(new Image(HelloApplication.class.getResource("img/header/design1.jpg").toExternalForm()));
        img_left.setImage(new Image(HelloApplication.class.getResource("img/header/design1.jpg").toExternalForm()));
        img_between.setImage(new Image(HelloApplication.class.getResource("img/header/design2.jpg").toExternalForm()));

        listener = (ListenerModel) View.getView().getUserAccount();
        lbl_name.setText("name: " + listener.getName());
        lbl_username.setText("username: " + listener.getUserName());
        lbl_credit.setText("credit: " + listener.getCredit());
        lbl_email.setText("email: " + listener.getEmail());
        lbl_phoneNumber.setText("phone number: " + listener.getPhoneNumber());
        lbl_birthDate.setText("birth date: " + listener.getBirthDate());

        for(PlaylistModel playlist : listener.getPlaylists()) {
            listView.getItems().add(playlist.getPlaylistName());
        }
        listView.getItems().add("+ create new playlist...");

        if(listener instanceof PremiumModel premiumModel){
            lbl_numberOfDays.setText("number of days left: " + premiumModel.getNumberOfDaysLeft());
        }
    }
}
