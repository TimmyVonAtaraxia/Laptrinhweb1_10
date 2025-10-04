package lamvandi.repository;


import lamvandi.entity.Rating;
import lamvandi.entity.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, RatingId> {
    List<Rating> findByIdBookId(int bookId);  // ✅ lấy tất cả rating theo book
}