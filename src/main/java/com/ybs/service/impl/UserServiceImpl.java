package com.ybs.service.impl;

import com.ybs.common.util.PublicUtils;
import com.ybs.common.util.RedisUtil;
import com.ybs.mapper.UserMapper;
import com.ybs.pojo.User;
import com.ybs.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Author Paulson
 * @Date 2020/6/7
 * @Description: Service实现类
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User save(User user) {
        User u = new User();
        LocalDateTime now = LocalDateTime.now();
        if (user.getId() != null) {
            // 更新
            u = userMapper.findById(user.getId()).orElse(new User());
            BeanUtils.copyProperties(user, u, PublicUtils.getNullPropertyNames(user));
        } else {
            // 添加
            u.setCreated(now);
        }
        u.setUpdated(now);
        u.setDeleted(false);
        return userMapper.save(u);
    }

    @Override
    public User deleted(Long id) {
        User user = userMapper.findById(id).orElse(null);
        if (user == null) {
            return user;
        } else {
            user.setDeleted(true);
        }
        return userMapper.save(user);
    }

    @Override
    public User findById(Long id) {

        User user = (User) redisUtil.get("user_" + id);
        if (user != null) {
            return user;
        }
        user = userMapper.findById(id).orElse(null);
        if (user == null) {
            return user;
        }
        redisUtil.set("user_" + user.getId(), user);
        return user;
    }


}
