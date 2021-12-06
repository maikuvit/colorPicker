package view;
import Memento.Caretaker;
import Memento.Color;
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

    public void sliderSetup(){
        addSliderListener(bSlide);
        addSliderListener(gSlide);
        addSliderListener(rSlide);
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
}