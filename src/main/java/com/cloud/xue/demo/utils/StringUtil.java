package com.cloud.xue.demo.utils;

/**
 * @Program demo
 * @Title: StringUtil
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-14 14:55:33
 */
public class StringUtil {
    public static boolean isNotNull(String str){
        return (str != null && !"".equals(str))?true:false;
    }
}
