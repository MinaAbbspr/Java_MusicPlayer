package view.stables.artist;

import controller.userType.Listener.ListenerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.View;

import java.io.IOException;

public class Report {

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
        if(txt_explanation.getText() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Empty Title");
            alert.setContentText("please Write Explanation for your Report");
            alert.showAndWait();
            return;
        }
        ListenerController.getListenerController().reportArtist(View.getView().getArtistModel(), title + "\n" + txt_explanation.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("making Report Completed Successfully");
        alert.showAndWait();
        stage.close();
        View.getView().showMainPage("artistInfo.fxml");
    }
}
