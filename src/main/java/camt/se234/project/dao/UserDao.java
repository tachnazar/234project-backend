package camt.se234.project.dao;

import camt.se234.project.entity.User;

import java.util.List;

public interface UserDao {
    User getUser(String username, String password);
    List<User> findAll();
}
