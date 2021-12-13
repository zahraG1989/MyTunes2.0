package GUI.Model;

import BE.Playlist;
import BLL.PlaylistManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistModel {
    PlaylistManager playlistManager;

    ObservableList<Playlist> listPlaylist;

    public PlaylistModel() throws IOException, SQLException {
        playlistManager = new PlaylistManager();
        listPlaylist = FXCollections.observableArrayList();
        setListPlaylist();
    }

    public void setListPlaylist() throws SQLException {
        listPlaylist.setAll(playlistManager.getAllPlaylist());
    }

    public ObservableList<Playlist> getListPlaylist() {
        return listPlaylist;
    }
}

