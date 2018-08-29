package cn.meteor.centauri.alpha.workbox.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 9:33
 * @Version: 1.0.0
 */
public class TimeUtil {
	/*
     * 将时间转换为时间戳
     */    
    public static long dateToStamp(String timeStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long ts = 0L;
        ts = simpleDateFormat.parse(timeStr).getTime();
        return ts;
    }
	
    /* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(long timeStamp){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeStamp);
        res = simpleDateFormat.format(date);
        return res;
    }
	
    /* 
     * 将时间戳转换为时间
     */
    public static String stampToDateYear(long timeStamp){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(timeStamp);
        res = simpleDateFormat.format(date);
        return res;
    }

}
