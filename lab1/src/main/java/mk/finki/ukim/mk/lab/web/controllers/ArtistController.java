package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final SongService songService;
    private final ArtistService artistService;

    public ArtistController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;

    }
    @GetMapping
    public String getArtists(Model model) {
        model.addAttribute("bodyContent", "artist-list");
        return "master-template";
    }

    @GetMapping("/new")
    public String getAddArtist(Model model) {
        model.addAttribute("bodyContent", "add-artist");
        return "master-template";
    }

    @PostMapping("/new")
    public String saveArtist(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String biography, Model model) {
        Artist artist = new Artist(firstName, lastName, biography);
        artistService.save(artist);
        return "redirect:/artist/" + artist.getId();
    }

    @GetMapping("/song")
    public String getArtistListToAddToSong(@RequestParam String trackId, Model model) {
        model.addAttribute("trackId", trackId);
        model.addAttribute("artists", artistService.listArtists());
        model.addAttribute("bodyContent", "artist-list");
        return "master-template";
    }

    @GetMapping("/{id}")
    public String getArtistDetailsPage(@PathVariable Long id, Model model) {
        Artist artist = artistService.findById(id);
        List<Song> artistSongs = songService.listSongsByArtistId(artist.getId());

        model.addAttribute("artist", artist);
        model.addAttribute("songs", artistSongs);
        model.addAttribute("bodyContent", "artist-details");

        return "master-template";
    }

    @PostMapping("/song")
    public String addArtistToSong(
            @RequestParam String trackId,
            @RequestParam String artistId,
            Model model
    ) {
        Song selected = songService.findById(Long.parseLong(trackId));
        Artist selectedArtist = artistService.findById(Long.parseLong(artistId));
        songService.addArtistToSong(selectedArtist, selected);

        model.addAttribute("trackId", trackId);

        return "redirect:/songs/" + selected.getId();
    }
}
