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
    public Button btnDeleteSongFromPlaylist;
    public Button btnNewSong;
    public Button btnAddSong;
    public Button btnEditSongs;
    @FXML
    private Button btnDeleteSong;
    @FXML
    private Button btnAppClose;
    @FXML
    private Button btnNewPlaylist;
    @FXML
    private Button btnDeletePlaylist; 
    @FXML
    private Button btnEditPlaylist;
    @FXML
    private Button btnMoveSongDown;
    @FXML
    private Button btnMoveSongUp;
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
        System.out.println("Works");
    }

    public void openNewPlaylistWindow(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void deletePlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void editPlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void moveSongDown(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void moveSongUp(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void deleteSongFromPlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void addSongToPlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void editSong(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    public void deleteSong(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete the Song ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        //comments

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnDeleteSong.getScene().getWindow();
            stage.close();
        }
    }
}
