package view.stables.header;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Header implements Initializable{

    @FXML
    private Circle crl_back;

    @FXML
    private AnchorPane root;

    @FXML
    public void backTo(MouseEvent event) throws IOException {
        View.getView().stepBack();
    }

    @FXML
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
    public void signup(MouseEvent event) throws IOException {
        View.getView().showSignupPage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crl_back.setFill(new ImagePattern(new Image(Objects.requireNonNull(HelloApplication.class.getResource("img/header/left-arrow.png")).toExternalForm())));
        root.setBackground(Background.fill(Color.rgb(7, 25, 82)));
    }
}
