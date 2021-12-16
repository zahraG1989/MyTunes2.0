 package DAL;

import BE.Song;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*public class MyTunesDAO {
    ConnectionManager cm;
    public MyTunesDAO() throws IOException {
        cm = new ConnectionManager();
    }
    public void getALlSongs(){
        try (Connection con = cm.getConnection()) {
            List<Song> allSongs = new ArrayList<>();
            String sqlcommandSelect = "SELECT * FROM Songs;";

            PreparedStatement pstmtSelect = con.prepareStatement(sqlcommandSelect);
            ResultSet rs = pstmtSelect.executeQuery();
            while(rs.next())
            {

            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void createSong(String SongName){

    }
    String SQLINSERT;

}*/

