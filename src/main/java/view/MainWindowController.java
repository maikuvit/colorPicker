package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainWindowController {

    @FXML
    private Button btnClose;

    @FXML
    void onClose(MouseEvent event) {
        System.out.println("chiudo");
    }

    @FXML
    void onMinimize(MouseEvent event) {

    }

}

