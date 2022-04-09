package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {

    private final Map<Long, UserEntity> usersMap = new HashMap<>();

    @PostConstruct
    private void onCreate() {
        usersMap.put(1L, new UserEntity(1L, "Karol"));
        usersMap.put(2L, new UserEntity(2L, "Marek"));
        usersMap.put(3L, new UserEntity(3L, "Roman"));
    }


    @RequestMapping("/users")
    @ResponseBody
    public Object getUsers(){
        return usersMap;
    }


    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object getUserById(
            @PathVariable Long id
    ){
        return usersMap.get(id);
    }


    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object RemoveUser(
            @PathVariable Long id
    ){
        usersMap.remove(id);
        return usersMap;
    }

    //Add user
    @RequestMapping("/users/add")
    @ResponseBody
    public Object AddUser(
            @RequestParam Long id,
            @RequestParam String name
    ) {
        usersMap.put(id, new UserEntity(id, name));
        return "name of the added user: " + name;
    }
}
