package BE;

public class Song {
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


    public void setSongFile(String songFile) {
        this.songFile = songFile;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

