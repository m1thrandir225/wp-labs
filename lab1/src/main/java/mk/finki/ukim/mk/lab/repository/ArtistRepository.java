package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.models.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
     public static List<Artist> artists= null;

    ArtistRepository() {
        artists = new ArrayList<>();
        artists.add(new Artist("Katy", "Perry", "Popular American Singer and Song writer"));
        artists.add(new Artist("Lady", "Gaga", "American singer, songwriter and actress"));
        artists.add(new Artist("Bruno", "Mars", "American singer-songwriter popular for stage performances."));
        artists.add(new Artist("Michael", "Jackson", "Was an american singer, song writer dubbed as the King of Pop"));
        artists.add(new Artist("Kanye", "West", "American rapper, record producer, singer and fashion designer"));
    }

    public List<Artist> findAll() {
         return artists;
    }
    public Optional<Artist> findById(Long id) {
         return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
