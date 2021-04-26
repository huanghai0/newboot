package com.example.newboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.function.IntFunction;

/**
 * @author bangsun
 */
@Slf4j
public class DateUtils {

    public static final DateTimeFormatter NUMBER_DTF    = DateTimeFormat.forPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter NORMAL_DTF    = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_DTF      = DateTimeFormat.forPattern("yyyy-MM-dd");
    public static final DateTimeFormatter ZERO_DTF      = DateTimeFormat.forPattern("yyyy-MM-dd 00:00:00");
    public static final DateTimeFormatter TIMESTAMP_DTF = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateTimeFormatter HOUR_DTF = DateTimeFormat.forPattern("yyyy-MM-dd HH");

    public static Date addWorkDays(LocalDateTime localDateTime, int adddays){
        IntFunction<TemporalAdjuster> addBusinessDays = days -> TemporalAdjusters.ofDateAdjuster(
                date -> {
                    LocalDate baseDate =
                            days > 0 ? date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                                    : days < 0 ? date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) : date;
                    int businessDays = days + Math.min(Math.max(baseDate.until(date).getDays(), -4), 4);
                    return baseDate.plusWeeks(businessDays / 5).plusDays(businessDays % 5);
                });
        LocalDateTime newdate = localDateTime.with(addBusinessDays.apply(adddays));
        ZonedDateTime zonedDateTime = newdate.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    };

    /**
     * 获取开始时间
     * @param startDate
     * @return
     */
    public static Date getStartTime(String startDate){
        Date result = null;
        try{
            if(StringUtils.isNotEmpty(startDate)){
                String startTime = startDate + " 00:00:00";
                result = parse(startTime, NORMAL_DTF);
            }
        }catch(Exception e){
            log.error("日期转换出错",e);
        }
        return result;
    }

    /**
     * 获取结束时间
     * @param endDate
     * @return
     */
    public static Date getEndTime(String endDate){
        Date result = null;
        try{
            if(StringUtils.isNotEmpty(endDate)){
                String endTime = endDate + " 23:59:59";
                result = parse(endTime, NORMAL_DTF);
            }
        }catch(Exception e){
            log.error("日期转换出错",e);
        }
        return result;
    }

    /**
     * Date型时间数据转换成“yyyy-MM-dd”格式的String型时间数据
     */
    public static String formatDate(Date date){
        return format(date, DATE_DTF);
    }

    /**
     * 根据自定义DateTimeFormatter把字符型时间数据转换成Date型时间数据
     * @param timeStr
     * @return
     */
    public static Date parse(String timeStr, DateTimeFormatter dtf){
        timeStr = timeStr.replace("T"," ");
        return DateTime.parse(timeStr, dtf).toDate();
    }

    public static Date parse(String timeStr, String pattern){
        DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(timeStr, dtf).toDate();
    }

    /**
     * 根据自定义DateTimeFormatter格式化时间数据
     * @param date
     * @return
     */
    public static String format(Date date, DateTimeFormatter dtf){
        if(null != date){
            return new DateTime(date).toString(dtf);
        }
        else{
            return "";
        }
    }

    /**
     * 获取开始时间
     * @param startDate
     * @return
     */
    public static Date getUTCStartTime(String startDate){
        Date result = null;
        startDate = startDate.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(StringUtils.isNotEmpty(startDate)) {
                Date time = format.parse(startDate);
                result = parse(defaultFormat.format(time) + " 00:00:00", NORMAL_DTF);
            }
        } catch (Exception e) {
            log.error("日期转换出错",e);
        }

        return result;
    }

    /**
     * 获取结束时间
     * @param endDate
     * @return
     */
    public static Date getUTCEndTime(String endDate){
        Date result = null;
        endDate = endDate.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(StringUtils.isNotEmpty(endDate)) {
                Date time = format.parse(endDate);
                result = parse(defaultFormat.format(time) + " 23:59:59", NORMAL_DTF);
            }
        } catch (Exception e) {
            log.error("日期转换出错",e);
        }

        return result;
    }

    /***
     *
     * @param startDateOne 第一个时间段的开始时间
     * @param endDateOne 第一个时间段的结束时间
     * @param startDateTwo 第二个时间段的开始时间
     * @param endDateTwo 第二个时间段的结束时间
     * @return
     */
    public static Boolean isInterSection(Date startDateOne,Date endDateOne,Date startDateTwo,Date endDateTwo)
    {
        Date maxStartDate = startDateOne;
        if(maxStartDate.before(startDateTwo))
        {
            maxStartDate = startDateTwo;
        }

        Date minEndDate = endDateOne;
        if(endDateTwo.before(minEndDate))
        {
            minEndDate = endDateTwo;
        }
        return maxStartDate.before(minEndDate) || (maxStartDate.getTime() == minEndDate.getTime());
    }
}
