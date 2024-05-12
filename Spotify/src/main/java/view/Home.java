package view;

import controller.AudioController;
import controller.LogoutController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import model.audio.AudioModel;

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
            //suggestion
        }
        else{
            LogoutController.getLogoutController().setSorted();
            setVBox(LogoutController.getLogoutController().getSorted());
        }
    }

    private void setVBox(List<AudioModel> list){
        int counter = 0;
        for(AudioModel audio : list){
            AudioController.getAudioController().setAudio(audio);
            try {
                gridPane.add(new FXMLLoader(HelloApplication.class.getResource("vBoxHome.fxml")).load(),counter%4, counter++/4);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(counter == LogoutController.getLogoutController().getMaxLength()) break;
        }
    }
}
