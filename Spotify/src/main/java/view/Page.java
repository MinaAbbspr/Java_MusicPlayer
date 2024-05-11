package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Page implements Initializable {
    private static String scrollFxml;

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


    public static void setScrollFxml(String scrollFxml) {
        Page.scrollFxml = scrollFxml;
    }

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
        try {
            scrollPane.setContent(new FXMLLoader(HelloApplication.class.getResource(scrollFxml)).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
