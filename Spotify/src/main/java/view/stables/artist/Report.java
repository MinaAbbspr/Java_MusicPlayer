package view.stables.artist;

import controller.user.userType.listener.ListenerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Report implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private TextArea txt_explanation;

    private String title = null;
    private static Stage stage;

    public static void setStage(Stage stage) {
        Report.stage = stage;
    }
    @FXML
    void childAbuse(ActionEvent event) {
        title = "Child Abuse";
    }
    @FXML
    void fakeAccount(ActionEvent event) {
        title = "Fake Account";
    }
    @FXML
    void illegalDrugs(ActionEvent event) {
        title = "Illegal Drugs";
    }
    @FXML
    void other(ActionEvent event) {
        title = "Other";
    }
    @FXML
    void personalDetails(ActionEvent event) {
        title = "Personal Details";
    }
    @FXML
    void spam(ActionEvent event) {
        title = "Spam";
    }
    @FXML
    void violence(ActionEvent event) {
        title = "Violence";
    }

    @FXML
    void report(MouseEvent event) throws IOException {
        if(title == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Empty Title");
            alert.setContentText("please choose a Title");
            alert.showAndWait();
            return;
        }
        if(txt_explanation.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Empty text field");
            alert.setContentText("please Write Explanation for your Report");
            alert.showAndWait();
            return;
        }
        ListenerController.getListenerController().reportArtist(View.getView().getArtistModel(), title + "\n" + txt_explanation.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("making Report Completed Successfully");
        alert.showAndWait();
        stage.close();
        View.getView().showMainPage("artistInfo.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root.setBackground(Background.fill(Color.rgb(202, 244, 255)));
    }
}
