package vohuutinn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import vohuutinn.entity.Book;

public interface BookService {
    List<Book> findAll();
    Page<Book> findPaginated(int pageNo, int pageSize);
    Optional<Book> findById(int id);
    Book save(Book book);   // thêm hoặc update
    void deleteById(int id);
}