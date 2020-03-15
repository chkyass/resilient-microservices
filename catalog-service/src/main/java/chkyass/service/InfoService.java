package chkyass.service;

import chkyass.model.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "movieInfoServiceFallback")
    public Movie getMovieInfo(String id) {
        return restTemplate.getForObject("http://info-service:8082/movies/"+id, Movie.class);
    }

    public Movie movieInfoServiceFallback(String id) {
        return new Movie(id, "Fallback name", "Fallback description");
    }
}
