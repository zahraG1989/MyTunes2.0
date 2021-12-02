package BE;

public class Song {
    private int id;
    private String category;
    private String name;

    public Song(int id, String category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
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
