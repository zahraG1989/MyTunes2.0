package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class playlistController {
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnSavePlaylist;

    public void cancelEditingPlaylist(ActionEvent actionEvent) {

        //if the user clicks on the "cancel" button in the PlaylistWindow, a window pops up that asks the user to confirm the cancellation.

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Discard changes ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        }
    }

    public void savePlaylist(ActionEvent actionEvent) {
    }
}
