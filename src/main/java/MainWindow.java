import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(getClass().getResource("/it/maiku"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/maiku/view/mainWindow.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Scene scene = new Scene(root,1300,675);
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
