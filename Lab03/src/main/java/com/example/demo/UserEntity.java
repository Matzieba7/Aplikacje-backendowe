package com.example.demo;

public class UserEntity {
    private Long id;
    private String name;
    private String email;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id) {
        this.id =id;
    }

    public String getEmail(){return this.email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}