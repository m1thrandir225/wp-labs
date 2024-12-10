package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        Song savedSong = songRepository.findById(song.getId()).orElseThrow(() -> new IllegalArgumentException("Song not found"));
        savedSong.getPerformers().add(artist);
        songRepository.save(savedSong);
        return artist;
    }


    @Override
    public List<Song> listSongsByArtistId(Long artistId) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        return artist.getSongs();
    }

    public List<Song> listSongsByAlbumId(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateSong(Long id, String title, String genre, String releaseYear, Album album) {
        songRepository.update(id, title, genre, releaseYear, album);
    }

    @Override
    public void deleteSong(Long id) {
        Song song = songRepository.findById(id).orElseThrow(() -> new RuntimeException("Song not found"));
        songRepository.delete(song);
    }
}
