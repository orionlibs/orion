package com.orion.core.calendar.datetime;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.datetime.tasks.EqualsForDateTimeTask;
import com.orion.core.calendar.datetime.tasks.HashCodeForDateTimeTask;

class DateTimeInternalService extends OrionService
{
    public static int hashCode(DateTime dateTime)
    {
        return HashCodeForDateTimeTask.run(dateTime);
    }


    public static boolean equals(DateTime dateTime, Object other)
    {
        return EqualsForDateTimeTask.run(dateTime, other);
    }
}