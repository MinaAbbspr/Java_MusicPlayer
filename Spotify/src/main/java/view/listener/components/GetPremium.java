package view.listener.components;

import controller.userType.Listener.ListenerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Subscription;
import model.exceptions.NotEnoughBalanceException;
import model.user.type.listener.ListenerModel;
import view.View;

import java.io.IOException;

public class GetPremium {


    @FXML
    private Label lbl_days;

    @FXML
    private Label lbl_price;


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
            ListenerModel listenerModel = ListenerController.getListenerController().getPremium(subscription);
            View.getView().setUserAccount(listenerModel);
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
        setLabel();
    }

    @FXML
    void fix60(ActionEvent event) {
        subscription = Subscription.Package60Days;
        setLabel();
    }

    @FXML
    void fix180(ActionEvent event) {
        subscription = Subscription.Package180Days;
        setLabel();
    }

    private void setLabel(){
        lbl_days.setText("days: " + subscription.getDays());
        lbl_price.setText("price: $" + subscription.getFee());
    }

}