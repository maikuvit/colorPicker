package Memento;

import java.util.Stack;

public class Caretaker {
    private Color actualColor;
    private Stack<ColorMemento> backwardMemento;
    private Stack<ColorMemento> forwardMemento;

    public Caretaker(){
        backwardMemento = new Stack<>();
        forwardMemento = new Stack<>();
    }
    public Color getColor() {
        //in lettura non ho bisogno di modificare lo stack ...
        return actualColor;
    }

    public void setHexColor(String hexColor) {
        if(actualColor == null)actualColor = new Color(hexColor);
        else backwardMemento.add(actualColor.getMemento());
        actualColor.setHexColor(hexColor);
        forwardMemento.clear();
    }

    public Color undo(){
        if(backwardMemento.empty()) return actualColor;

        forwardMemento.add(actualColor.getMemento());
        actualColor.restore(backwardMemento.pop());
        return actualColor;
    }

    public Color redo(){
        if(forwardMemento.empty()) return actualColor;

        backwardMemento.add(actualColor.getMemento());
        actualColor.restore(forwardMemento.pop());
        return actualColor;
    }

}
