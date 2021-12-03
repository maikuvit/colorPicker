package view;
import Memento.Caretaker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class slideController {

    @FXML
    private Slider bSlide;

    @FXML
    private Slider gSlide;

    @FXML
    private Slider rSlide;

    @FXML
    private TextField rgbTxt;

    public slideController(){
        System.out.println("created slider");
    }
}

