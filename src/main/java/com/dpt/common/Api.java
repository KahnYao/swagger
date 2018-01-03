package com.dpt.common;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class Api {

    /**
     *
     * @param string
     * @param object
     * @return
     */
    public static String success(String string, Object object) {
        HashMap map = new HashMap();
        map.put("code", 0);
        map.put("message", string);
        map.put("data", object);
        return JSON.toJSONString(map);
    }

    /**
     *
     * @param code
     * @param string
     * @return
     */
    public static String error(Integer code, String string) {
        HashMap map = new HashMap();
        map.put("code", code);
        map.put("message", string);
        map.put("data", "");
        return JSON.toJSONString(map);
    }

}
