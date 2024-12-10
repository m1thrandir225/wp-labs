package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findById(Long id);
    List<Song> listSongsByArtistId(Long artistId);
    List<Song> listSongsByAlbumId(Long albumId);
    void saveSong(Song song);
    void updateSong(Long id, String title, String genre, String releaseYear, Album album);
    void deleteSong(Long id);
}
