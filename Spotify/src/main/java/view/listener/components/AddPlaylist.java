package view.listener.components;

import controller.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.exceptions.FreeAccountLimitException;
import view.View;

public class AddPlaylist {

    @FXML
    private Button btn_add;

    @FXML
    private TextField txt_name;

    private static Stage stage;

    public static void setStage(Stage stage) {

        AddPlaylist.stage = stage;
    }

    @FXML
    void addPlaylist(MouseEvent event) {
        try {
            ListenerController.getListenerController().makePlaylist(txt_name.getText());
            stage.close();
            View.getView().showMainPage("listenerPanel.fxml");
        } catch (FreeAccountLimitException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Free Account Limit");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("change playlist's name");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
