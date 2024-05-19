package view.listener;

import controller.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import model.audio.PlaylistModel;
import model.user.type.listener.type.PremiumModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel implements Initializable {

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

    @FXML
    private AnchorPane root;

    @FXML
    void getPremium(MouseEvent event) throws IOException {
        View.getView().showGetPremium();
    }

    @FXML
    void openPlaylist(MouseEvent event) throws IOException {
        String playlistName = listView.getSelectionModel().getSelectedItem();
        if(playlistName.isEmpty()){}
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
        ListenerController.getListenerController().loginListener(View.getView().getUserAccount().getUserName());
        img_right.setImage(new Image(HelloApplication.class.getResource("img/header/design1.jpg").toExternalForm()));
        img_left.setImage(new Image(HelloApplication.class.getResource("img/header/design1.jpg").toExternalForm()));
        img_between.setImage(new Image(HelloApplication.class.getResource("img/header/design2.jpg").toExternalForm()));

        lbl_name.setText("name: " + ListenerController.getListenerController().getListener().getName());
        lbl_username.setText("username: " + ListenerController.getListenerController().getListener().getUserName());
        lbl_credit.setText("credit: " + ListenerController.getListenerController().getListener().getCredit());
        lbl_email.setText("email: " + ListenerController.getListenerController().getListener().getEmail());
        lbl_phoneNumber.setText("phone number: " + ListenerController.getListenerController().getListener().getPhoneNumber());
        lbl_birthDate.setText("birth date: " + ListenerController.getListenerController().getListener().getBirthDate());

        for(PlaylistModel playlist : ListenerController.getListenerController().getListener().getPlaylists()) {
            listView.getItems().add(playlist.getPlaylistName());
        }
        listView.getItems().add("+ create new playlist...");

        if(ListenerController.getListenerController().getListener() instanceof PremiumModel premiumModel){
            lbl_numberOfDays.setText("number of days left: " + premiumModel.getNumberOfDaysLeft());
        }

        root.setBackground(Background.fill(Color.WHITE));
    }
}
