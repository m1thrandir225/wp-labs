package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
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
        Album album = this.albumService.findById(Long.parseLong(id));
        model.addAttribute("selectedAlbum", album);
        model.addAttribute("bodyContent", "album-details");
        return "master-template";
    }
}
