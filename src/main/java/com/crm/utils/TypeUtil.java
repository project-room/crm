package com.crm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12.
 */
public class TypeUtil {
    public static Map<String, Object> map() {
        return new HashMap();
    }

    public static Map<String, Object> successMap(){
        Map map = TypeUtil.map();
        map.put("code", "0");
        map.put("msg", "success");
        return map;
    }
}
