package view.artist.components;

import controller.userType.Artist.ArtistController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import model.audio.AudioModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Statistics implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        List<AudioModel> audios = ArtistController.getArtistController().getAudios();
        for(AudioModel audioModel : audios){
            series.getData().add(new XYChart.Data<>(audioModel.getAudioName(), audioModel.getNumberOfPlays()));
        }
        barChart.getData().add(series);
    }
}
