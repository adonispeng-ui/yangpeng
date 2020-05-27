package com.example.yangpeng.utils;

import java.util.UUID;

/**
 * @program: yangpeng
 * @description
 * @author: YouName
 * @create: 2020-05-27 13:21
 **/
public class UUIDUtils {

    //生成uuid
    public static String getUUID32() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
