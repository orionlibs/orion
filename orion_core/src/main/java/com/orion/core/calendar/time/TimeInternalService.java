package com.orion.core.calendar.time;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.time.tasks.EqualsForTimeTask;
import com.orion.core.calendar.time.tasks.HashCodeForTimeTask;

class TimeInternalService extends OrionService
{
    public static int hashCode(Time time)
    {
        return HashCodeForTimeTask.run(time);
    }


    public static boolean equals(Time time, Object other)
    {
        return EqualsForTimeTask.run(time, other);
    }


    public static String formatHoursString(Time time)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(time.getHours());
    }


    public static String formatMinutesString(Time time)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(time.getMinutes());
    }


    public static String formatSecondsString(Time time)
    {
        return CalendarService.formatDateTimeUnitWith2Characters(time.getSeconds());
    }
}