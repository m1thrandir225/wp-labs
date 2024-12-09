package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist findById(Long id);
    Artist save(Artist artist);
}
