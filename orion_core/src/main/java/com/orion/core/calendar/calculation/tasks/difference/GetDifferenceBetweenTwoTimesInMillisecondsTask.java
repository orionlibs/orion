package com.orion.core.calendar.calculation.tasks.difference;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.time.Time;
import com.orion.core.calendar.time.TimeRules;
import com.orion.core.exception.InvalidArgumentException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoTimesInMillisecondsTask extends Orion
{
    public static long run(Time time1, Time time2) throws InvalidArgumentException
    {
        TimeRules.isValid(time1);
        TimeRules.isValid(time2);
        return ChronoUnit.MILLIS.between(time1.toLocalTime(), time2.toLocalTime());
    }
}
