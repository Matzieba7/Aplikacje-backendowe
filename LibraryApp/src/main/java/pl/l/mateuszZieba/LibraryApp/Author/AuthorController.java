package pl.l.mateuszZieba.LibraryApp.Author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.l.mateuszZieba.LibraryApp.Author.Author;
import pl.l.mateuszZieba.LibraryApp.Author.AuthorRepository;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable("id") int id)
    {
        return authorRepository.getByid(id);
    }

    @PostMapping("")
    public int add(@RequestBody  List<Author> authors){
        return authorRepository.save(authors);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Author updatedAuthor){
        Author author = authorRepository.getByid(id);

        if(author != null) {
            author.setName(updatedAuthor.getName());

            authorRepository.update(author);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partallyUpdate(@PathVariable("id") int id, @RequestBody Author updatedAuthor){
        Author author = authorRepository.getByid(id);

        if(author != null){
            if (updatedAuthor.getName() != null) author.setName(updatedAuthor.getName());

            authorRepository.update(author);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id)
    {
        return authorRepository.delete(id);
    }
}

