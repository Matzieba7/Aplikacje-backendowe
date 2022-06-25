package pl.mateuszZieba.LibraryApp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.mateuszZieba.LibraryApp.dao.BookRepo;
import pl.mateuszZieba.LibraryApp.dao.entity.Book;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookManager {

    private BookRepo BookRepo;

    @Autowired
    public BookManager(BookRepo videoCassetteRepo) {
        this.BookRepo = videoCassetteRepo;
    }

    public Optional<Book> findById(Long id) {
        return BookRepo.findById(id);
    }

    public Iterable<Book> findAll() {
        return BookRepo.findAll();
    }

    public Book save(Book videoCassette) {
        return BookRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        BookRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Book(1L,"Harry Potter and the Philosophers Stone", LocalDate.of(1997 , 6,26)));
        save(new Book(2L,"Pulp Fiction", LocalDate.of(1990, 2,2)));
    }

}
