package com.orion.core.calendar.calculation.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarRules;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.datetime.DateTimeRules;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddWorkingDaysToDatetimeTask extends Orion
{
    public static DateTime run(DateTime datetime, long numberOfDays, ZoneId zone)
    {
        DateTimeRules.isValidIgnoringZoneID(datetime);
        CalendarRules.isValid(zone);
        LocalDate localDate = CalendarService.convertInstantToLocalDate(datetime.toInstant(), zone);
        ZonedDateTime zonedDatetime = null;

        while(numberOfDays > 0)
        {
            zonedDatetime = localDate.plusDays(1).atStartOfDay(zone);
            localDate = zonedDatetime.toLocalDate();

            if(CalendarService.isWeekday(zonedDatetime))
            {
                numberOfDays--;
            }

        }

        return DateTime.of(zonedDatetime);
    }
}