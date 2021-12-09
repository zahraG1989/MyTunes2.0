package GUI.Model;

import BE.Playlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class PlaylistModel {
    List<Playlist> playlistOne = new ArrayList<>();

    public PlaylistModel() {
        Playlist Song1 = new Playlist (1,"Sunshine");
        Playlist Song2 = new Playlist(2,"Easy");
        Playlist Song3 = new Playlist(3,"Nachtbaden");

        playlistOne.add(Song1);
        playlistOne.add(Song2);
        playlistOne.add(Song3);
    }

    public ObservableList<Playlist> getList() {
        ObservableList<Playlist> list = FXCollections.observableArrayList();
        list.addAll(playlistOne);
        return list;
    }

}
