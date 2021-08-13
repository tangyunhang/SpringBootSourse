package com.abc.dao;

import com.abc.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    void insertUser(User user);

    List<User> selectUsersByAge(int age);

    Integer selectUserCount();
}
