package view.listener.components;

import controller.userType.Listener.ListenerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Subscription;
import model.exceptions.NotEnoughBalanceException;
import view.View;

import java.io.IOException;

public class GetPremium {

    @FXML
    private MenuItem itm_30days;

    @FXML
    private MenuItem itm_60days;

    @FXML
    private MenuItem itm_180days;

    @FXML
    private Label lbl_days;

    @FXML
    private Label lbl_price;

    @FXML
    private MenuButton packageMenu;

    private Subscription subscription = null;
    private static Stage stage;

    public static void setStage(Stage stage) {
        GetPremium.stage = stage;
    }

    @FXML
    void buy(MouseEvent event) throws IOException {
        if(subscription == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("you can't buy nothing!");
            alert.setContentText("choose a package premium first");
            alert.showAndWait();
            return;
        }
        try {
            ListenerController.getListenerController().getPremium(subscription);
        } catch (NotEnoughBalanceException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        stage.close();
        View.getView().showMainPage("listenerPanel.fxml");
    }

    @FXML
    void fix30(ActionEvent event) {
        subscription = Subscription.Package30Days;
    }

    @FXML
    void fix60(ActionEvent event) {
        subscription = Subscription.Package60Days;
    }

    @FXML
    void fix180(ActionEvent event) {
        subscription = Subscription.Package180Days;
    }

    private void setLabel(){
        lbl_days.setText("days: " + subscription.getDays());
        lbl_price.setText("price: $" + subscription.getFee());
    }

}