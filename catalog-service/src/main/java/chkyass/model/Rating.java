package chkyass.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rating {

    private String movieId;
    private String rating;

    public Rating(String movieId, String rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

}
