package vohuutinn.service;

import java.util.List;

import vohuutinn.entity.Rating;

public interface RatingService {
    List<Rating> findByBookId(int bookId);
    Rating save(Rating rating);
}