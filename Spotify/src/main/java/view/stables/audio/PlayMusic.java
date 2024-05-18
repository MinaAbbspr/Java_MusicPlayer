package view.stables.audio;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.Database;
import model.audio.PlaylistModel;
import model.audio.type.MusicModel;
import model.audio.type.PodcastModel;
import model.user.type.listener.ListenerModel;
import view.HelloApplication;
import view.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayMusic implements Initializable {

    @FXML
    private Circle crl_play_pause;

    @FXML
    private AnchorPane header;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private ImageView img_add;

    @FXML
    private ImageView img_cover;

    @FXML
    private ImageView img_like;

    @FXML
    private ImageView img_next;

    @FXML
    private ImageView img_previous;

    @FXML
    private Label lbl_artistName;

    @FXML
    private Label lbl_audioName;

    @FXML
    private Label lbl_currentTime;

    @FXML
    private Label lbl_date;

    @FXML
    private Label lbl_duration;

    @FXML
    private Label lbl_genre;

    @FXML
    private Label lbl_lyrics;

    @FXML
    private Slider slider;

    private final ImagePattern play = new ImagePattern(new Image(HelloApplication.class.getResource("img/music/play.png").toExternalForm()));
    private final ImagePattern pause = new ImagePattern(new Image(HelloApplication.class.getResource("img/music/pause.png").toExternalForm()));
    private final Image next = new Image(HelloApplication.class.getResource("img/music/next01.png").toExternalForm());
    private final Image back = new Image(HelloApplication.class.getResource("img/music/back01.png").toExternalForm());
    private final Image like = new Image(HelloApplication.class.getResource("img/music/like.png").toExternalForm());
    private final Image redLike = new Image(HelloApplication.class.getResource("img/music/redLike02.png").toExternalForm());
    private final Image add = new Image(HelloApplication.class.getResource("img/music/add.png").toExternalForm());
    private boolean isLike;


    @FXML
    void add(MouseEvent event) throws IOException {
        if(View.getView().isListener() && View.getView().isLogin()){
            View.getView().showAddAudioToPlaylist();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("you can't add audio to playlist");
            alert.setContentText("please Login first");
            alert.showAndWait();
        }
    }

    @FXML
    void changeTime(MouseEvent event) {
        View.getView().getMediaPlayer().seek(Duration.seconds(slider.getValue()));
    }

    @FXML
    void like(MouseEvent event) {
        if(View.getView().isListener() && View.getView().isLogin()){
            ListenerModel listener = (ListenerModel) View.getView().getUserAccount();
            if(isLike){
                listener.getAudiosLiked().remove(View.getView().getAudioModel().getID());
                img_like.setImage(like);
                isLike = false;
                int likes = View.getView().getAudioModel().getNumberOfLikes()-1;
                View.getView().getAudioModel().setNumberOfLikes(likes);
            }
            else {
                listener.getAudiosLiked().add(View.getView().getAudioModel().getID());
                img_like.setImage(redLike);
                isLike = true;
                int likes = View.getView().getAudioModel().getNumberOfLikes()+1;
                View.getView().getAudioModel().setNumberOfLikes(likes);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("you can't like");
            alert.setContentText("please Login first");
            alert.showAndWait();
        }

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
                    return;
                }
        }
        index = Database.getDatabase().getAudios().indexOf(View.getView().getAudioModel());
        index++;
        if(index == Database.getDatabase().getAudios().size())
            index = 0;
        View.getView().setMediaPlayer(Database.getDatabase().getAudios().get(index));

        playAnotherAudio();
    }

    @FXML
    void playOrPause(MouseEvent event) {
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
                    return;
                }
        }

        index = Database.getDatabase().getAudios().indexOf(View.getView().getAudioModel());
        index--;
        if(index < 0)
            index = Database.getDatabase().getAudios().size() -1;
        View.getView().setMediaPlayer(Database.getDatabase().getAudios().get(index));

        playAnotherAudio();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            header.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("header.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sidebar.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("sidebar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        crl_play_pause.setFill(pause);
        img_add.setImage(add);
        img_next.setImage(next);
        img_previous.setImage(back);
        playAnotherAudio();
    }

    private void isLikeCheck(){
        if(View.getView().isLogin() && View.getView().isListener()){
            ListenerModel listenerModel = (ListenerModel) View.getView().getUserAccount();
            for(long ID :listenerModel.getAudiosLiked())
                if(ID == View.getView().getAudioModel().getID()){
                    isLike = true;
                    img_like.setImage(redLike);
                    return;
                }
        }
        isLike = false;
        img_like.setImage(like);
    }
    private void lyricsOrCaption(){
        if(View.getView().getAudioModel() instanceof MusicModel musicModel){
            lbl_lyrics.setText(musicModel.getLyric());
        }
        else {
            PodcastModel podcastModel = (PodcastModel) View.getView().getAudioModel();
            lbl_lyrics.setText(podcastModel.getCaption());
        }
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
    private void playAnotherAudio(){
        View.getView().setPlay(true);
        crl_play_pause.setFill(pause);
        isLikeCheck();

        lyricsOrCaption();
        img_cover.setImage(new Image(View.getView().getAudioModel().getCover()));
        lbl_audioName.setText(View.getView().getAudioModel().getAudioName());
        lbl_artistName.setText(View.getView().getAudioModel().getArtistName());
        lbl_genre.setText("genre: " + View.getView().getAudioModel().getGenre());
        lbl_date.setText("date of release: " + View.getView().getAudioModel().getDateOfRelease());

        slider.setMax(View.getView().getMediaPlayer().getMedia().getDuration().toSeconds());
        View.getView().getMediaPlayer().currentTimeProperty().addListener( (observable, oldValue, newValue) -> setTime());

        View.getView().getMediaPlayer().play();
    }
}
