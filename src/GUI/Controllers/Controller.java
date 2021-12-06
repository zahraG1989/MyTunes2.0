package GUI.Controllers;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

<<<<<<< Updated upstream
=======

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
>>>>>>> Stashed changes
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

<<<<<<< Updated upstream
public class Controller {
=======
import java.io.File;
import java.io.IOException;

public class Controller {
    public Button btnDeleteSongFromPlaylist;
    public Button btnNewSong;
    public Button btnAddSong;
    public Button btnEditSongs;
    public Button btnPlay;
    @FXML
    private Button btnNewSong;
    @FXML
    private Button btnAppClose;
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


    public void OpenNewPlaylist(MouseEvent mouseEvent) {
    }

    public void PlayMusic(ActionEvent actionEvent) {
        File file = new File("C:/Users/zkooh/IdeaProjects/MyTunes2.0/myTunes'songs/MyTunes/(Disc 2) 03 - Sunshine.mp3");
        System.out.println("file:" + file.toURI().toString());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }


}
