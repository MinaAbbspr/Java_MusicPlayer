package view.stables.audio;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.Database;
import model.audio.PlaylistModel;
import model.user.type.listener.ListenerModel;
import view.HelloApplication;
import view.View;

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
    private ImageView img_previous;


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


    @FXML
    void changeTime(MouseEvent event) {
        View.getView().getMediaPlayer().seek(Duration.seconds(slider.getValue()));
    }

    @FXML
    void next(MouseEvent event) {
        int index;
        if(View.getView().isListener() && View.getView().isLogin()){
            ListenerModel listener = (ListenerModel) View.getView().getUserAccount();
            for (PlaylistModel playlistModel : listener.getPlaylists())
                if(playlistModel.getAudioList().contains(View.getView().getAudioModel())){
                    index = playlistModel.getAudioList().indexOf(View.getView().getAudioModel());
                    index++;
                    if(index == playlistModel.getAudioList().size())
                        index = 0;
                    View.getView().setMediaPlayer(playlistModel.getAudioList().get(index));
                    playAnotherAudio();
                    crl_play_pause.setFill(pause);
                    View.getView().setPlay(true);
                    View.getView().getMediaPlayer().play();
                    return;
                }
        }
        index = Database.getDatabase().getAudios().indexOf(View.getView().getAudioModel());
        index++;
        if(index == Database.getDatabase().getAudios().size())
            index = 0;
        View.getView().setMediaPlayer(Database.getDatabase().getAudios().get(index));

        playAnotherAudio();
        crl_play_pause.setFill(pause);
        View.getView().setPlay(true);
        View.getView().getMediaPlayer().play();
    }

    @FXML
    void play_pause(MouseEvent event) {
        if(View.getView().isPlay()){
            View.getView().getMediaPlayer().pause();
            crl_play_pause.setFill(play);
            View.getView().setPlay(false);
        }
        else {
            View.getView().getMediaPlayer().play();
            crl_play_pause.setFill(pause);
            View.getView().setPlay(true);
        }
    }

    @FXML
    void previous(MouseEvent event) {
        int index;
        if(View.getView().isListener() && View.getView().isLogin()){
            ListenerModel listener = (ListenerModel) View.getView().getUserAccount();
            for (PlaylistModel playlistModel : listener.getPlaylists())
                if(playlistModel.getAudioList().contains(View.getView().getAudioModel())){
                    index = playlistModel.getAudioList().indexOf(View.getView().getAudioModel());
                    index--;
                    if(index < 0)
                        index = playlistModel.getAudioList().size() -1;
                    View.getView().setMediaPlayer(playlistModel.getAudioList().get(index));
                    playAnotherAudio();
                    crl_play_pause.setFill(pause);
                    View.getView().setPlay(true);
                    View.getView().getMediaPlayer().play();
                    return;
                }
        }

        index = Database.getDatabase().getAudios().indexOf(View.getView().getAudioModel());
        index--;
        if(index < 0)
            index = Database.getDatabase().getAudios().size() -1;
        View.getView().setMediaPlayer(Database.getDatabase().getAudios().get(index));

        playAnotherAudio();
        crl_play_pause.setFill(pause);
        View.getView().setPlay(true);
        View.getView().getMediaPlayer().play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img_previous.setImage(back);
        img_next.setImage(next);

        if(View.getView().isPlay()){
            crl_play_pause.setFill(pause);

        }else {
            crl_play_pause.setFill(play);
        }

        playAnotherAudio();
    }

    private void setTime(){
        Duration currentTime = View.getView().getMediaPlayer().getCurrentTime();
        int minutes = (int) currentTime.toMinutes();
        int second = (int) currentTime.toSeconds() % 60;
        lbl_currentTime.setText(String.format("%02d : %02d" , minutes , second));
        minutes = (int) View.getView().getMediaPlayer().getTotalDuration().subtract(currentTime).toMinutes();
        second = (int) View.getView().getMediaPlayer().getTotalDuration().subtract(currentTime).toSeconds() % 60;
        lbl_duration.setText(String.format("%02d : %02d" , minutes , second));
        slider.setMax(View.getView().getMediaPlayer().getTotalDuration().toSeconds());
        slider.setValue(View.getView().getMediaPlayer().getCurrentTime().toSeconds());
    }
    private void playAnotherAudio() {
        img_cover.setImage(new Image(View.getView().getAudioModel().getCover()));
        lbl_audioName.setText(View.getView().getAudioModel().getAudioName());
        lbl_artistName.setText(View.getView().getAudioModel().getArtistName());
        slider.setMax(View.getView().getMediaPlayer().getMedia().getDuration().toSeconds());
        View.getView().getMediaPlayer().currentTimeProperty().addListener( (observable, oldValue, newValue) ->{
            setTime();
        });
    }
}