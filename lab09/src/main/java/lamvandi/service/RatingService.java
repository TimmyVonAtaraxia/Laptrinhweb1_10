package lamvandi.service;

import lamvandi.entity.Rating;
import java.util.List;

public interface RatingService {
    List<Rating> findByBookId(int bookId);
    Rating save(Rating rating);
}