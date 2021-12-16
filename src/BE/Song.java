package BE;

public class Song {
    //this class only includes the properties each song needs + getters and toString
    private int id;
    private String category;
    private String name;

    private String songFile;
    private String artist;

    public Song(int id, String name,String category,String songFile,String artist) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.songFile = songFile;
        this.artist = artist;
    }

    public String getSongFile() {
        return songFile;
    }

    public String getArtist() {
        return artist;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

