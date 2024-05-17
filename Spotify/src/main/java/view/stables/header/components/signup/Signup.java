package view.stables.header.components.signup;

import controller.userType.Artist.type.PodcasterController;
import controller.userType.Listener.type.FreeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.exceptions.InvalidFormatException;
import view.View;

import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {

    @FXML
    private DatePicker LDatePicker;

    @FXML
    private DatePicker PDatePicker;

    @FXML
    private DatePicker SDatePicker;

    @FXML
    private Button btn_listener;

    @FXML
    private Button btn_podcaster;

    @FXML
    private Button btn_singer;

    @FXML
    private TextField txt_Lemail;

    @FXML
    private TextField txt_Lname;

    @FXML
    private TextField txt_Lpassword;

    @FXML
    private TextField txt_LphoneNumber;

    @FXML
    private TextField txt_Lusername;

    @FXML
    private TextField txt_Pbio;

    @FXML
    private TextField txt_Pemail;

    @FXML
    private TextField txt_Pname;

    @FXML
    private TextField txt_Ppassword;

    @FXML
    private TextField txt_PphoneNumber;

    @FXML
    private TextField txt_Pusername;

    @FXML
    private TextField txt_Sbio;

    @FXML
    private TextField txt_Semail;

    @FXML
    private TextField txt_Sname;

    @FXML
    private TextField txt_Spassword;

    @FXML
    private TextField txt_SphoneNumber;

    @FXML
    private TextField txt_Susername;

    private static Stage stage;

    public static void setStage(Stage stage) {
        Signup.stage = stage;
    }

    @FXML
    void listenerSignup(MouseEvent event) {
        try {
            String answer = FreeController.getFreeController().signup(txt_Lusername.getText(), txt_Lpassword.getText(), txt_Lname.getText(),
                    txt_Lemail.getText(), txt_LphoneNumber.getText(), LDatePicker.getValue(), "null");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("successful Signup");
            alert.setContentText(answer);
            alert.showAndWait();
            stage.close();
            FreeController.getFreeController().signupListener(txt_Lusername.getText(), txt_Lpassword.getText(),
                    txt_Lname.getText(), txt_Lemail.getText(), txt_LphoneNumber.getText(), LDatePicker.getValue());
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

    @FXML
    void podcasterSignup(MouseEvent event) {
        try {
            String answer = FreeController.getFreeController().signup(txt_Pusername.getText(), txt_Ppassword.getText(), txt_Pname.getText(),
                    txt_Pemail.getText(), txt_PphoneNumber.getText(), PDatePicker.getValue(), txt_Pbio.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("successful Signup");
            alert.setContentText(answer);
            alert.showAndWait();
            stage.close();
            PodcasterController.getPodcasterController().signupArtist(txt_Pusername.getText(), txt_Ppassword.getText(), txt_Pname.getText(),
                    txt_Pemail.getText(), txt_PphoneNumber.getText(), PDatePicker.getValue(), txt_Pbio.getText());
            ///////////////////////////////////////
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
    void singerSignup(MouseEvent event) {
        try {
            String answer = FreeController.getFreeController().signup(txt_Susername.getText(), txt_Spassword.getText(), txt_Sname.getText(),
                    txt_Semail.getText(), txt_SphoneNumber.getText(), SDatePicker.getValue(), txt_Sbio.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("successful Signup");
            alert.setContentText(answer);
            alert.showAndWait();
            stage.close();
            PodcasterController.getPodcasterController().signupArtist(txt_Susername.getText(), txt_Spassword.getText(), txt_Sname.getText(),
                    txt_Semail.getText(), txt_SphoneNumber.getText(), SDatePicker.getValue(), txt_Sbio.getText());
            ///////////////////////////////////////panel
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
