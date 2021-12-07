package GUI.Model;

import BE.Playlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ListModel {
    List<Playlist> songsOnPlaylists = new ArrayList<>();

    public ListModel() {
        Playlist Song1 = new Playlist (1,"Sunshine");
        Playlist Song2 = new Playlist(2,"Easy");
        Playlist Song3 = new Playlist(3,"Nachtbaden");

        songsOnPlaylists.add(Song1);
        songsOnPlaylists.add(Song2);
        songsOnPlaylists.add(Song3);
    }

    public ObservableList<Playlist> getList() {
        ObservableList<Playlist> list = FXCollections.observableArrayList();
        list.addAll(songsOnPlaylists);
        return list;
    }

}
