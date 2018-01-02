package com.dpt.web;

import com.alibaba.fastjson.JSON;
import com.dpt.mapper.UserMapper;
import com.dpt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserByName(@PathVariable("name") String name) {
        User user = userMapper.getUserByName(name);
        if (user == null) {
            return name + "不存在";
        } else {
            return JSON.toJSONString(user);
        }
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(@PathVariable("id") Integer id) {
        User user = userMapper.getUserById(id);
        if (user == null) {
            return id + "不存在";
        } else {
            return JSON.toJSONString(user);
        }
    }
}
