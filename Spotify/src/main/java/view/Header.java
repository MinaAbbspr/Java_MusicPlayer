package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Header implements Initializable {

    @FXML
    private Label lbl_loginOrLogout;

    @FXML
    private Label lbl_signup;

    @FXML
    private AnchorPane root;

    @FXML
    void login_logout(MouseEvent event) throws IOException {
        if(View.getView().isLogin()){
            View.getView().setLogin(false);
            View.getView().showMainPage("home.fxml");
        }
        else{
            View.getView().showLoginPage();
        }
    }

    @FXML
    void signup(MouseEvent event) throws IOException {
        View.getView().showSignupPage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
