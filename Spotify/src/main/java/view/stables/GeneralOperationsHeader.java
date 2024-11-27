package view.stables;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public interface GeneralOperationsHeader {
    void backTo (MouseEvent event) throws IOException;
    void login_logout (MouseEvent event) throws IOException;
    void signup(MouseEvent event) throws IOException;
}
