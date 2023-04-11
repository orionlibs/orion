package com.orion.core.calendar.tasks;

import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class GetTimeZoneOffsetInHoursFromUTCTask
{
    public static int run(DateTime datetime)
    {
        ZonedDateTime zonedDateTime = CalendarService.convertDatetimeToZonedDatetime(datetime);
        TimeZone timezone = TimeZone.getTimeZone(datetime.getZoneID());
        int timezoneOffset = timezone.getOffset(zonedDateTime.toInstant().getEpochSecond());
        return timezoneOffset / 3_600_000;
    }
}