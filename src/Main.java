import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/Views/mainWindow.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("MyTunes");
        stage.setScene(scene);
        stage.show();
    }

}