package view;

import controller.userType.Listener.type.FreeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Genre implements Initializable {

    @FXML
    private Button btn_submit;

    @FXML
    private CheckBox checkB_country;

    @FXML
    private CheckBox checkB_hipHop;

    @FXML
    private CheckBox checkB_history;

    @FXML
    private CheckBox checkB_interView;

    @FXML
    private CheckBox checkB_jazz;

    @FXML
    private CheckBox checkB_pop;

    @FXML
    private CheckBox checkB_rock;

    @FXML
    private CheckBox checkB_society;

    @FXML
    private CheckBox checkB_trueCrime;

    private static Stage stage;

    public static void setStage(Stage stage) {
        Genre.stage = stage;
    }

    @FXML
    void submitGenres(MouseEvent event) {
        ArrayList<String> genres = new ArrayList<>();
        if(checkB_rock.isSelected()){
            genres.add("Rock");
        }
        if(checkB_pop.isSelected()){
            genres.add("Pop");
        }
        if(checkB_jazz.isSelected()){
            genres.add("Jazz");
        }
        if(checkB_hipHop.isSelected()){
            genres.add("HipHop");
        }
        if(checkB_country.isSelected()){
            genres.add("Country");
        }
        if(checkB_trueCrime.isSelected()){
            genres.add("TrueCrime");
        }
        if(checkB_society.isSelected()){
            genres.add("Society");
        }
        if(checkB_interView.isSelected()){
            genres.add("InterView");
        }
        if(checkB_history.isSelected()){
            genres.add("History");
        }

        if(genres.size() > 4){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Beyond the limit");
            alert.setContentText("You can choose up to four genres");
            alert.showAndWait();
            return;
        }

        FreeController.getFreeController().addGenre(genres);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("successful Submit");
        alert.setContentText("Genres saved successfully");
        alert.showAndWait();
        stage.close();
        /////////////listener Panel
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
