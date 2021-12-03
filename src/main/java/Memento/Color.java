package Memento;

public class Color{
    //originator
    private String HexColor;

    public Color(){
        HexColor = "#222222";
    }

    public Color(int R, int G, int B){
        HexColor = "#";
        String toAdd = Integer.toHexString(R).toUpperCase();
        HexColor +=  toAdd.length() > 1 ? toAdd : "0" + toAdd;
        toAdd = Integer.toHexString(G).toUpperCase();
        HexColor +=  toAdd.length() > 1 ? toAdd : "0" + toAdd;
        toAdd = Integer.toHexString(B).toUpperCase();
        HexColor +=  toAdd.length() > 1 ? toAdd : "0" + toAdd;
        System.out.println(HexColor);
    }

    public Color(String hcolor){
        HexColor = hcolor;
    }

    public String getHexColor() {
        return HexColor;
    }

    public int getRed(){
        return (int) Long.parseLong(HexColor.substring(1,3),16);
    }

    public int getGreen(){
        return (int) Long.parseLong(HexColor.substring(3,5),16);
    }

    public int getBlue(){
        return (int) Long.parseLong(HexColor.substring(5,7),16);
    }

    public void setHexColor(String hexColor) {
        HexColor = hexColor;
    }

    public void restore(ColorMemento m) {
        HexColor = m.getMementoState();
    }

    public ColorMemento getMemento() {
        return new ColorMemento(HexColor);
    }

    @Override
    public String toString() {
        return "HexColor: " + HexColor;
    }
}
