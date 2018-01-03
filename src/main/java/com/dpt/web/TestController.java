package com.dpt.web;

import com.dpt.common.Api;
import com.dpt.mapper.UserMapper;
import com.dpt.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserMapper userMapper;

    /**
     * 根据Name获取用户信息
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "根据Name获取用户信息", notes = "根据Name获取用户信息")
    @RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserByName(@PathVariable("name") String name) throws Exception {
        try {
            User user = userMapper.getUserByName(name);
            if (user == null) {
                return name + "不存在";
            } else {
                return Api.success("操作成功。", user);
            }
        } catch (Exception e) {
            logger.error("----------------------------------ERROR");
            return Api.error(1001, "系统错误，请联系管理员。");
        }
    }

    /**
     * 根据Id获取用户信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据Id获取用户信息", notes = "根据Id获取用户信息")
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(@PathVariable("id") Integer id) throws Exception {
        try {
            User user = userMapper.getUserById(id);
            if (user == null) {
                return id + "不存在";
            } else {
                return Api.success("操作成功。", user);
            }
        } catch (Exception e) {
            logger.error("----------------------------------ERROR");
            return Api.error(1001, "系统错误，请联系管理员。");
        }
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ResponseBody
    public String getUsers() throws Exception {
        try {
            List<User> user = userMapper.getUsers();
            if (user == null) {
                return "不存在";
            } else {
                return Api.success("操作成功。", user);
            }
        } catch (Exception e) {
            logger.error("----------------------------------ERROR");
            return Api.error(1001, "系统错误，请联系管理员。");
        }
    }

    /**
     * 更新用户信息
     *
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    @RequestMapping(value = "/updateUserInfo/{id}", method = RequestMethod.PUT)
    public String updateUserInfo(@PathVariable("id") Integer id, @RequestBody User user) throws Exception {
        try {
            User u = userMapper.getUserById(id);
            u.setName(user.getName());
            u.setAge(user.getAge());
            userMapper.update(u);
            return Api.success("操作成功。", u);
        } catch (Exception e) {
            logger.error("----------------------------------ERROR");
            return Api.error(1001, "系统错误，请联系管理员。");
        }
    }

    /**
     * 创建新用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建新用户", notes = "创建新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    })
    @RequestMapping(value = "/insertUserInfo", method = RequestMethod.PUT)
    public String insertUserInfo(@RequestBody User user) throws Exception {
        try {
            User u = new User();
            u.setName(user.getName());
            u.setAge(user.getAge());
            userMapper.insert(u);
            return Api.success("操作成功。", u);
        } catch (Exception e) {
            logger.error("----------------------------------ERROR");
            return Api.error(1001, "系统错误，请联系管理员。");
        }
    }

}
