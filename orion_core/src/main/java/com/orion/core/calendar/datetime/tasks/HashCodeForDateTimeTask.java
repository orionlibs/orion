package com.orion.core.calendar.datetime.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.datetime.DateTimeRules;

public class HashCodeForDateTimeTask extends Orion
{
    public static int run(DateTime dateTime)
    {
        DateTimeRules.isValid(dateTime);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + dateTime.getDate().hashCode();
        hash = defaultPrimeNumberForHashing * hash + dateTime.getTime().hashCode();
        return defaultPrimeNumberForHashing * hash + dateTime.getZoneID().hashCode();
    }
}