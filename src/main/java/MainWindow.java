import Memento.Caretaker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.MainWindowController;
import view.slideController;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainWindow.fxml"));
        Parent root = loader.load();
        MainWindowController controllerMain = loader.getController();

        loader = new FXMLLoader(getClass().getResource("/fxml/slide.fxml"));
        FlowPane pane = (FlowPane) loader.load();
        slideController sldController = loader.getController();
        sldController.sliderSetup();

        controllerMain.setMiddleContent(pane);

        Caretaker.GetInstance().addObserver(sldController);
        Caretaker.GetInstance().addObserver(controllerMain); //aggiungo l'observer nell'observed

        Scene scene = new Scene(root,650,450);
        stage.setScene(scene);
        stage.setMaxWidth(1300);
        stage.setMaxHeight(675);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
