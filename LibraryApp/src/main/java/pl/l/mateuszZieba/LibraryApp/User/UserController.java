package pl.l.mateuszZieba.LibraryApp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.l.mateuszZieba.LibraryApp.User.User;
import pl.l.mateuszZieba.LibraryApp.User.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAll(){
        return userRepository.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id)
    {
        return userRepository.getByid(id);
    }

    @PostMapping("")
    public int add(@RequestBody  List<User> users){

        return userRepository.save(users);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody User updatedUser){
        User user = userRepository.getByid(id);

        if(user != null) {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setDateOfBirth(updatedUser.getDateOfBirth());
            user.setEmail(updatedUser.getEmail());
            user.setTypeID(updatedUser.getTypeID());


            userRepository.update(user);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partallyUpdate(@PathVariable("id") int id, @RequestBody User updatedUser){
        User user = userRepository.getByid(id);

        if(user != null){
            if (updatedUser.getUsername() != null) user.setUsername(updatedUser.getUsername());
            if (updatedUser.getPassword() != null) user.setPassword(updatedUser.getPassword());
            if (updatedUser.getDateOfBirth() != null) user.setDateOfBirth(updatedUser.getDateOfBirth());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getTypeID() > 0) user.setTypeID(updatedUser.getTypeID());

            userRepository.update(user);

            return 1;
        } else {
            return -1;
        }
    }


    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id)
    {
        return userRepository.delete(id);
    }
}
