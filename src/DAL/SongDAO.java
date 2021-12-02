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
            String sqlSelectSong = "INSERT INTO SONGS VALUES(?,?)";
            PreparedStatement pststmtSelectSong = con.prepareStatement(sqlSelectSong, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = pststmtSelectSong.executeQuery();
            while(rs.next()){
                songCreated = new Song(rs.getInt("id"),
                                        rs.getString("Sname"),
                                        rs.getString("Categori"));
            }
        }
        return songCreated;
    }
}
