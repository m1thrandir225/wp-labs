package mk.finki.ukim.mk.lab.models;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Song {
    private Long id;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Album album;

    public Song(String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.id = new Random().nextLong();
        this.trackId = UUID.randomUUID().toString();
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public String getTrackId() {
        return this.trackId;
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
