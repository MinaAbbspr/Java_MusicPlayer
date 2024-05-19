package view.artist.components;

import controller.userType.Artist.ArtistController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class followers implements Initializable {
    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<String> list = ArtistController.getArtistController().showFollowers();
            for(String str : list){
                listView.getItems().add(str);
            }
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Empty list");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
