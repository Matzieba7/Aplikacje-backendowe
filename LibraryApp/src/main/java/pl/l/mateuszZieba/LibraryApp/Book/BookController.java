package pl.l.mateuszZieba.LibraryApp.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.l.mateuszZieba.LibraryApp.Author.Author;
import pl.l.mateuszZieba.LibraryApp.Author.AuthorRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") int id)
    {
        return bookRepository.getByid(id);
    }

    @PostMapping("")
    public int add(@RequestBody  List<Book> books){

        return bookRepository.save(books);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Book updatedBook){
        Book book = bookRepository.getByid(id);

        if(book != null) {
            book.setName(updatedBook.getName());
            book.setAuthorID(updatedBook.getAuthorID());
            book.setDateOfIssue(updatedBook.getDateOfIssue());

            bookRepository.update(book);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partallyUpdate(@PathVariable("id") int id, @RequestBody Book updatedBook){
        Book book = bookRepository.getByid(id);

        if(book != null){
            if (updatedBook.getName() != null) book.setName(updatedBook.getName());
            if (updatedBook.getAuthorID() > 0) book.setAuthorID(updatedBook.getAuthorID());
            if (updatedBook.getDateOfIssue() != null) book.setDateOfIssue(updatedBook.getDateOfIssue());

            bookRepository.update(book);

            return 1;
        } else {
            return -1;
        }
    }


    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id)
    {
        return bookRepository.delete(id);
    }
}
