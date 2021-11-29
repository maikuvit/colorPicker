package Memento;

public class Color{
    //originator
    private String HexColor;

    public Color(){
        HexColor = "#222222";
    }

    public Color(String hcolor){
        HexColor = hcolor;
    }

    public String getHexColor() {
        return HexColor;
    }

    public void setHexColor(String hexColor) {
        HexColor = hexColor;
    }

    public void restore(ColorMemento m) {
        HexColor = m.getMementoState();
    }

    public Memento getMemento() {
        return new ColorMemento(HexColor);
    }
}
