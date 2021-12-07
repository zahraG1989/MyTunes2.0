import BE.Song;
import DAL.SongDAO;

import java.io.IOException;

public class DAOTest {
    public static void main(String[] args) throws Exception {
        createSong();
    }
    public static void createSong() throws Exception {
        SongDAO songDAO = new SongDAO();
        Song test = new Song(1,"CategoryTest","name of a song","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/(Disc 2) 03 - Sunshine","Zahra");
        songDAO.createSong(test);
    }

}
