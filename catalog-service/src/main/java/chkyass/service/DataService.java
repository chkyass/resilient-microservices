package chkyass.service;

import chkyass.model.Rating;
import chkyass.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class DataService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "ratingServiceFallback")
    public List<Rating> getUserRatings(String id) {
        return restTemplate.getForObject("http://data-service:8083/ratingsdata/user/"+id, UserRating.class).getRatings();
    }

    public List<Rating> ratingServiceFallback(String id) {
        return Collections.singletonList(new Rating("Fallback MovieID", "Fallback Rating"));
    }
}
