package view.stables.header;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import view.HelloApplication;
import view.View;
import view.stables.GeneralOperations;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Header implements Initializable, GeneralOperations {

    @FXML
    private Circle crl_back;

    @FXML
    private Label lbl_loginOrLogout;

    @FXML
    private Label lbl_signup;

    @FXML
    private AnchorPane root;

    @FXML
    @Override
    public void backTo(MouseEvent event) throws IOException {
        View.getView().stepBack();
    }

    @FXML
    @Override
    public void login_logout(MouseEvent event) throws IOException {
        if(View.getView().isLogin()){
            View.getView().setLogin(false);
            View.getView().showMainPage("home.fxml");
        }
        else{
            View.getView().showLoginPage();
        }
    }

    @FXML
    @Override
    public void signup(MouseEvent event) throws IOException {
        View.getView().showSignupPage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crl_back.setFill(new ImagePattern(new Image(HelloApplication.class.getResource("img/header/back2.png").toExternalForm())));
    }
}
