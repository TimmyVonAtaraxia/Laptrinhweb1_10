package vohuutinn.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import vohuutinn.entity.Book;
import vohuutinn.entity.Rating;
import vohuutinn.entity.RatingId;
import vohuutinn.entity.User;
import vohuutinn.service.BookService;
import vohuutinn.service.RatingService;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final RatingService ratingService;

    public BookController(BookService bookService, RatingService ratingService) {
        this.bookService = bookService;
        this.ratingService = ratingService;
    }

    // ✅ Danh sách sách
    @GetMapping("/products")
    public String listBooks(Model model,
                            @RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int size) {

        // Trừ 1 khi gọi service, vì Pageable index bắt đầu từ 0
        Page<Book> bookPage = bookService.findPaginated(page, size);

        model.addAttribute("books", bookPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookPage.getTotalPages());

        return "products"; // views/products.jsp
    }
    // ✅ Chi tiết 1 cuốn sách
    @GetMapping("/books/{id}")
    public String detailBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id)
                               .orElseThrow(() -> new RuntimeException("Không tìm thấy sách"));

        List<Rating> ratings = ratingService.findByBookId(id);

        model.addAttribute("book", book);
        model.addAttribute("ratings", ratings);
        model.addAttribute("reviewCount", ratings.size());

        return "book-detail"; // views/book-detail.jsp
    }

    // ✅ Thêm review/rating
    @PostMapping("/books/{id}/rating")
    public String addRating(@PathVariable("id") int id,
                            @RequestParam("rating") Byte rating,
                            @RequestParam("reviewText") String reviewText,
                            HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        Rating r = new Rating();
        RatingId rid = new RatingId();
        rid.setUserId(user.getId());
        rid.setBookId(id);

        r.setId(rid);
        r.setRating(rating);
        r.setReviewText(reviewText);

        ratingService.save(r);
        return "redirect:/books/" + id;
    }
}
