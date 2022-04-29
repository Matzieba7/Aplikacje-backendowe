package com.example.demo;

import java.util.List;

public class UsersResults {
    int pageNumber;
    int pagesCount;
    int pageSize;
    int totalCount;
    List<UserEntity> users;

    public UsersResults() {
    }

    public UsersResults(int pageNumber, int pagesCount, int pageSize, int totalCount, List<UserEntity> users) {
        this.pageNumber = pageNumber;
        this.pagesCount = pagesCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.users = users;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
