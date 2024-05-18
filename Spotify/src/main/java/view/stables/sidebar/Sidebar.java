package view.stables.sidebar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.user.type.AdminModel;
import view.HelloApplication;
import view.View;
import view.stables.GeneralOperationSidebar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sidebar implements Initializable, GeneralOperationSidebar {

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
    void showAllArtist(MouseEvent event) throws IOException {
        View.getView().setArtist(true);
        View.getView().showMainPage("allArtist_Audio.fxml");
    }

    @FXML
    void showAllAudios(MouseEvent event) throws IOException {
        View.getView().setArtist(false);
        View.getView().showMainPage("allArtist_Audio.fxml");
    }

    @FXML
    void showHome(MouseEvent event) throws IOException {
        View.getView().showMainPage("home.fxml");
    }

    @FXML
    void showLibrary(MouseEvent event) throws IOException {
        if(View.getView().isLogin()){
            String fxml;
            if(View.getView().isListener())
                fxml = "listenerPanel.fxml";
            else if(View.getView().getUserAccount() instanceof AdminModel){
                fxml = "";
            }
            else
                fxml = "";

            View.getView().showMainPage(fxml);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please Login first");
            alert.setHeaderText("library can't open");
            alert.showAndWait();
        }
    }

    @FXML
    @Override
    public void search(MouseEvent event) throws IOException {
        View.getView().showMainPage("search.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_home.setImage(new Image(HelloApplication.class.getResource("img/sidebar/home.png").toExternalForm()));
        img_search.setImage(new Image(HelloApplication.class.getResource("img/sidebar/search.png").toExternalForm()));
        img_library.setImage(new Image(HelloApplication.class.getResource("img/sidebar/library.png").toExternalForm()));
        img_artist.setImage(new Image(HelloApplication.class.getResource("img/sidebar/artist.png").toExternalForm()));
        img_audio.setImage(new Image(HelloApplication.class.getResource("img/sidebar/audio.png").toExternalForm()));
        root.setBackground(Background.fill(Color.rgb(238, 247, 255)));
    }
}
