package vohuutinn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vohuutinn.entity.Rating;
import vohuutinn.repository.RatingRepository;
import vohuutinn.service.RatingService;

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