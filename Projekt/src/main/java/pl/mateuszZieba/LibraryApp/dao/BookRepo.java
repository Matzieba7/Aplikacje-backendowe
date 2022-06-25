package pl.mateuszZieba.LibraryApp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mateuszZieba.LibraryApp.dao.entity.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
}
