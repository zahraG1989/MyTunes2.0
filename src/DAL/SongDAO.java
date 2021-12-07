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
            String sqlSelectSong = "INSERT INTO SONGS VALUES(?,?)";
            PreparedStatement pststmtSelectSong = con.prepareStatement(sqlSelectSong, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = pststmtSelectSong.executeQuery();
            while(rs.next()){
                songCreated = new Song(rs.getInt("id"),
                                        rs.getString("Sname"),
                                        rs.getString("Categori"),
                                        rs.getString("songFile"),
                                        rs.getString("artist")
                        );

            pststmtSelectSong.setString(1,song.getName());
            pststmtSelectSong.setString(2,song.getCategory());
            pststmtSelectSong.setString(3,song.getSongFile());
            pststmtSelectSong.setString(4,song.getArtist());
            pststmtSelectSong.execute();

            int idSong=0;
            while(rs.next()) {
                idSong = rs.getInt(1);

            }
        }
        return songCreated;
        }
    }
    public List<Song> getAllSongs () throws SQLException {
        List<Song> songList = new ArrayList<>();
        try(Connection con= cm.getConnection()) {
            String sqlSelectSong= "SELECT * FROM SONGS";
            PreparedStatement pststmtmtselectSong = con.prepareStatement(sqlSelectSong,Statement.RETURN_GENERATED_KEYS);
            pststmtmtselectSong.execute();
            ResultSet rs = pststmtmtselectSong.getGeneratedKeys();
            int idSong=0;
            while (rs.next()){
                idSong = rs.getInt(1);
            }

        }

        return null;
    }
}
