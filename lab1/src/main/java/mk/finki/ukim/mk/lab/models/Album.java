package mk.finki.ukim.mk.lab.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Random;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "genre")
    private String genre;

    @Column(name = "release_year", nullable = false)
    private String releaseYear;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album() {
    }

    public Album(String name, String genre, String releaseYear) {
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
