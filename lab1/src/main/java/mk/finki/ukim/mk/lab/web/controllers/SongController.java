package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.models.Album;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping()
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("songs", this.songService.listSongs());
        model.addAttribute("bodyContent", "list-songs");
        return "master-template";
    }
    @GetMapping("/{id}")
    public String getSongDetailsPage(@PathVariable String id, Model model) {
        Song song = this.songService.getById(Long.parseLong(id));
        model.addAttribute("selectedSong", song);
        model.addAttribute("bodyContent",  "song-details");
        return "master-template";
    }

    @GetMapping("/add")
    public String getAddSongPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("bodyContent", "add-song");
        model.addAttribute("albums", this.albumService.findAll());
        return "master-template";
    }

    @PostMapping("/add")
    public String saveSong(
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam String releaseYear,
            @RequestParam String albumId
    ) {
        Long longAlbumId = Long.parseLong(albumId);
        Album album = this.albumService.findById(longAlbumId);
        Song newSong = new Song(title, genre, Integer.parseInt(releaseYear), new ArrayList<Artist>(), album);
        this.songService.saveSong(newSong);

        return "redirect:/songs";
    }
//
    @GetMapping("/edit/{id}")
    public String getEditSongPage(@PathVariable Long id, Model model) {
        Song song = this.songService.getById(id);
        model.addAttribute("song", song);
        model.addAttribute("albums", this.albumService.findAll());
        model.addAttribute("bodyContent",  "edit-song");
        return "master-template";
    }
    @PostMapping("/edit/{id}")
    public String editSong(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam String releaseYear,
            @RequestParam String albumId
    ) {
        Long longAlbumId = Long.parseLong(albumId);
        Album album = this.albumService.findById(longAlbumId);
        this.songService.updateSong(id, title, genre, releaseYear, album);

        return "redirect:/songs";
    }
    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        this.songService.deleteSong(id);
        return "redirect:/songs";
    }

}
