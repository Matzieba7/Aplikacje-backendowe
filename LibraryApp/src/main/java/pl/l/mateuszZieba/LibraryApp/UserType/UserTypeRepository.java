package pl.l.mateuszZieba.LibraryApp.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.l.mateuszZieba.LibraryApp.UserType.UserType;

import java.util.List;

@Repository

public class UserTypeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserType> getAll(){
        return jdbcTemplate.query("SELECT id, type FROM userType", BeanPropertyRowMapper.newInstance(UserType.class));
    }

    public UserType getByid(int id){
        return jdbcTemplate.queryForObject("SELECT id, type FROM userType WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(UserType.class), id);
    }


    public int save(List<UserType> userTypes) {
        userTypes.forEach(userType -> jdbcTemplate
                .update("INSERT INTO userType(type) VALUES(?)",
                        userType.getType()
                ));

        return 1;
    }

    public int update(UserType userType)
    {
        return jdbcTemplate.update("UPDATE userType SET type =? WHERE id=?",
                userType.getType());
    }

    public int delete(int id)
    {
        return jdbcTemplate.update("DELETE FROM userType WHERE id=?", id);
    }
}


