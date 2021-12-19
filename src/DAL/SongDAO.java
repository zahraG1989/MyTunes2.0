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
    //Insert values to the Songs table.
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
    //Select everything from Song table.
    public List<Song> getAllSongs () throws SQLException {
        List<Song> songList = new ArrayList<>();
        try(Connection con= cm.getConnection()) {
            String sqlSelectSong= "SELECT * FROM Songs;";
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

    //Update songs from database.
    public void updateSong(Song song) throws SQLException {
    try(Connection con= cm.getConnection()){
        String sqlUpdateSong= "UPDATE Songs SET Sname=?, Categori=?, songFile=?,artist=? WHERE ID=?;";
        PreparedStatement pststmtUpdateSong= con.prepareStatement(sqlUpdateSong,Statement.RETURN_GENERATED_KEYS);
        pststmtUpdateSong.setString(1,song.getName());
        pststmtUpdateSong.setString(2,song.getCategory());
        pststmtUpdateSong.setString(3,song.getSongFile());
        pststmtUpdateSong.setString(4,song.getArtist());
        pststmtUpdateSong.setInt(5,song.getId());
        pststmtUpdateSong.executeUpdate();
        ResultSet rs = pststmtUpdateSong.getGeneratedKeys();
    }
    }
    //Delete songs from database,can re undo it from DAOTest.
    public void deleteSong(Song song) throws SQLException {
        try(Connection con = cm.getConnection()){
            String sqlDeleteSong= "DELETE FROM Songs WHERE ID=?;";
            PreparedStatement pststmtDeleteSong= con.prepareStatement(sqlDeleteSong,Statement.RETURN_GENERATED_KEYS);
            pststmtDeleteSong.setInt(1,song.getId());
            pststmtDeleteSong.execute();
          //  ResultSet rs = pststmtDeleteSong.getGeneratedKeys();
        }


    }

}