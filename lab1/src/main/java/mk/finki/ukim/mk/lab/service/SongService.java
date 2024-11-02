package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findTrackId(String trackId);
}
