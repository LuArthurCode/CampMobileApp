package com.mvgx.common.init.utils;

import android.text.TextUtils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {


    public static final String DB_TIME_PATTERN_F1 = "yyyy-MM-dd HH:mm:ss";
    public static final String DB_TIME_PATTERN_F2 = "HH:mm:ss";
    public static final String DB_TIME_PATTERN_F3 = "yyyy-MM-dd";
    public static final String DB_TIME_PATTERN_F4 = "yyyy";

    /**
     * 获取时间戳
     *
     * @return
     */
    public static long getCurTimeLong() {
        long time = System.currentTimeMillis();
        return time;
    }

    /**
     * 获取当前时间
     */
    public static String getCurDate(String patten) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(patten);
        return sDateFormat.format(new Date());
    }


    public static String getFormatF3(Date date) {
        String result = "";
        if (null == date) return result;

        SimpleDateFormat sDateFormat = new SimpleDateFormat(DB_TIME_PATTERN_F3);
        result = sDateFormat.format(date);
        return result;
    }

    /**
     * 时间戳转换成字符串
     *
     * @param milSecond
     * @param pattern
     * @return
     */
    public static String getDateToString(long milSecond, String pattern) {
        if (milSecond == 0) {
            return getCurDate(DB_TIME_PATTERN_F1);
        }
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 将格林威治时间字符串转换为yyyy-MM-dd HH:mm:ss字符串，JDK1.7以上版本支持该方法
     * @param milSecond
     * @return
     */
    public static String getDateToString(String milSecond) {
        if (TextUtils.isEmpty(milSecond)) {
            return getCurDate(DB_TIME_PATTERN_F1);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            Date date = sd.parse(milSecond);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCurDate(DB_TIME_PATTERN_F1);
    }

    public static String getCurrentDateString() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(DB_TIME_PATTERN_F3);
        return sDateFormat.format(new Date());
    }
    public static String getCurrentTimeString() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(DB_TIME_PATTERN_F2);
        return sDateFormat.format(new Date());
    }

    public static String getCurrentString(){
        SimpleDateFormat sDateFormat = new SimpleDateFormat(DB_TIME_PATTERN_F1);
        return sDateFormat.format(new Date());
    }


    //过去三个月
    public static String getStartTime(String startTime) {
        if (TextUtils.isEmpty(startTime)) return "";
        String result;
        result = startTime + " 00:00:00";
        return result;
    }

    public static String getEndTime(String endTime) {
        if (TextUtils.isEmpty(endTime)) return "";
        String result;
        result = endTime + " 23:59:59";
        return result;
    }

    public static String getNinetyDaysBeforeNow() {
        String result;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -89);
        Format format = new SimpleDateFormat(DB_TIME_PATTERN_F3);
        result = format.format(date.getTime());
        return result;
    }

    //过去1天
    public static String getDataTime(int value) {
        SimpleDateFormat format = new SimpleDateFormat(DB_TIME_PATTERN_F1);
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DATE, value);
        Date d = c.getTime();
        return format.format(d);
    }
    //过去1天
//    public static String getOneData() {
//        SimpleDateFormat format = new SimpleDateFormat(DB_TIME_PATTERN_F3);
//        Calendar c = Calendar.getInstance();
//
//        c.setTime(new Date());
//        c.add(Calendar.DATE, -1);
//        Date d = c.getTime();
//        return format.format(d);
//    }

    //过去七天
    public static String getSevenData() {
        SimpleDateFormat format = new SimpleDateFormat(DB_TIME_PATTERN_F3);
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DATE, -6);
        Date d = c.getTime();
        return format.format(d);
    }

    //过去一月
    public static String getThirtyData() {
        SimpleDateFormat format = new SimpleDateFormat(DB_TIME_PATTERN_F3);
        Calendar c = Calendar.getInstance();

        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, -29);
        Date m = c.getTime();
        return format.format(m);
    }


    public enum TRADE_TYPE {
        All, Deposit, Withdrawal
    }

    public enum TimeBtn {
        startTime, endTime
    }

    public static Date stringStamp2Date(String time) {
        time = time + "000";
        Long longTime = Long.valueOf(time);
        Date date = new Date(longTime);
        return date;
    }
}
