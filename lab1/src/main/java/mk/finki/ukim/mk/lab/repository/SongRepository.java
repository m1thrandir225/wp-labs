package mk.finki.ukim.mk.lab.repository;

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
        songs = new ArrayList<>();
        songs.add(new Song(
                "Firework",
                "Pop",
                2010,
                new ArrayList<Artist>()
        ));
          songs.add(new Song(
                "Judas",
                "Pop",
                2010,
                new ArrayList<Artist>()
        ));
            songs.add(new Song(
                "APT",
                "Pop",
                2010,
                new ArrayList<Artist>()
        ));
              songs.add(new Song(
                "Hollywood Tonight",
                "Pop",
                2010,
                new ArrayList<Artist>()
        ));
                songs.add(new Song(
                "Stronger",
                "Rap",
                2010,
                new ArrayList<Artist>()
        ));
    }

    public List<Song> findAll() {
        return songs;
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
        return artist; //?? zosto
    }
}
