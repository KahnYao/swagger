package com.dpt.web;

import com.alibaba.fastjson.JSON;
import com.dpt.entity.UserInfo;
import com.dpt.mapper.UserInfoMapper;
import com.dpt.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("HelloController 接口")
@RestController
public class UserInfoController {

//    @Autowired
//    UserInfoMapper userInfoMapper;


    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String index() {
        return "Hello World";

//        List<UserInfo> userInfos = userInfoMapper.findAll();
//        System.out.println("\n\n\n\n\n");
//        System.out.println("输出结果：" + JSON.toJSONString(userInfos.get(0)));
//        System.out.println("输出结果：" + JSON.toJSONString(userInfos));
//        System.out.println("\n\n\n\n\n");

//        return JSON.toJSONString(userInfos);

    }

}
