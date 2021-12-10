package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PStableDAO {
    ConnectionManager cm;
    public PStableDAO() {
        try {
            cm = new ConnectionManager();

        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public PStableDAO createIdSong(PStableDAO pstable) throws SQLException {
    PStableDAO createIdSong= null;
        try (Connection con = cm.getConnection()){
            String sqlSelectSong = "";

            }
        return null;
    }
}

