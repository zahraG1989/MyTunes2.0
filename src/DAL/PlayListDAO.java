package DAL;

import BE.Playlist;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListDAO {
    ConnectionManager cm;
    public PlayListDAO() {
        try {
            cm = new ConnectionManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Playlist createPlayList(Playlist playlist) throws SQLException {
        Playlist createPlayList= null;
        try(Connection con = cm.getConnection()){
            String sqlSelectSong = "INSERT INTO Playlists VALUES(?)";
            PreparedStatement pststmtInsertSong= con.prepareStatement(sqlSelectSong, Statement.RETURN_GENERATED_KEYS);
            pststmtInsertSong.setString(1, playlist.getName());
            pststmtInsertSong.execute();
            ResultSet rs = pststmtInsertSong.getGeneratedKeys();
            while (rs.next()){
                createPlayList = new Playlist(rs.getInt(1),playlist.getName());
            }
        }
        return createPlayList;

    }

    public List<Playlist> getAllPlayList() throws SQLException {
        List<Playlist> listOfplaylist= new ArrayList<>();
        try(Connection con = cm.getConnection()){
            String sqlSelectSong= "SELECT * FROM Playlists;";
            PreparedStatement pststmtmtselectSong= con.prepareStatement(sqlSelectSong);
            ResultSet rs= pststmtmtselectSong.executeQuery();
            while (rs.next()){
                Playlist playlist = new Playlist(rs.getInt("id"),
                   rs.getString("Pname"));
                listOfplaylist.add(playlist);
            }
        }
        return listOfplaylist;

    }

    public void deletePlaylist(Playlist selectedItem) {
        PlayListDAO playList = new PlayListDAO();
        try (Connection con= cm.getConnection()){
            String sqlDeletePlayList="DELETE FROM Playlists WHERE id=?;";
            PreparedStatement statementDeletePlayList= con.prepareStatement(sqlDeletePlayList);
            statementDeletePlayList.setInt(1,selectedItem.getId());
            statementDeletePlayList.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
