package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
       return this.albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return this.albumRepository.findFirstById(id);
    }

    @Override
    public Album save(Album album) {
        return this.albumRepository.save(album);
    }
}
