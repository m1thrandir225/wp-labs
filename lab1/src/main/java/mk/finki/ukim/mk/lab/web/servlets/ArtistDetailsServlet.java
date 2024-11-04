package mk.finki.ukim.mk.lab.web.servlets;

import jakarta.servlet.ServletException;
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

@WebServlet(name="ArtistDetailsServlet", urlPatterns = "/performer")
public class ArtistDetailsServlet extends HttpServlet {
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    ArtistDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine templateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.templateEngine = templateEngine;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(request, response);
        WebContext context = new WebContext(webExchange);

        String artistId = request.getParameter("artistId");
        Artist artist = artistService.findById(Long.parseLong(artistId));
        List<Song> artistSongs = songService.listSongsByArtistId(artist);
        context.setVariable("artist", artist);
        context.setVariable("songs", artistSongs);

        templateEngine.process("artistDetails.html", context, response.getWriter());
    }
}
