package view.admin;

import controller.StableController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Database;
import model.audio.AudioModel;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminPanel implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private Label lbl_artists;

    @FXML
    private Label lbl_audios;

    @FXML
    private Label lbl_reports;

    @FXML
    void artists(MouseEvent event) throws IOException {
        View.getView().setArtist(true);
        View.getView().showMainPage("allArtist_Audio.fxml");
    }

    @FXML
    void audios(MouseEvent event) throws IOException {
        View.getView().setArtist(false);
        View.getView().showMainPage("allArtist_Audio.fxml");
    }

    @FXML
    void report(MouseEvent event) throws IOException {
        View.getView().showMainPage("reportPanel.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        List<AudioModel> audios = StableController.getStableController().likeSort(Database.getDatabase().getAudios());
        for(AudioModel audioModel : audios){
            series.getData().add(new XYChart.Data<>(audioModel.getAudioName(), audioModel.getNumberOfLikes()));
        }
        barChart.getData().add(series);
    }
}
