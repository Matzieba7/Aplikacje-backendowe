package com.example.demo;

import org.apache.catalina.User;

public class PageClass {
     private int pageNumber;
     private int pageSize;
     private UserEntity user;




    public PageClass(int pageNumber, int pageSize, UserEntity user) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.user = user;

    }




}
