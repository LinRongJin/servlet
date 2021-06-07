package com.example.servletDemo.dao;

import com.example.servletDemo.entity.User;

import java.util.List;

public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void delete(User user);
    public User selectByUsername(String username);
    public List<User> selecteAll();
    public List<User> selectUser(User user);
    public List<User> getTotal(int start , int num);
}
