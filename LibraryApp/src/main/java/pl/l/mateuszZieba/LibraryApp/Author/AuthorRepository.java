package pl.l.mateuszZieba.LibraryApp.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class AuthorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> getAll(){
        return jdbcTemplate.query("SELECT id, name FROM author", BeanPropertyRowMapper.newInstance(Author.class));
    }

    public Author getByid(int id){
        return jdbcTemplate.queryForObject("SELECT id, name FROM author WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(Author.class), id);
    }


    public int save(List<Author> authors) {
        authors.forEach(author -> jdbcTemplate
                .update("INSERT INTO author(name) VALUES(?)",
                        author.getName()
                ));

        return 1;
    }

    public int update(Author author)
    {
        return jdbcTemplate.update("UPDATE author SET name=? WHERE id=?",
                author.getName(), author.getId());
    }

    public int delete(int id)
    {
        return jdbcTemplate.update("DELETE FROM author WHERE id=?", id);
    }
}

