package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
    List<Song> findAllByAlbum_Id(Long albumId);
    @Modifying
    @Query("update Song u set u.title = ?2, u.genre = ?3, u.releaseYear = ?4, u.album = ?5 where u.id = ?1")
    void update(Long id, String title, String genre, String releaseYear, Album album);
}