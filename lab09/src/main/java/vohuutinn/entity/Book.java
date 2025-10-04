package vohuutinn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private Integer bookId;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "quantity")
    private Integer quantity;

    // Liên kết nhiều-tác-giả
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_author_23110191",
        joinColumns = @JoinColumn(name = "bookid"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    // ❌ Bỏ quan hệ với Rating (lấy rating bằng service riêng)
}