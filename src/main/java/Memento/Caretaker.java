package Memento;

import observer.Observed;

import java.util.Stack;

public class Caretaker extends Observed {
    private Color actualColor;
    private Stack<ColorMemento> backwardMemento;
    private Stack<ColorMemento> forwardMemento;

    private static Caretaker taker;
    private Caretaker(){
        actualColor = new Color();
        backwardMemento = new Stack<ColorMemento>();
        forwardMemento = new Stack<ColorMemento>();
    }

    public static Caretaker GetInstance(){
        if(taker == null) taker = new Caretaker();
        return taker;
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
        notifyChanges(actualColor);
    }

    public Color undo(){
        if(backwardMemento.empty()) return actualColor;

        forwardMemento.add(actualColor.getMemento());
        actualColor.restore(backwardMemento.pop());
        notifyChanges(actualColor);
        return actualColor;
    }

    public Color redo(){
        if(forwardMemento.empty()) return actualColor;

        backwardMemento.add(actualColor.getMemento());
        actualColor.restore(forwardMemento.pop());
        notifyChanges(actualColor);
        return actualColor;
    }
}
