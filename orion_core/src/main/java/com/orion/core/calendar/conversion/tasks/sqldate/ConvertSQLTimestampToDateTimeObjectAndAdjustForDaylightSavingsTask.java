package com.orion.core.calendar.conversion.tasks.sqldate;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.time.Time;
import java.sql.Timestamp;

public class ConvertSQLTimestampToDateTimeObjectAndAdjustForDaylightSavingsTask extends Orion
{
    public static DateTime run(Timestamp SQLDate)
    {

        if(SQLDate != null)
        {
            int timezoneOffsetInHours = CalendarService.getDaylightSavingsHoursToAdd();
            SQLTimestamp datetime = CalendarService.addHoursToDatetime(SQLDate, timezoneOffsetInHours);
            Date date = Date.of(datetime.getYear() + 1900, datetime.getMonth() + 1, datetime.getDate());
            Time time = Time.of(datetime.getHours(), datetime.getMinutes(), datetime.getSeconds());
            return DateTime.of(date, time);
        }
        else
        {
            return null;
        }

    }
}