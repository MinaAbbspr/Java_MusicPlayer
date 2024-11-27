package view.admin.components;

import controller.user.userType.AdminController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReportPanel implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       try {
            List<String> list = AdminController.getAdminController().reportInfo();
            for (String str : list)
                listView.getItems().add(str);
       }catch (Exception e){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText("Empty list");
           alert.setContentText(e.getMessage());
           alert.show();
       }
       root.setBackground(Background.fill(Color.WHITE));
    }
}
