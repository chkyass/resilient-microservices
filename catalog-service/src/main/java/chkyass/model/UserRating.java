package chkyass.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserRating {

    private String userId;
    private List<Rating> ratings;
}
