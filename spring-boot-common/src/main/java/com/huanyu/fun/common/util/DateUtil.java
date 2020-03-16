package com.huanyu.fun.common.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_ZH = "yyyy年MM月dd日";
    public static final String YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMdd HH:mm:ss";
    public static final String YYYYMMDDHHMMSS_CONTINUOUS = "yyMMddHHmmss";
    public static final String YYYY_MM_BACKSLASH = "yyyy/MM";
    public static final String YYYY_MM_dd_BACKSLASH = "yyyy/MM/dd";

    /**
     * @param date   传入的时间
     * @param format 返回字符串格式
     * @return
     * @Title: date2Str
     * @Description:将时间类型转换为字符串
     */
    public static String date2Str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * @param dateStr 传入的字符串
     * @param format  对应的格式
     * @return
     * @Title: str2Date
     * @Description:将字符串改为时间
     */
    public static Date str2Date(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
    }

    /**
     * @param date         需要转换的日期
     * @param formatBefore 转换之前日期的格式
     * @param formatAfter  转换之后日期的格式
     * @return
     * @Title: str2Str
     * @Description: TODO(转换日期的显示格式)
     */
    public static String str2Str(String date, String formatBefore, String formatAfter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatBefore);
        try {
            Date tmpDate = sdf.parse(date);
            sdf = new SimpleDateFormat(formatAfter);
            return sdf.format(tmpDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
    }

    /**
     * @return
     * @Title: getNow
     * @Description:获取当前日期
     */
    public static String getNow() {
        return date2Str(new Date(), YYYY_MM_DD);
    }

    /**
     * @return
     * @Title: getNow
     * @Description:获取当前时间
     */
    public static String getNowTime() {
        return date2Str(new Date(), YYYY_MM_DD_HHMMSS);
    }

    /**
     * @param addDay 新增的天数
     * @return
     * @Title: addNow
     * @Description:获取今天新增天数之后的日期
     */
    public static Date addNow(Integer addDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        return calendar.getTime();
    }

    /**
     * 获取1900年1月1日新增天数后的日期
     *
     * @param addDay
     * @return
     */
    public static Date add1900(Integer addDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900, 0, 1);
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        return calendar.getTime();
    }

    /**
     * 按照所给格式进行日期转换
     *
     * @param format
     * @return
     */
    public static String getDate(String format) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * @return
     * @Title: getCurrTime
     * @Description:获取时分秒信息
     */
    public static String getCurrTime() {
        return getDate("HHmmss");
    }


    /**
     * 获取时间增加指定天数后的日期
     *
     * @param addDay
     * @return
     */
    public static Date addDay(Date oldDate, Integer addDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.add(Calendar.DAY_OF_MONTH, addDay);
        return calendar.getTime();
    }

    /**
     * @param oldDate
     * @param addMonth
     * @return
     * @Title: addMonth
     * @Description:获取时间增加月份后的日期
     */
    public static Date addMonth(Date oldDate, Integer addMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.add(Calendar.MONTH, addMonth);
        return calendar.getTime();
    }

    public static Date addMinute(Date oldDate, Integer addMinute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.add(Calendar.MINUTE, addMinute);
        return calendar.getTime();
    }

    public static Date addSecond(Date oldDate, Integer addSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.add(Calendar.SECOND, addSecond);
        return calendar.getTime();
    }

    /**
     * @param oldDate
     * @param addMonth
     * @return
     * @Title: addMonth
     * @Description:获取时间增加月份后的日期并修改月中的日
     */
    public static Date changeDayAndAddMonth(Date oldDate, Integer addMonth, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oldDate);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.MONTH, addMonth);
        return calendar.getTime();
    }

    /**
     * @return
     * @Title: getLastNow
     * @Description:获取今天的截止时间 即:yyyy-MM-dd 23:59:59
     */
    public static Date getLastNow() {
        String nowStr = getNow();
        String newNowStr = nowStr + " 23:59:59";
        return str2Date(newNowStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @Description: 获取当前日期23:59:59的字符串
     * @Author: sunsf
     * @Date: 2019/7/1
     */

    public static String getLastNowStr() {
        String nowStr = getNow();
        String newNowStr = nowStr + " 23:59:59";
        return newNowStr;
    }

    /**
     * @Description: 获取指定字符串的23:59:59
     * @Author: sunsf
     * @Date: 2019/7/1
     */

    public static String getLastNowStr(String dateStr) {
        String newNowStr = dateStr + " 23:59:59";
        return newNowStr;
    }


    public static Date getNowDate() {
        String nowStr = getNowTime();
        return str2Date(nowStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param startDate 开始日期
     * @param endDate   截止日期
     * @return
     * @Title: minusDate
     * @Description:比较两个日期的时间间隔天数 开始日期 - 截止日期
     */
    public static Integer minusDate(Date startDate, Date endDate) {
        int result = 0;
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endCal.setTime(endDate);
        while (startCal.after(endCal)) {
            endCal.add(Calendar.DATE, 1);
            result++;
        }
        return result == 0 ? 0 : result - 1;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取参数时间到当前时间的时间数
     *
     * @param dateTime
     * @return
     */
    public static Integer minusMinute(String dateTime) {
        int result = 0;
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(new Date());
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(str2Date(dateTime, "yyyy-MM-dd HH:mm:ss"));
        while (startCal.after(endCal)) {
            endCal.add(Calendar.MINUTE, 1);
            result++;
        }
        return result == 0 ? 0 : result - 1;
    }

    /**
     * @param date
     * @return
     * @Title: getDayByCalendar
     * @Description: TODO(获取日期)
     */
    public static int getDayByCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);// 获取日
        return day;
    }

    public static int compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int compareDate(Date date1, Date date2) {
        try {
            if (date1.getTime() > date2.getTime()) {
                return 1;
            } else if (date1.getTime() < date2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断当前日期是否属于某一个时间段
     */
    public static boolean isDateFlag(String startDate, String endDate) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        Date nowTime = null;
        Date beginTime = null;
        Date endTime = null;
        boolean flag = false;
        try {
            nowTime = df.parse(df.format(new Date()));
            //定义开始时间
            beginTime = df.parse(startDate);
            //定义结束时间
            endTime = df.parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //调用判断方法
        flag = belongCalendar(nowTime, beginTime, endTime);
        return flag;
    }

    /**
     * 判断时间是否在时间段内
     * *@param nowTime
     *
     * @param beginTime
     * @param endTime
     * @return      
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        //设置开始时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
        //设置结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        //处于开始时间之后，和结束时间之前的判断
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    // 获得某天最大时间 2017-10-15 23:59:59
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        ;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    // 获得某天最小时间 2017-10-15 00:00:00
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
}

