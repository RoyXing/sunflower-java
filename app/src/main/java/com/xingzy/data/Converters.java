package com.xingzy.data;

import java.util.Calendar;

import androidx.room.TypeConverter;

/**
 * @author roy.xing
 * @date 2018/12/5
 */
public class Converters {

    @TypeConverter
    public long calendarToDateStamp(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    public Calendar dateStampToCalendar(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }
}
