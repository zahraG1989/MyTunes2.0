package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

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
        // double clicking on the "choose" button will open another window with your computer´s files
        Window window = ((Node) (actionEvent.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        actionEvent.consume();
    }

    @FXML
    private void cancelAddingSong(ActionEvent actionEvent) {
        //before canceling adding a song, user has to confirm the cancellation
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

    @FXML
    public void initialize() {

        //adds different Categories to the comboBox that the user can choose from

        boxChooseCategory.getItems().removeAll(boxChooseCategory.getItems());
        boxChooseCategory.getItems().addAll("Pop", "Rap", "Classic","Rock","Folk","Alternative","Soul","Reggae","Country");
        boxChooseCategory.getSelectionModel().select("Pop");
    }
}

