package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.user.UserAccountModel;

import java.io.IOException;

public class View {
    private static View view;
    private Stage stage;
    private boolean isLogin;
    private UserAccountModel userAccount;
    private boolean isListener;

    private View() {
        isLogin = false;
    }

    public static View getView() {
        if(view == null)
            view = new View();
        return view;
    }
    public Stage getStage() {
        return stage;
    }
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
    public boolean isListener() {
        return isListener;
    }

    public void showMainPage(String fxml) throws IOException {
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
}
