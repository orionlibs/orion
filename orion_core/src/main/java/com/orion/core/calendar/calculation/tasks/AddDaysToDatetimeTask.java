package com.orion.core.calendar.calculation.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarRules;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.datetime.DateTimeRules;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddDaysToDatetimeTask extends Orion
{
    public static DateTime run(DateTime datetime, long numberOfDays, ZoneId zone)
    {
        DateTimeRules.isValidIgnoringZoneID(datetime);
        CalendarRules.isValid(zone);

        if(numberOfDays == 0)
        {
            return datetime.getCopy();
        }
        else
        {
            ZonedDateTime zonedDatetime = CalendarService.convertInstantToLocalDate(datetime.toInstant(), zone)
                            .plusDays(numberOfDays)
                            .atStartOfDay(zone);
            return DateTime.of(zonedDatetime);
        }

    }
}