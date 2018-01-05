package com.dpt.web;

import com.alibaba.fastjson.JSON;
import com.dpt.common.ApiResult;
import com.dpt.common.ResultConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("HelloController 接口")
@RestController
public class HelloController {

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return JSON.toJSONString(new ApiResult(ResultConstant.FILE_TYPE_ERROR, new Object()));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return JSON.toJSONString(new ApiResult(1,"hello world.", new Object()));
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return JSON.toJSONString(new ApiResult(1,"hi~."));
    }

}
