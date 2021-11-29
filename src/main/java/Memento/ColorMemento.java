package Memento;

public class ColorMemento implements Memento{

    private String hexColor; //il mio state ...

    public ColorMemento(String color){
        this.hexColor = color;
    }

    public String getMementoState(){
        return hexColor;
    }

}
