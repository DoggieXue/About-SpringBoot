package com.cloud.xue.demo.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Program demo
 * @Title: TimeUtil
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-11-14 10:25:01
 */
public class TimeUtil {

    /**
     * 获取当前格式化时间
     * @param formatter
     * @return
     */
    public static String dateFormat(String formatter){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatter);
        return localDateTime.format(dtf);
    }

    /**
     * 获取当前时间戳  2019-11-14T02:44:49.725Z
     * @return
     */
    public static Instant getCurrtInstant(){
        return Instant.now();
    }

    /**
     * 判断当前年是否为闰年
     * @return
     */
    public static boolean isLeapYear(){
        return LocalDate.now().isLeapYear();
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalDateTime.now());//UTC/格林威治时间

        System.out.println("===========");
        System.out.println(dateFormat("yyyy-MM-dd HH:MM:SS"));
        System.out.println(dateFormat("hhmmss"));
        System.out.println(getCurrtInstant());
    }
}
