package BE;

public class Playlist {
    //this class only contains the properties each Playlist needs + getters and toString
    private int id;
    private String name;
    private int songs;


    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
