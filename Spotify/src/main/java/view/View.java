package view;

import controller.userType.Listener.ListenerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Database;
import model.audio.AudioModel;
import model.audio.PlaylistModel;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import view.listener.components.AddPlaylist;
import view.stables.Page;
import view.stables.artist.Report;
import view.stables.header.components.Login;
import view.stables.header.components.signup.Genre;
import view.stables.header.components.signup.Signup;

import java.io.IOException;
import java.util.Stack;

public class View {
    private static View view;
    private Stage stage;
    private UserAccountModel userAccount;
    private MediaPlayer mediaPlayer;
    private AudioModel audioModel;
    private ArtistModel artistModel;
    private boolean isLogin;
    private boolean isListener;
    private boolean isArtist;
    private boolean isPlay;
    private boolean isMainPage;
    private PlaylistModel playlist;
    private Stack<String> back;

    //singleton
    private View() {
        isLogin = false;
        isPlay = false;
        isMainPage = true;
        this.audioModel = Database.getDatabase().getAudios().getFirst();
        mediaPlayer = new MediaPlayer(new Media(audioModel.getLink()));
        back = new Stack<>();
    }
    public static View getView() {
        if(view == null)
            view = new View();
        return view;
    }

    //getter & setter
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public boolean isLogin() {
        return isLogin;
    }
    public void setLogin(boolean login) {
        isLogin = login;
    }
    public UserAccountModel getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccountModel userAccount) {
        this.userAccount = userAccount;
    }
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    public void setMediaPlayer(AudioModel audioModel) {
        this.audioModel = audioModel;
        mediaPlayer.pause();
        mediaPlayer = new MediaPlayer(new Media(audioModel.getLink()));
        if(isLogin && isListener){
            ListenerController.getListenerController().playAudio(audioModel.getID());
        }
        audioModel.setNumberOfPlays(audioModel.getNumberOfPlays()+1);
    }
    public AudioModel getAudioModel() {
        return audioModel;
    }
    public ArtistModel getArtistModel() {
        return artistModel;
    }
    public void setArtistModel(ArtistModel artistModel) {
        this.artistModel = artistModel;
    }
    public PlaylistModel getPlaylist() {
        return playlist;
    }
    public void setPlaylist(PlaylistModel playlist) {
        this.playlist = playlist;
    }
    public boolean isArtist() {
        return isArtist;
    }
    public void setArtist(boolean artist) {
        isArtist = artist;
    }
    public boolean isListener() {
        return isListener;
    }
    public void setListener(boolean listener) {
        isListener = listener;
    }
    public void setPlay(boolean play) {
        isPlay = play;
    }
    public boolean isPlay() {
        return isPlay;
    }

    //show
    public void showMainPage(String fxml) throws IOException {
        isMainPage = true;
        back.push(fxml);
        Page.setScrollFxml(fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Media Player");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void showLoginPage() throws IOException {
        Stage stage = new Stage();
        stage.initOwner(this.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setTitle("Login");

        Scene scene = new Scene(new FXMLLoader(HelloApplication.class.getResource("login.fxml")).load());
        stage.setScene(scene);
        Login.setStage(stage);
        stage.show();
    }
    public void showSignupPage() throws IOException {
        Stage stage = new Stage();
        stage.initOwner(this.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setTitle("Signup");

        Scene scene = new Scene(new FXMLLoader(HelloApplication.class.getResource("signup.fxml")).load());
        stage.setScene(scene);
        Signup.setStage(stage);
        stage.show();
    }
    public void showGenrePage() throws IOException {
        Stage stage = new Stage();
        stage.initOwner(this.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Genre");

        Scene scene = new Scene(new FXMLLoader(HelloApplication.class.getResource("genre.fxml")).load());
        stage.setScene(scene);
        Genre.setStage(stage);
        stage.show();
    }
    public void showPlayMusic() throws IOException {
        isMainPage = false;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playMusic.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Media Player");
        stage.setScene(scene);
    }
    public void showAddPlaylist() throws IOException {
        Stage stage = new Stage();
        stage.initOwner(this.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setTitle("playlist");

        Scene scene = new Scene(new FXMLLoader(HelloApplication.class.getResource("addPlaylist.fxml")).load());
        stage.setScene(scene);
        AddPlaylist.setStage(stage);
        stage.show();
    }
    public void showReport() throws IOException {
        Stage stage = new Stage();
        stage.initOwner(this.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setTitle("Report");

        Scene scene = new Scene(new FXMLLoader(HelloApplication.class.getResource("report.fxml")).load());
        stage.setScene(scene);
        Report.setStage(stage);
        stage.show();
    }
    public void stepBack() throws IOException {
        if(!back.isEmpty() && !isMainPage) {
            showMainPage(back.pop());
        }
        else if(back.size() > 1){
            back.pop();
            showMainPage(back.pop());
        }
    }

}
