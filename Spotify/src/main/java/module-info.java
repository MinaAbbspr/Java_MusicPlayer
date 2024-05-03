module org.example.spotify {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.spotify to javafx.fxml;
    exports org.example.spotify;
}