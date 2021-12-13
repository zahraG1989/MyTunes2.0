package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class playlistController {
    public Button btnCancel;
    public Button btnSavePlaylist;

    public void cancelEditingPlaylist(ActionEvent actionEvent) {
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
