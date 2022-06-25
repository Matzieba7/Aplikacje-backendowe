package pl.l.mateuszZieba.LibraryApp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.l.mateuszZieba.LibraryApp.User.User;

import java.util.List;

@Repository

public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll(){
        return jdbcTemplate.query("SELECT id, name, surname, dateOfBirth, typeID FROM user", BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getByid(int id){
        return jdbcTemplate.queryForObject("SELECT id, name, surname, dateOfBirth, typeID FROM book WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
    }


    public int save(List<User> users) {
        users.forEach(user -> jdbcTemplate
                .update("INSERT INTO user(name, surname, dateOfBirth, email, typeID) VALUES(?,?,?,?,?)",
                        user.getName(), user.getSurname(), user.getDateOfBirth(), user.getEmail(), user.getTypeID()
                ));

        return 1;
    }

    public int update(User user)
    {
        return jdbcTemplate.update("UPDATE user SET name=?, surname =?, dateOfBirth=?, email =?, typeId=? WHERE id=?",
                user.getName(), user.getSurname(), user.getDateOfBirth(), user.getEmail(), user.getTypeID());
    }

    public int delete(int id)
    {
        return jdbcTemplate.update("DELETE FROM user WHERE id=?", id);
    }
}

