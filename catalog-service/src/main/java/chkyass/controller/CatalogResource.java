package chkyass.controller;

import chkyass.model.CatalogItem;
import chkyass.model.Movie;
import chkyass.model.Rating;
import chkyass.service.DataService;
import chkyass.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@EnableCircuitBreaker
@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DataService dataService;

    @Autowired
    private InfoService infoService;

    /*@Autowired
    WebClient.Builder webClientBuilder;*/

    @RequestMapping("/{id}")
    public List<CatalogItem> getCatalog(@PathVariable("id") String id) {
        return dataService.getUserRatings(id).stream()
                .map(rating -> {
                    Movie movie = infoService.getMovieInfo(rating.getMovieId());
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());
    }

    @RequestMapping("/status")
    public String reachable() {
        return "ok";
    }
}

/*
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/