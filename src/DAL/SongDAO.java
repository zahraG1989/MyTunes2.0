package DAL;

import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SongDAO {
    ConnectionManager cm;
    public SongDAO() throws IOException {
        cm = new ConnectionManager();
    }
    public Song createSong(Song song) throws Exception {
        Song songCreated=null;
        try(Connection con = cm.getConnection()){
            String sqlSelectSong = "INSERT INTO SONGS VALUES(?,?,?,?)";
            PreparedStatement pststmtSelectSong = con.prepareStatement(sqlSelectSong, Statement.RETURN_GENERATED_KEYS);
            pststmtSelectSong.setString(1,song.getName());
            pststmtSelectSong.setString(2,song.getCategory());
           // pststmtSelectSong.setString(3,song.getSongFile());
           // pststmtSelectSong.setString(4,song.getArtist());
            pststmtSelectSong.execute();
            ResultSet rs = pststmtSelectSong.getGeneratedKeys();
            int idSong=0;
            while(rs.next()) {
                idSong = rs.getInt(1);
            }
           // songCreated = new Song(idSong ,song.getName(),song.getCategory(),song.getSongFile(),song.getArtist());

        }
        return songCreated;
    }
}

