package view.listener.components;

import controller.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.audio.PlaylistModel;
import model.exceptions.FreeAccountLimitException;
import model.user.type.listener.ListenerModel;
import view.View;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAudioToPlaylist implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private AnchorPane root;

    private static Stage stage;

    public static void setStage(Stage stage) {
        AddAudioToPlaylist.stage = stage;
    }

    @FXML
    void select(MouseEvent event) {
        String playlistName = listView.getSelectionModel().getSelectedItem();
        if(!playlistName.isEmpty()) {
            try {
                ListenerController.getListenerController().addAudioToPlaylist(playlistName,View.getView().getAudioModel());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Audio added to playlist successfully");
                alert.showAndWait();
            } catch (FreeAccountLimitException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setHeaderText("Free Account Limit");
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(e.getMessage());
                alert.setHeaderText("Repeated Audio");
                alert.showAndWait();
            }
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ListenerModel listener = (ListenerModel) View.getView().getUserAccount();
        for(PlaylistModel playlist : listener.getPlaylists()) {
            listView.getItems().add(playlist.getPlaylistName());
        }
    }
}
