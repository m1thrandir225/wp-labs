package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
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
}
