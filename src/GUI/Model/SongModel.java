package GUI.Model;

import BE.Song;
import BLL.SongManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class SongModel {
    SongManager songManager;

    ObservableList<Song> listSongs;

    public SongModel() throws IOException, SQLException {
        songManager = new SongManager();
        listSongs = FXCollections.observableArrayList();
        setListSongs();
    }

    public void setListSongs () throws SQLException {
        listSongs.setAll(songManager.getAllSongs());
    }

    public ObservableList<Song> getListSongs() {
        return listSongs;
    }

}
