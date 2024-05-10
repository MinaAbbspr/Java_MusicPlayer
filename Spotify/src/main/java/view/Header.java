package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Header implements Initializable {

    @FXML
    private Label lbl_loginOrLogout;

    @FXML
    private Label lbl_signup;

    @FXML
    private AnchorPane root;

    private static boolean isLogin = false;

    public static boolean isIsLogin() {
        return isLogin;
    }

    @FXML
    void login_logout(MouseEvent event) {

    }

    @FXML
    void signup(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isLogin = false;
    }
}
