package view.stables.header.components.signup;

import controller.user.userType.artist.type.PodcasterController;
import controller.user.userType.listener.ListenerController;
import controller.user.userType.listener.type.FreeController;
import exceptions.InvalidFormatException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;

import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {

    @FXML
    private DatePicker DatePicker;

    @FXML
    private Label lbl_bio;

    @FXML
    private Label lbl_password;

    @FXML
    private TextField txt_bio;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_phoneNumber;

    @FXML
    private TextField txt_username;

    @FXML
    private AnchorPane root;

    private String signupType = null;

    private static Stage stage;

    public static void setStage(Stage stage) {
        Signup.stage = stage;
    }

    @FXML
    void signup(MouseEvent event) {
        switch (signupType){
            case "listener" -> listenerSignup();
            case "singer" -> singerSignup();
            case "podcaster" -> podcasterSignup();
            case null ->{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Failed Signup");
                alert.setContentText("choose Listener, Singer or Podcaster");
                alert.showAndWait();
            }
            default -> throw new IllegalStateException("Unexpected value: " + signupType);
        }
    }
    private void listenerSignup() {
        try {
            String answer = FreeController.getFreeController().signup(txt_username.getText(), txt_password.getText(), txt_name.getText(),
                    txt_email.getText(), txt_phoneNumber.getText(), DatePicker.getValue(), "null");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("successful Signup");
            alert.setContentText(answer);
            alert.showAndWait();
            stage.close();
            FreeController.getFreeController().signupListener(txt_username.getText(), txt_password.getText(),
                    txt_name.getText(), txt_email.getText(), txt_phoneNumber.getText(), DatePicker.getValue());
            View.getView().showGenrePage();
        } catch (InvalidFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failed Signup");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("empty filed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    private void podcasterSignup() {
        try {
            String answer = FreeController.getFreeController().signup(txt_username.getText(), txt_password.getText(), txt_name.getText(),
                    txt_email.getText(), txt_phoneNumber.getText(), DatePicker.getValue(), txt_bio.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("successful Signup");
            alert.setContentText(answer);
            alert.showAndWait();
            stage.close();
            PodcasterController.getPodcasterController().signupArtist(txt_username.getText(), txt_password.getText(), txt_name.getText(),
                    txt_email.getText(), txt_phoneNumber.getText(), DatePicker.getValue(), txt_bio.getText());
            View.getView().showMainPage("home.fxml");
        } catch (InvalidFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failed Signup");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("empty filed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    private void singerSignup() {
        try {
            String answer = FreeController.getFreeController().signup(txt_username.getText(), txt_password.getText(), txt_name.getText(),
                    txt_email.getText(), txt_phoneNumber.getText(), DatePicker.getValue(), txt_bio.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("successful Signup");
            alert.setContentText(answer);
            alert.showAndWait();
            stage.close();
            PodcasterController.getPodcasterController().signupArtist(txt_username.getText(), txt_password.getText(), txt_name.getText(),
                    txt_email.getText(), txt_phoneNumber.getText(), DatePicker.getValue(), txt_bio.getText());
            View.getView().showMainPage("home.fxml");
        } catch (InvalidFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failed Signup");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("empty filed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void checkPassword(KeyEvent event) {
        int score = ListenerController.getListenerController().checkPassword(txt_password.getText());

        switch (score) {
            case 1 -> {
                lbl_password.setText("Very Weak");
                lbl_password.setTextFill(Color.RED);
            }
            case 2, 3 -> {
                lbl_password.setText("Weak");
                lbl_password.setTextFill(Color.ORANGE);
            }
            case 4 -> {
                lbl_password.setText("Good");
                lbl_password.setTextFill(Color.YELLOWGREEN);
            }
            case 5 -> {
                lbl_password.setText("Strong");
                lbl_password.setTextFill(Color.GREEN);
            }
        }

    }

    @FXML
    void listener(MouseEvent event) {
        signupType = "listener";
        txt_bio.setVisible(false);
        lbl_bio.setVisible(false);
    }

    @FXML
    void podcaster(MouseEvent event) {
        signupType = "podcaster";
        txt_bio.setVisible(true);
        lbl_bio.setVisible(true);
    }

    @FXML
    void singer(MouseEvent event) {
        signupType = "singer";
        txt_bio.setVisible(true);
        lbl_bio.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setBackground(Background.fill(Color.rgb(202, 244, 255)));
    }
}
