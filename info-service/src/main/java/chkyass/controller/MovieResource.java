package chkyass.controller;

import chkyass.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    Logger logger = LoggerFactory.getLogger(MovieResource.class);

    @Value("${HOSTNAME: Unknown hostname}")
    private String hostname;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        logger.info("/movies/{movieId}: " + hostname);
        return new Movie(movieId, "test", "good");
    }

    @RequestMapping("/status")
    public String status() {
        return "OK";
    }

}
