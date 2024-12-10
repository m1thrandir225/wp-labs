package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final SongService songService;

    public AlbumController(AlbumService albumService, SongService songService) {
        this.albumService = albumService;
        this.songService = songService;
    }

    @GetMapping()
    public String listAlbums(Model model) {
        List<Album> albums = albumService.findAll();

        model.addAttribute("albums", albums);
        model.addAttribute("bodyContent", "list-albums");

        return "master-template";
    }

    @GetMapping("/new")
    public String getAddAlbum(Model model) {
        model.addAttribute("bodyContent", "add-album");
        return "master-template";
    }

    @PostMapping("/new")
    public String addAlbum(
            @RequestParam String name,
            @RequestParam String genre,
            @RequestParam String releaseYear) {
        Album album = new Album(name, genre, releaseYear);
        albumService.save(album);
        return "redirect:/songs";
    }

    @GetMapping("/{id}")
    public String getAlbumDetails(@PathVariable String id, Model model) {
        Long albumId = Long.parseLong(id);
        Album album = this.albumService.findById(albumId);

        model.addAttribute("selectedAlbum", album);
        model.addAttribute("bodyContent", "album-details");
        return "master-template";
    }
}
