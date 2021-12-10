import BE.Playlist;
import BE.Song;
import DAL.PlayListDAO;
import DAL.SongDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOTest {
    public static void main(String[] args) throws Exception {
        //createSong();
       // getAllSongs();
        //updateSong();
        //deleteSongs();
       // createPlayList();
        getAllPlaylists();

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
        //Song song8 = new Song(1,"Kiss kiss","Pop","C:/Users/zkooh/IdeaProjects/MyTunes2.07myTunes'songs/MyTunes/Nachtbaden.mp3","Tarkan");
       /* songList.add(song);
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);
        songList.add(song5);
        songList.add(song6);
        songList.add(song7);*/
        //songList.add(song8);


        Song song1 = new Song(1,"Easy","HipHop","src/musicFiles/videoplayback","Zahra");
        Song song2 = new Song(1,"1000 Träume Weit (Tornero)","Rock","src/musicFiles/videoplayback","Zahra");
        Song song3 = new Song(1,"Hi Kids","Latin","src/musicFiles/videoplayback","Zahra");

        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

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
    public static void updateSong() throws IOException, SQLException {
        SongDAO songDAO = new SongDAO();
        Song song = new Song(32,"Kiss Kiss Kiss","Pop","c:////","Tarzan");
        songDAO.updateSong(song);
    }
    public static void deleteSongs() throws SQLException, IOException {
        SongDAO songDAO= new SongDAO();
        Song song = new Song(32,"Kiss Kiss Kiss","Pop","c:////","Tarzan");
        songDAO.deleteSong(song);
    }
    public static void createPlayList() throws SQLException {
        List<Playlist> listOfPlaylist = new ArrayList<>();
        PlayListDAO playListDAO = new PlayListDAO();
        Playlist playlist1 = new Playlist(1,"MyFirstPlaylist");
        Playlist playlist2 = new Playlist(1,"MySecondPlaylist");
        Playlist playlist3 = new Playlist(1,"MyThirdPlaylist");
        Playlist playlist4 = new Playlist(1,"MyFourthPlaylist");
        Playlist playlist5 = new Playlist(1,"MyFifthPlaylist");
        listOfPlaylist.add(playlist1);
        listOfPlaylist.add(playlist2);
        listOfPlaylist.add(playlist3);
        listOfPlaylist.add(playlist4);
        listOfPlaylist.add(playlist5);

        for (Playlist p: listOfPlaylist) {
            playListDAO.createPlayList(p);
            System.out.println("PlayList:" +p.getName()+" created.");
        }
    }
    public static void getAllPlaylists() throws SQLException {
        PlayListDAO playListDAO = new PlayListDAO();
        List<Playlist> listOfPlaylist = playListDAO.getAllPlayList();
        for (Playlist p: listOfPlaylist) {

            System.out.println("PlayList:" +p.getName());
        }

    }
}