package com.orion.core.calendar.datetime;

import com.orion.core.abstraction.OrionRule;
import com.orion.core.calendar.CalendarRules;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.DateRules;
import com.orion.core.calendar.time.Time;
import com.orion.core.calendar.time.TimeRules;
import com.orion.core.exception.Assert;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class DateTimeRules extends OrionRule
{
    public static void isValidDateTime(String dateTimeString)
    {
        Assert.notEmpty(dateTimeString, "There was no dateTimeString provided.");
    }


    public static void isValidDateAndTime(String dateString, String timeString)
    {
        Assert.notEmpty(dateString, "There was no dateString provided.");
        Assert.notEmpty(timeString, "There was no timeString provided.");
    }


    public static void isValid(Date date, Time time)
    {
        DateRules.isValid(date);
        TimeRules.isValid(time);
    }


    public static void isValid(Date date, Time time, ZoneId zoneID)
    {
        DateRules.isValid(date);
        TimeRules.isValid(time);
        CalendarRules.isValid(zoneID);
    }


    public static void isValid(LocalDateTime localDateTime)
    {
        Assert.notNull(localDateTime, "LocalDateTime is null.");
    }


    public static void isValid(Timestamp dateTime)
    {
        Assert.notNull(dateTime, "Timestamp is null.");
    }


    public static void isValid(LocalDateTime localDateTime, ZoneId zoneID)
    {
        isValid(localDateTime);
        CalendarRules.isValid(zoneID);
    }


    public static void isValid(ZonedDateTime zonedDateTime)
    {
        Assert.notNull(zonedDateTime, "ZonedDateTime is null.");
    }


    public static void isValid(DateTime dateTime)
    {
        Assert.notNull(dateTime, "DateTime is null.");
        isValid(dateTime.getDate(), dateTime.getTime(), dateTime.getZoneID());
    }


    public static void isValidIgnoringZoneID(DateTime dateTime)
    {
        Assert.notNull(dateTime, "DateTime is null.");
        isValid(dateTime.getDate(), dateTime.getTime());
    }


    public static void doesDateExist(DateTime dateTime)
    {
        Assert.notNull(dateTime, "DateTime is null.");
        DateRules.isValid(dateTime.getDate());
    }


    public static void doesTimeExist(DateTime dateTime)
    {
        Assert.notNull(dateTime, "DateTime is null.");
        TimeRules.isValid(dateTime.getTime());
    }


    public static void areValid(List<DateTime> dateTimes)
    {
        Assert.notEmpty(dateTimes, "No DateTimes provided.");
        dateTimes.forEach(dateTime -> isValidIgnoringZoneID(dateTime));
    }


    public static void areValid(DateTime[] dateTimes)
    {
        Assert.notEmpty(dateTimes, "No DateTimes provided.");
        areValid(Arrays.asList(dateTimes));
    }
}