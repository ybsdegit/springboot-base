package com.ybs.controller;

import com.ybs.common.enums.ResultEnum;
import com.ybs.common.response.Result;
import com.ybs.pojo.User;
import com.ybs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserController
 * @Author Paulson
 * @Date 2020/6/7
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Result users() {
        List<User> users = userService.findAll();
        return Result.success(users);
    }

    @GetMapping("/{id}")
    public Result user(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return Result.fail(ResultEnum.RESPONSE_NULL);
        }
        return Result.success(user);
    }

    @PostMapping("/add")
    public Result save(@RequestBody User user) {
        User save = userService.save(user);
        return Result.success(save);
    }

    @PutMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        User user = userService.deleted(id);
        if (user == null) {
            return Result.fail(ResultEnum.RESPONSE_NULL);
        }
        return Result.success(user);
    }
}
