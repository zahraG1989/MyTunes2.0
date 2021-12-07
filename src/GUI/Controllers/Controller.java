package GUI.Controllers;

import BE.Playlist;
import GUI.Model.ListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button btnDeleteSongFromPlaylist;
    public Button btnNewSong;
    public Button btnAddSong;
    public Button btnEditSongs;

    public TableColumn songTitle;
    public TableColumn artist;
    public TableColumn category;
    public TableColumn timeOfSong;

    @FXML
    private ListView<Playlist> listSongsOnPlaylist;

    public Button btnDeleteSong;
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

    private ListModel listModel;


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
    private void PlayMusic(ActionEvent actionEvent) {
        File file = new File("C:/Users/zkooh/IdeaProjects/MyTunes2.0/myTunes'songs/MyTunes/01 - Easy.mp3");
        System.out.println("file:" + file.toURI().toString());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    public Controller(){
        listModel = new ListModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listSongsOnPlaylist.getItems().setAll(listModel.getList());
    }
}
