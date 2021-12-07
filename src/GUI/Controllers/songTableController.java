package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class songTableController {
    @FXML
    private Button btnChooseFile;
    @FXML
    private ComboBox boxChooseCategory;
    @FXML
    private Button btnCancelAddingSong;
    @FXML
    private Button btnSaveNewSong;

    public void chooseFile(ActionEvent actionEvent) {
    }

    @FXML
    private void cancelAddingSong(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Discard changes ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        //comments

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnCancelAddingSong.getScene().getWindow();
            stage.close();
        }
        
    }

    @FXML
    private void saveNewSong(ActionEvent actionEvent) {
    }

    @FXML
    private void chooseCategory(ActionEvent actionEvent) {
    }
}

