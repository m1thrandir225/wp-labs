package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAll();
    Album findById(Long Id);
}
