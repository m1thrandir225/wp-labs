package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.models.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {
    public static List<Album> albums = null;

    AlbumRepository() {
        albums = new ArrayList<>();

        albums.add(new Album("Thriller", "Pop", "1982"));
        albums.add(new Album("Back in Black", "Rock", "1980"));
        albums.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973"));
        albums.add(new Album("The Bodyguard", "Soundtrack", "1992"));
        albums.add(new Album("Rumours", "Rock", "1977"));

    }

    public List<Album> findAll() {
        return albums;
    }

    public Album findById(Long id) {
        return albums.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
    }
}
