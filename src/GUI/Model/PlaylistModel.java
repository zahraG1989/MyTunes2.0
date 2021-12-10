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
        Playlist Song4 = new Playlist(4,"Big Bamboo");

        playlistOne.add(Song1);
        playlistOne.add(Song2);
        playlistOne.add(Song3);
        playlistOne.add(Song4);

    }

    public ObservableList<Playlist> getList() {
        ObservableList<Playlist> list = FXCollections.observableArrayList();
        list.addAll(playlistOne);
        return list;
    }

}
