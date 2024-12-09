package mk.finki.ukim.mk.lab.web.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.models.Artist;
import mk.finki.ukim.mk.lab.models.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public ArtistServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);
        WebContext context = new WebContext(webExchange);

        String trackId = request.getParameter("trackId");
        context.setVariable("trackId", trackId);
        List<Artist> artists = artistService.listArtists();

        context.setVariable("trackId", trackId);
        context.setVariable("artists", artists);


        springTemplateEngine.process("artistsList.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);
        WebContext context = new WebContext(webExchange);

        String trackId = request.getParameter("trackId");


        String artistId = request.getParameter("artistId");
        System.out.println("ArtistId: " + artistId + "/n");
        System.out.println("TrackId: " + trackId + "/n");
        Song selectedSong = songService.findById(Long.parseLong(trackId));
        System.out.println("selectedSong: " + selectedSong);

        Artist selectedArtist = artistService.findById(Long.parseLong(artistId));
        Artist newArtist = songService.addArtistToSong(selectedArtist, selectedSong);

        String redirectUrl = "/song?trackId=" + trackId;
        response.sendRedirect(redirectUrl);

    }
}
