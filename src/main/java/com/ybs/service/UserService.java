package com.ybs.service;

import com.ybs.pojo.User;

import java.util.List;

/**
 * @ClassName: UserService
 * @Author Paulson
 * @Date 2020/6/7
 * @Description:
 */
public interface UserService {

    List<User> findAll();

    /**
     * 保存
     *
     * @param user
     * @return
     */
    User save(User user);

    User deleted(Long id);


    User findById(Long id);
}
