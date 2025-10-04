package vohuutinn.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vohuutinn.entity.Book;
import vohuutinn.repository.BookRepository;
import vohuutinn.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public Page<Book> findPaginated(int pageNo, int pageSize) {
        return bookRepository.findAll(PageRequest.of(pageNo - 1, pageSize));
    }
    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);  // Spring Data JPA sẽ tự nhận biết thêm mới hay update
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}