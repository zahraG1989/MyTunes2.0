import BE.Song;
import DAL.SongDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOTest {
    public static void main(String[] args) throws Exception {
        //createSong();
       // getAllSongs();
    }
    public static void createSong() throws Exception {
        SongDAO songDAO = new SongDAO();

        List<Song> songList = new ArrayList<>();
        /*Song song = new Song(1,"Sunshine","POP","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/(Disc 2) 03 - Sunshine.mp3","Zahra");
        Song song1 = new Song(1,"Easy","HipHop","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/Easy.mp3","Zahra");
        Song song2 = new Song(1,"1000 Träume Weit (Tornero)","Rock","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/1000 Träume Weit (Tornero).mp3","Zahra");
        Song song3 = new Song(1,"Hi Kids","Latin","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/02 - Hi Kids.mp3","Zahra");
        Song song4 = new Song(1,"These Days","Folk","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/06 These Days.mp3","Zahra");
        Song song5 = new Song(1,"Big bamboo","Epic","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/07 - Big bamboo.mp3","Zahra");
        Song song6 = new Song(1,"Spur 8","Classic","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/08 Spur 8.mp3","Zahra");
        Song song7 = new Song(1,"Walk","Jazz","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/11 Walk.mp3","Zahra");*/
        Song song8 = new Song(1,"Kiss kiss","Pop","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/Nachtbaden.mp3","Tarkan");
       /* songList.add(song);
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);
        songList.add(song5);
        songList.add(song6);
        songList.add(song7);*/
        songList.add(song8);
        for (Song mySong: songList) {
            System.out.println("song name: "+mySong.getName()+" Artist: "+mySong.getArtist());
             songDAO.createSong(mySong);
        }

    }
    public static void getAllSongs() throws IOException, SQLException {
        SongDAO songDAO = new SongDAO();
        List<Song> songList = songDAO.getAllSongs();
        for (Song song: songList) {
            System.out.println("Song name: "+song.getName()+" Artist: "+song.getArtist()+" category: "+song.getCategory());
        }
    }
}