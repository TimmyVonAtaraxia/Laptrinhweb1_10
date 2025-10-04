package lamvandi.service;

import lamvandi.entity.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface BookService {
    List<Book> findAll();
    Page<Book> findPaginated(int pageNo, int pageSize);
    Optional<Book> findById(int id);
    Book save(Book book);   // thêm hoặc update
    void deleteById(int id);
}