package vohuutinn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vohuutinn.entity.Book;
import vohuutinn.service.BookService;

@Controller
@RequestMapping("/admin/books")
public class AdminController {

    private final BookService bookService;

    public AdminController(BookService bookService) {
        this.bookService = bookService;
    }

    // ✅ Danh sách sách trong admin (nếu muốn tách riêng với user)
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "admin-books"; // bạn có thể làm views/admin-books.jsp
    }

    // ✅ Hiển thị form thêm sách
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form"; // views/book-form.jsp
    }

    // ✅ Lưu sách (thêm + sửa)
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/products"; // sau khi lưu quay lại danh sách
    }

    // ✅ Hiển thị form sửa sách
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.findById(id)
                               .orElseThrow(() -> new RuntimeException("Không tìm thấy sách"));
        model.addAttribute("book", book);
        return "book-form"; // dùng chung form thêm/sửa
    }

    // ✅ Xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/products";
    }
}
