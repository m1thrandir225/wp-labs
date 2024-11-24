package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findTrackId(String trackId) {
        System.out.println("findTrackId: " + trackId);
        Optional<Song> song = songRepository.findByTrackId(trackId);
        return song.orElse(null);
    }

    @Override
    public List<Song> listSongsByArtistId(Artist artist) {
        System.out.println("listSongsByArtistId: " + artist.getId());
        return songRepository.getSongsByArtist(artist);
    }

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song getById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song updateSong(Long id, String title, String genre, String releaseYear, Album album) {
        return songRepository.update(id, title, genre, releaseYear, album);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.delete(id);
    }
}
