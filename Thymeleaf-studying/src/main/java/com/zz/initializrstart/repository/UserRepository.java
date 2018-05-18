package com.zz.initializrstart.repository;

import com.zz.initializrstart.domain.User;

import java.util.List;

public interface UserRepository {

    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
    //获取用户列表
    List<User> listUser();
}
