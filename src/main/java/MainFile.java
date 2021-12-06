import Memento.Caretaker;
import Memento.Color;

public class MainFile {
    public static void main(String[] args) {
        MainWindow.main(args);

        Caretaker.GetInstance().setHexColor("#aaaaaa");
        Caretaker.GetInstance().setHexColor("#aaaaa2");
        Caretaker.GetInstance().undo();

        }
}
