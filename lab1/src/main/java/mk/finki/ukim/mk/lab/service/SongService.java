package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findTrackId(String trackId);
    public List<Song> listSongsByArtistId(Artist artist);
    public Song saveSong(Song song);
    public Song getById(Long id);
    public Song updateSong(Long id, String title, String genre, String releaseYear, Album album);
    public void deleteSong(Long id);
}
