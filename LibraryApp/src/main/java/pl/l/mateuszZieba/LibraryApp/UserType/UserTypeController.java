package pl.l.mateuszZieba.LibraryApp.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userType")
public class UserTypeController {

    @Autowired
    UserTypeRepository userTypeRepository;

    @GetMapping("/")
    public List<UserType> getAll(){
        return userTypeRepository.getAll();
    }

    @GetMapping("/{id}")
    public UserType getById(@PathVariable("id") int id)
    {
        return userTypeRepository.getByid(id);
    }

    @PostMapping("")
    public int add(@RequestBody  List<UserType> userTypes){

        return userTypeRepository.save(userTypes);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody UserType updatedUserType){
        UserType userType = userTypeRepository.getByid(id);

        if(userType != null) {
            userType.setType(updatedUserType.getType());

            userTypeRepository.update(userType);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partallyUpdate(@PathVariable("id") int id, @RequestBody UserType updatedUserType){
        UserType userType = userTypeRepository.getByid(id);

        if(userType != null){
            if (updatedUserType.getType() != null) userType.setType(updatedUserType.getType());

            userTypeRepository.update(userType);

            return 1;
        } else {
            return -1;
        }
    }


    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id)
    {
        return userTypeRepository.delete(id);
    }
}

