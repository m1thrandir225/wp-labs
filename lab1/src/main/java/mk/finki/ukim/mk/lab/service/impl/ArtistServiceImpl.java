package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElse(null);
    }
}
