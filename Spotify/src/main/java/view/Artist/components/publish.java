package view.artist.components;

import controller.userType.Artist.ArtistController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Publish {

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

    @FXML
    private TextArea txt_cover;

    @FXML
    private TextArea txt_link;

    @FXML
    private TextArea txt_lyrics;

    @FXML
    private TextField txt_name;

    private String genre;

    @FXML
    void publish(MouseEvent event) {
        if(txt_name.getText().isEmpty() || txt_link.getText().isEmpty() || txt_cover.getText().isEmpty() || txt_lyrics.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Empty Field");
            alert.setContentText("write all information");
            alert.showAndWait();
            return;
        }

        try {
            if(!checkGenre()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Exceed the Limit");
                alert.setContentText("You can choose one genre");
                alert.showAndWait();
                return;
            }
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Empty Field");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }
        ArtistController.getArtistController().publishing(txt_name.getText(),genre,txt_lyrics.getText(),txt_link.getText(),txt_cover.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Successfully");
        alert.setContentText("Audio Published Successfully");
        alert.showAndWait();
    }

    private boolean checkGenre(){
        int counter = 0;
        if(checkB_rock.isSelected()){
            genre = "Rock";
            counter++;
        }
        if(checkB_pop.isSelected()){
            genre = "Pop";
            counter++;
        }
        if(checkB_jazz.isSelected()){
            genre = "Jazz";
            counter ++;
        }
        if(checkB_hipHop.isSelected()){
            genre = "HipHop";
            counter ++;
        }
        if(checkB_country.isSelected()){
            genre = "Country";
            counter ++;
        }
        if(checkB_trueCrime.isSelected()){
            genre = "TrueCrime";
            counter ++;
        }
        if(checkB_society.isSelected()){
            genre = "Society";
            counter ++;
        }
        if(checkB_interView.isSelected()){
            genre = "InterView";
            counter ++;
        }
        if(checkB_history.isSelected()){
            genre = "History";
            counter ++;
        }

        if(counter == 0)
            throw new NullPointerException("Choose one Genre");

        return counter == 1;
    }

}
