package com.dpt.web;

import com.dpt.mapper.UserMapper;
import com.dpt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/user/{userName}")
    @ResponseBody
    public String user(@PathVariable("userName") String userName) {
        User user = userMapper.findUserByName(userName);
        if (user == null) return userName + "不存在";
        else return user.getName() + "年龄：" + user.getAge();
    }

}
