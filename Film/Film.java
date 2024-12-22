package Film;

public class Film {
    private int archiveId;
    private String name;
    private String director;
    private int time;
    private static int lastUsedId = 500;

    public Film(String name, String director, int time) {
        this.name = name;
        this.director = director;
        this.time = time;
        archiveId = lastUsedId++;
    }

    public int getArchiveId() {
        return archiveId;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Film{" +
                "archiveId=" + archiveId +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", time=" + time +
                '}';
    }

}
