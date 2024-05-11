package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Playbar implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Circle crl_play_pause;

    @FXML
    private ImageView img_next;

    @FXML
    private ImageView img_previus;


    @FXML
    private ImageView img_cover;

    @FXML
    private Label lbl_artistName;

    @FXML
    private Label lbl_audioName;

    @FXML
    private Label lbl_currentTime;

    @FXML
    private Label lbl_duration;

    @FXML
    private Slider slider;

    private ImagePattern play = new ImagePattern(new Image(HelloApplication.class.getResource("img/music/play.png").toExternalForm()));
    private ImagePattern pause = new ImagePattern(new Image(HelloApplication.class.getResource("img/music/pause.png").toExternalForm()));
    private Image next = new Image(HelloApplication.class.getResource("img/music/next01.png").toExternalForm());
    private Image back = new Image(HelloApplication.class.getResource("img/music/back01.png").toExternalForm());
    private static boolean is_play = false;


    @FXML
    void changeTime(MouseEvent event) {

    }

    @FXML
    void next(MouseEvent event) {

    }

    @FXML
    void play_pause(MouseEvent event) {
        if(is_play){
            //
            crl_play_pause.setFill(pause);
            is_play = false;
        }
        else {
            ///
            crl_play_pause.setFill(play);
            is_play = true;
        }
    }

    @FXML
    void previous(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_previus.setImage(back);
        img_next.setImage(next);
        if(is_play){
            lbl_audioName.setText("");
            lbl_artistName.setText("");
            slider.setMax(0);
            ///
            crl_play_pause.setFill(play);
            img_previus.setImage(back);
            img_next.setImage(next);
            ///
        }
    }
}