package pl.mateuszZieba.LibraryApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mateuszZieba.LibraryApp.dao.entity.Book;
import pl.mateuszZieba.LibraryApp.manager.BookManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/Books")
public class BookApi {


    private BookManager Book;

    @Autowired
    public BookApi(BookManager videoCassettes) {
        this.Book = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return Book.findAll();
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long index) {
        return Book.findById(index);
    }

    @PostMapping
    public Book addVideo(@RequestBody Book videoCassette) {
        return Book.save(videoCassette);
    }

    @PutMapping
    public Book updateVideo(@RequestBody Book videoCassette) {
        return Book.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        Book.deleteById(index);
    }
}
