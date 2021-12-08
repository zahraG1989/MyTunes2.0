package GUI.Controllers;

import BE.Playlist;
import GUI.Model.playlistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button btnDeleteSongFromPlaylist;
    @FXML
    private  Button btnNewSong;
    @FXML
    private Button btnAddSong;
    @FXML
    private  Button btnEditSongs;

    @FXML
    private  TableColumn songTitle;
    @FXML
    private  TableColumn artist;
    @FXML
    private  TableColumn category;
    @FXML
    private  TableColumn timeOfSong;

    @FXML
    private ListView<Playlist> listSongsOnPlaylist;

    public Button btnDeleteSong;
    @FXML
    private Button btnAppClose;
    @FXML
    private Button btnPlayMusic;
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

    private playlistModel playlistModel;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to MyTunes Application!");
    }

    @FXML
    private void closeWindow(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Close the Application ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();


        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnAppClose.getScene().getWindow();
            stage.close();
        }

    }
    @FXML
    private void openNewSongWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("./GUI/Views/songTable.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("New Song");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void openNewPlaylistWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("GUI/Views/playlist.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("New/Edit Playlist");
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    private  void deletePlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private  void editPlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private  void moveSongDown(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private void moveSongUp(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private void deleteSongFromPlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private void addSongToPlaylist(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private  void editSong(ActionEvent actionEvent) {
        System.out.println("works too");
    }

    @FXML
    private void deleteSong(ActionEvent actionEvent) {
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

    @FXML
    private void playMusic(ActionEvent actionEvent) {
        File file = new File("C:/Users/zkooh/IdeaProjects/MyTunes2.0/myTunes'songs/MyTunes/01 - Easy.mp3");
        System.out.println("file:" + file.toURI().toString());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();


       // btnPlayMusic.setText("||");

    }

    public Controller(){
        playlistModel = new playlistModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listSongsOnPlaylist.getItems().setAll(playlistModel.getList());
    }
}
