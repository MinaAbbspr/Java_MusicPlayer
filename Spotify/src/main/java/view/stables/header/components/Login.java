package view.stables.header.components;

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
import javafx.stage.Stage;
import model.exceptions.failedLogin.FailedLoginException;
import model.user.UserAccountModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;
import model.user.type.listener.ListenerModel;
import model.user.type.listener.type.PremiumModel;
import view.View;

import java.io.IOException;
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

    private static Stage stage;

    public static void setStage(Stage stage) {
        Login.stage = stage;
    }

    @FXML
    void login(MouseEvent event) throws IOException {
        try {
            UserAccountModel userAccount = ListenerController.getListenerController().login(txt_userName.getText(), txt_password.getText());
            View.getView().setLogin(true);
            View.getView().setUserAccount(userAccount);
            findClass(userAccount, txt_userName.getText());
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

    private void findClass(UserAccountModel user, String username) throws IOException {
        View.getView().setLogin(true);
        stage.close();
        if(user instanceof PodcasterModel){
            PodcasterController.getPodcasterController().loginArtist(username);
            //
        }
        else if(user instanceof SingerModel){
            SingerController.getSingerController().loginArtist(username);
            //
        }
        else if(user instanceof PremiumModel){
            PremiumController.getPremiumController().loginListener(username);
            View.getView().setListener(true);
            View.getView().showMainPage("listenerPanel.fxml");
        }
        else if(user instanceof ListenerModel){
            FreeController.getFreeController().loginListener(username);
            View.getView().setListener(true);
            View.getView().showMainPage("listenerPanel.fxml");
        }
        else {
            AdminController.getAdminController().loginAdmin(username);
            //
        }
    }
}
