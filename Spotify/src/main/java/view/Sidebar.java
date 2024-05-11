package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sidebar implements Initializable {

    @FXML
    private ImageView img_artist;

    @FXML
    private ImageView img_audio;

    @FXML
    private ImageView img_home;

    @FXML
    private ImageView img_library;

    @FXML
    private ImageView img_search;

    @FXML
    private HBox root;

    @FXML
    private VBox vBox_artist;

    @FXML
    private VBox vBox_audio;

    @FXML
    private VBox vBox_home;

    @FXML
    private VBox vBox_library;

    @FXML
    private VBox vBox_search;

    @FXML
    void showAllArtist(MouseEvent event) {

    }

    @FXML
    void showAllAudios(MouseEvent event) {

    }

    @FXML
    void showHome(MouseEvent event) throws IOException {
        View.getView().showMainPage("home.fxml");
    }

    @FXML
    void showLibrary(MouseEvent event) {

    }

    @FXML
    void showSearch(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_home.setImage(new Image(HelloApplication.class.getResource("img/sidebar/home.png").toExternalForm()));
        img_search.setImage(new Image(HelloApplication.class.getResource("img/sidebar/search.png").toExternalForm()));
        img_library.setImage(new Image(HelloApplication.class.getResource("img/sidebar/library.png").toExternalForm()));
        img_artist.setImage(new Image(HelloApplication.class.getResource("img/sidebar/artist.png").toExternalForm()));
        img_audio.setImage(new Image(HelloApplication.class.getResource("img/sidebar/audio.png").toExternalForm()));
    }
}
