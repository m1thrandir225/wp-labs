package mk.finki.ukim.mk.lab.models;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class Song {
    String trackId;
    String title;
    String genre;
    int releaseYear;
    List<Artist> performers;

    public Song(String title, String genre, int releaseYear, List<Artist> performers) {
        this.trackId = UUID.randomUUID().toString();
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }
    public List<Artist> getPerformers() {
        return performers;
    }

    public void addPerformer(Artist performer) {
        this.performers.add(performer);
    }
}
