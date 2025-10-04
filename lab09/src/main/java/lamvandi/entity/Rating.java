package lamvandi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rating_23110191")
public class Rating {

    @EmbeddedId
    private RatingId id;

    @Column(name = "rating")
    private Byte rating; // ⭐ điểm số (1-5)

    @Column(name = "review_text")
    private String reviewText;

    // Getter & Setter
    public RatingId getId() {
        return id;
    }
    public void setId(RatingId id) {
        this.id = id;
    }

    public Byte getRating() {
        return rating;
    }
    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
