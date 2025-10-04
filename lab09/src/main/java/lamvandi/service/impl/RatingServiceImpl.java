package lamvandi.service.impl;

import lamvandi.entity.Rating;
import lamvandi.repository.RatingRepository;
import lamvandi.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> findByBookId(int bookId) {
        return ratingRepository.findByIdBookId(bookId);
    }

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }
}