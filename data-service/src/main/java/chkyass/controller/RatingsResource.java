package chkyass.controller;

import chkyass.model.Rating;
import chkyass.model.UserRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
    Logger logger = LoggerFactory.getLogger(RatingsResource.class);

    @Value("${HOSTNAME: Unknown hostname}")
    private String hostname;

    @RequestMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        logger.info("/ratingsdata/movies/{movieId}: " + hostname);
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        logger.info("/ratingsdata/user/{userId}: " + hostname);
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }

    @RequestMapping("/status")
    public String status() {
        return "OK";
    }
}
