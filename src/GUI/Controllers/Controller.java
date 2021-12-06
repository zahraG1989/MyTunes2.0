package GUI.Controllers;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

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

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnAppClose.getScene().getWindow();
            stage.close();
        }

    }
    @FXML

    public void openNewSongWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("./GUI/Views/songTable.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("New Song");
        stage.setScene(new Scene(root));
        stage.show();
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

            /* We have to adapt this method so that it actually deletes the Song.
            For now it is just closing everything. */
        }
    }


}
