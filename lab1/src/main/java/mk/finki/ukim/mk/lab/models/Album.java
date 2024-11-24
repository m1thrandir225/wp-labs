package mk.finki.ukim.mk.lab.models;

import java.util.Random;

public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    public Album(String name, String genre, String releaseYear) {
        this.id = new Random().nextLong();
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getReleaseYear() {
        return this.releaseYear;
    }
}
