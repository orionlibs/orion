package com.orion.core.calendar.time.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.time.Time;
import com.orion.core.calendar.time.TimeRules;

public class HashCodeForTimeTask extends Orion
{
    public static int run(Time time)
    {
        TimeRules.isValid(time);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + time.getHours();
        hash = defaultPrimeNumberForHashing * hash + time.getMinutes();
        hash = defaultPrimeNumberForHashing * hash + time.getSeconds();
        return defaultPrimeNumberForHashing * hash + time.getMilliseconds();
    }
}