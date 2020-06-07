package com.ybs.mapper;

import com.ybs.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: UserMapper
 * @Author Paulson
 * @Date 2020/6/7
 * @Description:
 */
public interface UserMapper extends JpaRepository<User, Long> {
    
}
