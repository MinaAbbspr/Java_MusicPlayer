package view;

import controller.AudioController;
import controller.LogoutController;
import controller.userType.Listener.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import model.audio.AudioModel;
import model.user.type.listener.ListenerModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
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
            LogoutController.getLogoutController().setSorted();
            setVBox(LogoutController.getLogoutController().getSorted());
        }
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

            if(counter == LogoutController.getLogoutController().getMaxLength()) break;
        }
    }
}
