package BLL;

import BE.Playlist;
import DAL.PlayListDAO;

import java.sql.SQLException;
import java.util.List;

public class PlaylistManager {
    PlayListDAO PlayListDAO;

    public PlaylistManager(){
        PlayListDAO = new PlayListDAO();
    }

    public List<Playlist> getAllPlaylist() throws SQLException { //gets playlist from database
        return PlayListDAO.getAllPlayList();
    }

    public Playlist createPlaylist (Playlist newPlaylist) throws Exception {
        if (newPlaylist.getName() != null){
            return PlayListDAO.createPlayList(newPlaylist);
        }
        throw new Exception();
    }

    public void deletePlaylist(Playlist selectedItem) {
        PlayListDAO.deletePlaylist(selectedItem);
    }
}

