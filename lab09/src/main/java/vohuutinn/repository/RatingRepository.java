package vohuutinn.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import vohuutinn.entity.Rating;
import vohuutinn.entity.RatingId;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, RatingId> {
    List<Rating> findByIdBookId(int bookId);  // ✅ lấy tất cả rating theo book
}