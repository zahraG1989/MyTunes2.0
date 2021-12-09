package BLL;

import BE.Song;
import DAL.SongDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SongManager {
    SongDAO songDAO;

    public SongManager() throws IOException {
        songDAO = new SongDAO();
    }

    public List<Song> getAllSongs() throws SQLException {
        return songDAO.getAllSongs();
    }

    public Song CreateSong(Song newSong) throws Exception {
        if (newSong.getName() != null){
            return songDAO.createSong(newSong);
        }
        throw new Exception();
    }
}
