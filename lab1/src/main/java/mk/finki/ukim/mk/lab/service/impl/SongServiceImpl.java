package mk.finki.ukim.mk.lab.service.impl;

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
}
