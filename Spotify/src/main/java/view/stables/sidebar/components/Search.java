package view.stables.sidebar.components;

import controller.AudioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.audio.AudioModel;
import view.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Search implements Initializable {

    @FXML
    private ImageView img_search;

    @FXML
    private MenuButton btn_filter;

    @FXML
    private MenuButton btn_sort;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField txtField;

    @FXML
    private TextField txt_filter;

    @FXML
    private AnchorPane root;

    private String filter;
    private String sort;

    @FXML
    void Date2Filter(ActionEvent event) {
        filter = "Date2";
        btn_filter.setText("two Date");
        txt_filter.setText("");
        txt_filter.setPromptText("Year/Month/Day-Year/Month/Day");
    }
    @FXML
    void DateFilter(ActionEvent event) {
        filter = "Date";
        btn_filter.setText("Date");
        txt_filter.setText("");
        txt_filter.setPromptText("Year/Month/Day");
    }
    @FXML
    void artistFilter(ActionEvent event) {
        filter = "artist";
        btn_filter.setText("Artist");
        txt_filter.setText("");
        txt_filter.setPromptText("Artist name");
    }
    @FXML
    void genreFilter(ActionEvent event) {
        filter = "genre";
        btn_filter.setText("Genre");
        txt_filter.setText("");
        txt_filter.setPromptText("Genre: Pop");
    }
    @FXML
    void noneFilter(ActionEvent event) {
        filter = "none";
        btn_filter.setText("Filter");
        txt_filter.setText("");
        txt_filter.setPromptText("Filter");
    }
    @FXML
    void noneSort(ActionEvent event) {
        btn_sort.setText("Sort");
        sort = "none";
    }
    @FXML
    void likeSort(ActionEvent event) {
        btn_sort.setText("like");
        sort = "like";
    }
    @FXML
    void playSort(ActionEvent event) {
        btn_sort.setText("Play");
        sort = "play";
    }
    @FXML
    void sort(ActionEvent event) {
        btn_sort.setText("sort");
        sort = "sort";
    }

    @FXML
    void search(MouseEvent event) {
        gridPane.getChildren().clear();
        if(txtField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter Artist name OR Audio's title in text field");
            alert.setHeaderText("Empty text field");
            alert.showAndWait();
            return;
        }
        List<AudioModel> list = AudioController.getAudioController().search(txtField.getText());
        if(list.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Nothing found!");
            alert.setContentText("nothing is not match with your search");
            alert.showAndWait();
            return;
        }

        try {
            list = filter(list);
        }catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.setHeaderText("Empty field");
            alert.showAndWait();
            return;
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter the filter correctly");
            alert.setHeaderText("invalid input");
            alert.showAndWait();
            return;
        }
        if(list.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Nothing found!");
            alert.setContentText("nothing is not match with your search");
            alert.showAndWait();
            return;
        }
        list = sort(list);
        setVBox(list);
    }
    private List<AudioModel> sort(List<AudioModel> list) {
        List<AudioModel> sorted = list;
        switch (sort){
            case "like" -> sorted = AudioController.getAudioController().likeSort(list);
            case "play" -> sorted = AudioController.getAudioController().playSort(list);
            case "sort" -> sorted = AudioController.getAudioController().sort(list);
        }
        return sorted;
    }
    private List<AudioModel> filter(List<AudioModel> list) throws Exception {
        List<AudioModel> filtered = list;
        if(txt_filter.getText().isEmpty() && !filter.equals("none"))
            throw new NullPointerException("write your filter in text field");
        switch (filter){
            case "Date2" -> {
                String[] dates = txt_filter.getText().split("_");
                String[] day1 = dates[0].split("/");
                String[] day2 = dates[1].split("/");

                filtered = AudioController.getAudioController().twoDateFilter(list,
                        LocalDate.of(Integer.parseInt(day1[0]), Integer.parseInt(day1[1]), Integer.parseInt(day1[2])),
                        LocalDate.of(Integer.parseInt(day2[0]), Integer.parseInt(day2[1]), Integer.parseInt(day2[2])));
            }
            case "Date" -> {
                String[] date = txt_filter.getText().split("/");
                filtered = AudioController.getAudioController().dateFilter(list,
                        LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
            }
            case "genre" -> {
                if(! AudioController.getAudioController().isGenre(txt_filter.getText()))
                    throw new Exception();
                filtered = AudioController.getAudioController().genreFilter(list, txt_filter.getText());
            }
            case "artist" -> filtered = AudioController.getAudioController().artistFilter(list, txt_filter.getText());
        }
        return filtered;
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
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sort = "none";
        filter = "none";
        img_search.setImage(new Image(Objects.requireNonNull(HelloApplication.class.getResource("img/header/search.png")).toExternalForm()));
        root.setBackground(Background.fill(Color.WHITE));
        gridPane.setBackground(Background.fill(Color.WHITE));
    }
}
