package com.abc.service;

import com.abc.bean.User;

import java.util.List;

public interface UserService {
    void addUser(User user) throws Exception;

    List<User> findUserByAge(int age);

    Integer findUserCount();
}
