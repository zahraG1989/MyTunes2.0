package GUI.Controllers;

import BE.Playlist;
import BE.Song;
import GUI.Model.PlaylistModel;
import GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button btnDeleteSongFromPlaylist;
    @FXML
    private TableView<Playlist> playlistTable;
    @FXML
    private TableView<Song> songTable;
    @FXML
    private Button btnNewSong;
    @FXML
    private Button btnAddSong;
    @FXML
    private Button btnEditSongs;
    @FXML
    private Button btnDeleteSong;
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
    private Slider volumeSlider;
    @FXML
    private Button nextSongButton;
    @FXML
    private Button previousSongButton;
    @FXML
    private ListView<Song> songOnPlayList;

    private PlaylistModel playlistModel;
    private SongModel songModel;

    MediaPlayer mediaPlayer;
    int currentSong = -1;


    public Controller() throws SQLException, IOException {
        playlistModel = new PlaylistModel();
        songModel = new SongModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpTable();
        setUpPlaylistTable();
        try {
            SongModel songModel = new SongModel();
            songTable.setItems(songModel.getListSongs());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PlaylistModel playlistModel = new PlaylistModel();
            playlistTable.setItems(playlistModel.getListPlaylist());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void playStopMusic (ActionEvent actionEvent) {
        if (mediaPlayer != null && currentSong == songTable.getSelectionModel().getSelectedIndex()) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING)
                mediaPlayer.pause();
            else if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED || mediaPlayer.getStatus() == MediaPlayer.Status.STOPPED) {
                mediaPlayer.play();
            }
        } else {
            currentSong = songTable.getSelectionModel().getFocusedIndex();
            play();
        }
    }

    @FXML
    private void playNextSong(ActionEvent actionEvent) {
        if (songTable.getSelectionModel().getSelectedIndex() != -1) {
            if (songTable.getItems().size() == currentSong + 1) {
                currentSong = 0; // If the last element of the list is reached. Restarts the counter back to 0
            } else {
                currentSong++;
            }
            play(); //Calls itself to continue playing
        }
    }

    @FXML
    private void playPreviousSong(ActionEvent actionEvent) {
        if (songTable.getSelectionModel().getSelectedIndex() != -1) {
            if (currentSong - 1 < 0) {
                currentSong = songTable.getItems().size() - 1; // If the last element of the list is reached. Restarts the counter back to 0
            } else {
                currentSong--;
            }
            play(); //Calls itself to continue playing
        }
    }

    private void play() {

        if (mediaPlayer != null) {
            stopMediaPlayer();
        }

        File file = new File(songTable.getItems().get(currentSong).getSongFile());

        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        setVolume();
        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(() -> { // On end of media checks if the next song is valid to be played.
            if (songTable.getSelectionModel().getSelectedIndex() != -1) {
                if (songTable.getItems().size() == currentSong + 1) {
                    currentSong = 0; // If the last element of the list is reached. Restarts the counter back to 0
                } else {
                    currentSong++;
                }
                play(); //Calls itself to continue playing
            } else {
                stopMediaPlayer(); //If no song is selected. Then stop the playing music.
            }
        });
    }

    private void stopMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    public void setUpTable() {
        // adds columns to tableView, PropertyValueFactory should correspond to properties in Song class

        TableColumn<Song, String> column1 = new TableColumn<>("Title");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Song, String> column2 = new TableColumn<>("Artist");
        column2.setCellValueFactory(new PropertyValueFactory<>("artist"));

        TableColumn<Song, String> column3 = new TableColumn<>("Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("category"));

        /*TableColumn<Song, String> column4 = new TableColumn<>("Time");
        column4.setCellValueFactory(new PropertyValueFactory<>("time")); */


        songTable.getColumns().add(column1);
        songTable.getColumns().add(column2);
        songTable.getColumns().add(column3);
        songTable.getItems().addAll(songModel.getListSongs());

    }

    public void setUpPlaylistTable() {
        //adds columns to PlaylistTable, PropertyValueFactory should correspond to properties in Playlist class
        TableColumn<Playlist, String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Playlist, String> column2 = new TableColumn<>("Songs");
        column2.setCellValueFactory(new PropertyValueFactory<>("id"));

       /* TableColumn<Playlist,String> column3 = new TableColumn<>("Time");
        column3.setCellValueFactory(new PropertyValueFactory<>("time"));*/

        playlistTable.getColumns().add(column1);
        // playlistTable.getColumns().add(column2);
        playlistTable.getItems().addAll(playlistModel.getListPlaylist());


    }

    @FXML
    private void closeWindow(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Close the Application ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        // when closeWindow button is clicked, confirmation window pops up -> user has to confirm if window should be closed

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) btnAppClose.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    private void openNewSongWindow(ActionEvent actionEvent) throws IOException {
        // when "new.." button under Song table is clicked, the songTable.fxml window will open
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
        //when the "new..." button under playlist table is clicked, the playlist.fxml window will open
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
    private void deletePlaylist(ActionEvent actionEvent) {
        // deletes a Playlist from database, user need to confirm first
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete the Playlist ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        playlistModel.deletePlaylist(playlistTable.getSelectionModel().getSelectedItem());
        playlistTable.getItems().remove(playlistTable.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void editPlaylist(ActionEvent actionEvent) {
    }

    @FXML
    private void moveSongDown(ActionEvent actionEvent) {
    }

    @FXML
    private void moveSongUp(ActionEvent actionEvent) {

    }

    @FXML
    private void deleteSongFromPlaylist(ActionEvent actionEvent) {
        //deletes a Song only from the selected Playlist, not from the database

        songOnPlayList.getItems().remove(songOnPlayList.getSelectionModel().getSelectedIndex());
        playlistModel.deletePlaylist(playlistTable.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void addSongToPlaylist(ActionEvent actionEvent) {
        // when button is clicked, selected song will be added to current playlist
        System.out.println(songTable.getSelectionModel().getSelectedItem());
        songOnPlayList.getItems().add(songTable.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void editSong(ActionEvent actionEvent) throws IOException {
        //opens the songTable.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("./GUI/Views/editSong.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Edit Song");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void deleteSong(ActionEvent actionEvent) {
        //deletes Song from database, before deleting the user has to confirm the action

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete the Song ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

            songModel.deleteSong(songTable.getSelectionModel().getSelectedItem());
        alert.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            System.out.println("OK chosen");
        });

        }


    public void setSound(MouseEvent mouseEvent) {
        //calls the setVolume() method in order to change the volume
        setVolume();
    }

    public void setVolume() {
        //allows the user to change the volume by using the volume slider
        mediaPlayer.setVolume(volumeSlider.getValue());
    }

}

