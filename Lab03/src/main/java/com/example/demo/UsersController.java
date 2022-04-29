package com.example.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
public class UsersController {

    private static final int PAGE_NUMBER = 1;
    private static final int PAGE_SIZE = 2;

    private final List<UserEntity> users = new LinkedList<>();


    @PostConstruct
    private void Create() {
        users.add(new UserEntity(1L, "Adam", "admam1234@wsei.pl"));
        users.add(new UserEntity(2L, "Robert", "RobertJazda@joł.com"));
        users.add(new UserEntity(3L, "Karol", "marol@gmail.wsei.gov"));
    }


    @RequestMapping("/users/{id}")
    public UserEntity GetUserById(
            @PathVariable Long id
    ) {
        return users.stream()
                .filter(userEntity -> userEntity.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found: " + id));
    }


    @GetMapping("/users")
    public UsersResults GetUsers(@RequestParam(name = "page number", required = false) Integer pageNumberParam,
                           @RequestParam(name = "page size", required = false) Integer pageSizeParam) {
        int pageNumber = pageNumberParam != null ? pageNumberParam : PAGE_NUMBER;
        int pageSize = pageSizeParam != null ? pageSizeParam : PAGE_SIZE;
        int offset = (pageNumber - 1) * pageSize;
        return new UsersResults(pageNumber, users.size() / pageSize, pageSize, users.size(),
                subList(users, offset, pageSize));
    }

    public static <T> List<T> subList(List<T> it, int offset, int limit) {
        if (it == null) {
            return it;
        }
        if (it.size() <= offset) {
            return Collections.emptyList();
        }
        if (limit < 0) {
            limit = it.size();
        }
        if (offset < 0) {
            offset = 0;
        }
        limit = offset + limit > it.size() ? it.size() - offset : limit;
        return (limit == it.size() && offset == 0) ? it : it.subList(offset, offset + limit);
    }


    @DeleteMapping("/users/{id}")
    public Boolean RemoveUserById(
            @PathVariable Long id
    ) {
        UserEntity userEntity = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Not found user for given id " + id));
        return users.remove(userEntity);
    }

    //  curl -X POST -d '{"id":4, "name":"dupa", "email":"dupa@dupa.pl"}' -H 'Content-Type: application/json'  http://localhost:8080/user/create
    @PostMapping("/user/create")
    public UserEntity CreateUser(@RequestBody UserEntity userEntity){
        users.add(userEntity);
        return userEntity;

    }

}