package view;

import Memento.Color;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import observer.Observer;


public class MainWindowController extends Observer {

    @FXML
    private Button btnClose;

    @FXML
    private BorderPane contentPane;

    @FXML
    void onClose(MouseEvent event) {

    }

    @FXML
    void onMinimize(MouseEvent event) {

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

