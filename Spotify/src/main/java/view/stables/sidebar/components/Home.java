package view.stables.sidebar.components;

import controller.AudioController;
import controller.user.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.Database;
import model.audio.AudioModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(View.getView().isListener() && View.getView().isLogin()){
            setVBox(ListenerController.getListenerController().getSuggestion());
        }
        else{
            setVBox(AudioController.getAudioController().likeSort(Database.getDatabase().getAudios()));
        }
        gridPane.setBackground(Background.fill(Color.WHITE));
    }

    private void setVBox(List<AudioModel> list){
        int counter = 0;
        for(AudioModel audio : list){
            AudioController.getAudioController().setAudio(audio);
            try {
                gridPane.add(new FXMLLoader(HelloApplication.class.getResource("vBoxAudio.fxml")).load(),counter%4, counter++/4);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(counter == AudioController.getAudioController().getMaxLength()) break;
        }
    }
}
