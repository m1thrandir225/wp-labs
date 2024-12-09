package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findFirstById(Long id);
}
