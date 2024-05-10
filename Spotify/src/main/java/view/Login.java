package view;

import controller.userType.AdminController;
import controller.userType.Artist.type.PodcasterController;
import controller.userType.Artist.type.SingerController;
import controller.userType.Listener.ListenerController;
import controller.userType.Listener.type.FreeController;
import controller.userType.Listener.type.PremiumController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import model.exceptions.failedLogin.FailedLoginException;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private Button btn_Login;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_userName;

    @FXML
    void login(MouseEvent event) {
        try {
            String className = ListenerController.getListenerController().login(txt_userName.getText(), txt_password.getText());
            findClass(className, txt_userName.getText());
        } catch (FailedLoginException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failed Login");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("empty filed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setBackground(Background.fill(Color.rgb(225, 247, 245)));
    }

    private void findClass(String name, String username){
        switch (name) {
            case "class model.user.type.artist.type.PodcasterModel" -> {
                PodcasterController.getPodcasterController().loginArtist(username);
                //
            }
            case "class model.user.type.artist.type.SingerModel" -> {
                SingerController.getSingerController().loginArtist(username);
                //
            }
            case "class model.user.type.listener.type.FreeModel" -> {
                FreeController.getFreeController().loginListener(username);
                //
            }
            case "class model.user.type.listener.type.PremiumModel" -> {
                PremiumController.getPremiumController().loginListener(username);
                //
            }
            case "class model.user.type.AdminModel" -> {
                AdminController.getAdminController().loginAdmin(username);
                //
            }
        }
    }
}
