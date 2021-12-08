package DAL;

import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {
    ConnectionManager cm;
    public SongDAO() throws IOException {
        cm = new ConnectionManager();
    }
    public Song createSong(Song song) throws Exception {
        Song songCreated=null;
        try(Connection con = cm.getConnection()){
            String sqlSelectSong = "INSERT INTO SONGS VALUES(?,?,?,?)";
            PreparedStatement pststmtInsertSong = con.prepareStatement(sqlSelectSong, Statement.RETURN_GENERATED_KEYS);

            pststmtInsertSong.setString(1,song.getName());
            pststmtInsertSong.setString(2,song.getCategory());
            pststmtInsertSong.setString(3,song.getSongFile());
            pststmtInsertSong.setString(4,song.getArtist());
            pststmtInsertSong.execute();
            ResultSet rs = pststmtInsertSong.getGeneratedKeys();
            while(rs.next()){
                songCreated = new Song(rs.getInt(1),
                        song.getName(),
                        song.getCategory(),
                        song.getSongFile(),
                        song.getArtist()
                );
            }
            return songCreated;
        }
    }
    public List<Song> getAllSongs () throws SQLException {
        List<Song> songList = new ArrayList<>();
        try(Connection con= cm.getConnection()) {
            String sqlSelectSong= "SELECT * FROM SONGS;";
            PreparedStatement pststmtmtselectSong = con.prepareStatement(sqlSelectSong);

            ResultSet rs = pststmtmtselectSong.executeQuery();

            while (rs.next()){
                        Song song = new Song(rs.getInt("id"),
                        rs.getString("Sname"),
                        rs.getString("Categori"),
                        rs.getString("songFile"),
                        rs.getString("artist"));

                        songList.add(song);
            }

        }

        return songList;
    }
    public void updateSong(Song song) {

    }
    public void deleteSong(Song song){

    }

}