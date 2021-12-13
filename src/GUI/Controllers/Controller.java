package GUI.Controllers;

import BE.Playlist;
import BE.Song;
import GUI.Model.PlaylistModel;
import GUI.Model.SongModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable, ControllerInterface {
    @FXML
    private Button btnDeleteSongFromPlaylist;
    @FXML
    private TableView <Playlist> playlistTable;

    @FXML
    private TableView<Song> songTable;
    @FXML
    private  Button btnNewSong;
    @FXML
    private Button btnAddSong;
    @FXML
    private  Button btnEditSongs;

   // @FXML
   // private ListView<Playlist> listSongsOnPlaylist;


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
    private Label welcomeText;

    @FXML
    private Button nextSongButton;

    @FXML
    private Button previousSongButton;

    private PlaylistModel playlistModel;
    private SongModel songModel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to MyTunes Application!");
    }


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
            PlaylistModel  playlistModel = new PlaylistModel();
            playlistTable.setItems(playlistModel.getListPlaylist());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @FXML
    private void playMusic(ActionEvent actionEvent) {
        File file=null;
        if(songTable.getSelectionModel().getSelectedItem()!=null) {
            file = new File(songTable.getSelectionModel().getSelectedItem().getSongFile());
        } else {
            file = new File("C:/Users/tunay/Desktop/Songs/Mecano - Hijo de la Luna.mp3");
        }
        //File file = new File("C:/Users/tunay/Desktop/Songs/Mecano - Hijo de la Luna.mp3");
       // System.out.println("file:" + file.toURI().toString());
        System.out.println("TEST: "+file.toURI().toString());

        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @FXML
    private void playNextSong (ActionEvent actionEvent) {
        File file = new File("C:/Users/tunay/Desktop/Songs/Glass Animals - Heat Waves (Lyrics).mp3");
        System.out.println("file:" + file.toURI().toString());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @FXML
    private void playPreviousSong (ActionEvent actionEvent) {
        File file = new File("C:/Users/tunay/Desktop/Songs/Kiss Kiss (Tarkan).mp3");
        System.out.println("file:" + file.toURI().toString());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public void setUpTable(){
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
    public void setUpPlaylistTable(){
        TableColumn<Playlist,String> column1 = new TableColumn<>("Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

       /* TableColumn<Playlist,String> column2 = new TableColumn<>("Songs");
        column2.setCellValueFactory(new PropertyValueFactory<>("songs")); */

        playlistTable.getColumns().add(column1);
       // playlistTable.getColumns().add(column2);
        playlistTable.getItems().addAll(playlistModel.getListPlaylist());


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




}
