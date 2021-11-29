package Memento;

import java.util.Stack;

public class Caretaker {
    private Color actualColor;
    private Stack<ColorMemento> backwardMemento;
    private Stack<ColorMemento> forwardMemento;

    //elenco de

    public String getHexColor() {
        //in lettura non ho bisogno di modificare lo stack ...
        return actualColor.getHexColor();
    }

    public void setHexColor(String hexColor) {
        actualColor.setHexColor(hexColor);
    }

}
