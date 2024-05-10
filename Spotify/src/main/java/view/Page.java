package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Page implements Initializable {

    @FXML
    private AnchorPane header;

    @FXML
    private AnchorPane playbar;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private ScrollPane scrollPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            header.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("header.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            playbar.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("playbar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sidebar.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("sidebar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
