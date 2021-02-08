package com.mf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static int getYearBy_yyyyMMdd(String formatContent) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(formatContent);
        Calendar calendar = date2Calendar(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonthBy_yyyyMMdd(String formatContent) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = sdf.parse(formatContent);
        Calendar calendar = date2Calendar(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getYearBy_yyyyMM(String formatContent) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date = sdf.parse(formatContent);
        Calendar calendar = date2Calendar(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonthBy_yyyyMM(String formatContent) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date = sdf.parse(formatContent);
        Calendar calendar = date2Calendar(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getNowYear(){
        Calendar calendar = date2Calendar(new Date());
        return calendar.get(Calendar.YEAR);
    }

    public static int getNowMonth(){
        Calendar calendar = date2Calendar(new Date());
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static void main(String[] args) throws ParseException {

        System.out.println(getMonthBy_yyyyMMdd("2020112"));
    }

    private static Calendar date2Calendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
