module view {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports view;
    opens view to javafx.fxml;
    exports view.admin;
    opens view.admin to javafx.fxml;
    exports view.stables;
    opens view.stables to javafx.fxml;
    exports view.stables.header.components;
    opens view.stables.header.components to javafx.fxml;
    exports view.stables.header.components.signup;
    opens view.stables.header.components.signup to javafx.fxml;
    exports view.stables.sidebar;
    opens view.stables.sidebar to javafx.fxml;
    exports view.stables.sidebar.components;
    opens view.stables.sidebar.components to javafx.fxml;
    exports view.stables.header;
    opens view.stables.header to javafx.fxml;
    exports view.listener;
    opens view.listener to javafx.fxml;
    exports view.listener.components;
    opens view.listener.components to javafx.fxml;
    exports view.stables.artist;
    opens view.stables.artist to javafx.fxml;
    exports view.stables.audio;
    opens view.stables.audio to javafx.fxml;
    exports view.admin.components;
    opens view.admin.components to javafx.fxml;
    exports view.artist;
    opens view.artist to javafx.fxml;
    exports view.artist.components;
    opens view.artist.components to javafx.fxml;
}