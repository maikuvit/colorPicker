package view;
import Memento.Caretaker;
import Memento.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import observer.Observed;
import observer.Observer;

public class slideController extends Observer {

    @FXML
    private Slider bSlide;

    @FXML
    private Slider gSlide;

    @FXML
    private Slider rSlide;

    @FXML
    private TextField rgbTxt;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnRedo;


    public slideController(){
    }

    public void sliderSetup(){
        addSliderListener(bSlide);
        addSliderListener(gSlide);
        addSliderListener(rSlide);
        rgbTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean aBoolean,
                                Boolean onFocus) {
                if(!onFocus) addnewColor();
            }
        });
    }

    private void addSliderListener(Slider slider){
        slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(
                    ObservableValue<? extends Boolean> observableValue,
                    Boolean wasChanging,
                    Boolean changing) {

                if (!changing) {
                    Caretaker.GetInstance().setHexColor(new Color((int)rSlide.getValue(),(int)gSlide.getValue(),(int)(bSlide.getValue())).getHexColor());
                }
            }
        });
    }

    @FXML
    void clickRedo(MouseEvent event) {
        Caretaker.GetInstance().redo();
    }

    @FXML
    void clickUndo(MouseEvent event) {
        Caretaker.GetInstance().undo();
    }

    @FXML
    void colorEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addnewColor();
        }
    }

    void addnewColor(){
        if (Caretaker.GetInstance().getColor().toString()
                .compareTo(rgbTxt.getText()) != 0 &&
                Caretaker.checkValid(rgbTxt.getText()))
            Caretaker.GetInstance().setHexColor(rgbTxt.getText());

        else rgbTxt.setText(Caretaker.GetInstance().getColor().getHexColor());
    }
    @Override
    public void notifyObChanges(Object changes) {
        Color newcol = (Color) changes;
        rgbTxt.setText(newcol.getHexColor());
        rSlide.setValue(newcol.getRed());
        gSlide.setValue(newcol.getGreen());
        bSlide.setValue(newcol.getBlue());
    }
}