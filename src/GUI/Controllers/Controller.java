package GUI.Controllers;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button btnNewSong;
    @FXML
    private Button btnAppClose;
    @FXML
    private Button btnNewPlaylist;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to MyTunes Application!");
    }

    public void closeWindow(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Close the Application ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        //comments

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnAppClose.getScene().getWindow();
            stage.close();
        }

    }
    public void openNewSongWindow(ActionEvent actionEvent) {
        System.out.println("Läuft");
    }

    public void openNewPlaylistWindow(ActionEvent actionEvent) {
        System.out.println("Läuft Auch");
    }
}