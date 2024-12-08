package mk.finki.ukim.mk.lab.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "relase_year", nullable = false)
    private Integer releaseYear;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "artist_songs",
            joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id")
    )
    private List<Artist> performers;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Song() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }
    public String getReleaseYear() {
        return String.valueOf(this.releaseYear);
    }
    public List<Artist> getPerformers() {
        return this.performers;
    }

    public Album getAlbum() {
        return this.album;
    }

    public Long getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setPerformers(List<Artist> performers) {
        this.performers = performers;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void addPerformer(Artist performer) {
        this.performers.add(performer);
    }
}
