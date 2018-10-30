package com.shop.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Lizhengyuan on 18-10-30
 */
public class JsonUtils {

    public static <T> Map<String, T> asMap(Object... args) {
        int len  = args.length;
        if(len % 2 != 0)
            throw new IllegalArgumentException("Map size is illeagal "+len);
        Map<String, T> map = new HashMap<>();
        for(int i = 0; i < len-1; i += 2){
            map.put(String.valueOf(args[i]),(T)args[i+1]);
        }
        return map;
    }

}
