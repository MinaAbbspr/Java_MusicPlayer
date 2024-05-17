package view.stables;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public interface GeneralOperations {
    void backTo (MouseEvent event) throws IOException;
    void login_logout (MouseEvent event) throws IOException;
    void signup(MouseEvent event) throws IOException;
    //void search();
}
