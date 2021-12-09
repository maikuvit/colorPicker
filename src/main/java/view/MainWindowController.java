package view;

import Memento.Caretaker;
import Memento.Color;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import observer.Observer;


public class MainWindowController extends Observer {

    @FXML
    private Button btnClose;

    @FXML
    private BorderPane contentPane;

    @FXML
    void onClose(MouseEvent event) {
        Stage stage = (Stage)(contentPane.getScene().getWindow());
        stage.close();
    }

    @FXML
    void onMinimize(MouseEvent event) {
        Stage stage = (Stage)(contentPane.getScene().getWindow());
        stage.setIconified(true);
    }

    public void setMiddleContent(Pane pane) {
        contentPane.setCenter(pane);
    }

    private void notifyChanges(Color newCol){
        contentPane.setStyle("-fx-background-color: " + newCol.getHexColor());
    }

    @Override
    public void notifyObChanges(Object changes) {
        notifyChanges((Color) changes);
    }
}

