package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private List<Song> songs = null;

    SongRepository() {
        Album album1 = new Album("Teenage Dream", "Pop", "2010");
        Album album2 = new Album("Born This Way", "Pop", "2011");
        Album album3 = new Album("Future Pop Hits", "Pop", "2024");
        Album album4 = new Album("Michael", "Pop", "2011");
        Album album5 = new Album("Graduation", "Rap", "2007");

        songs = new ArrayList<>();
        songs.add(new Song(
                "Firework",
                "Pop",
                2010,
                new ArrayList<Artist>(),
                album1
        ));
        songs.add(new Song(
                "Judas",
                "Pop",
                2011,
                new ArrayList<Artist>(),
                album2
        ));
        songs.add(new Song(
                "APT",
                "Pop",
                2024,
                new ArrayList<Artist>(),
                album3
        ));
        songs.add(new Song(
                "Hollywood Tonight",
                "Pop",
                2011,
                new ArrayList<Artist>(),
                album3
        ));
        songs.add(new Song(
                "Stronger",
                "Rap",
                2007,
                new ArrayList<Artist>(),
                album4
        ));
    }

    public List<Song> findAll() {
        return songs;
    }

    public Song findById(Long id) {
        return songs.stream().filter(song -> song.getId().equals(id)).findFirst().orElse(null);
    }

    public Song save(Song song) {
        songs.add(song);
        return song;
    }

    public Optional<Song> findByTrackId(String trackId) {
        return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        for (Song match : songs) {
            if (match.getTrackId().equals(song.getTrackId())) {
                match.addPerformer(artist);
            }
        }
        return artist;
    }

    public List<Song> getSongsByArtist(Artist artist) {
        List<Song> songsByArtist = new ArrayList<>();
        for (Song song : songs) {
            List<Artist> songPerformers = song.getPerformers();
            if (songPerformers.contains(artist)) {
                songsByArtist.add(song);
            }
        }
        return songsByArtist;
    }

    public Song update(Long id, String title, String genre, String releaseYear, Album album) {
        Song song = findById(id);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(Integer.parseInt(releaseYear));
        song.setAlbum(album);

        return song;
    }

    public void delete(Long id) {
        Song song = findById(id);

        songs.remove(song);
    }
}
