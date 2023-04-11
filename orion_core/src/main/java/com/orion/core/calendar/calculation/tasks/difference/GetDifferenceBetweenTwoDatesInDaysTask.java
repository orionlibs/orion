package com.orion.core.calendar.calculation.tasks.difference;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.DateRules;
import com.orion.core.exception.InvalidArgumentException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GetDifferenceBetweenTwoDatesInDaysTask extends Orion
{
    public static long run(Date date1, Date date2) throws InvalidArgumentException
    {
        DateRules.isValid(date1);
        DateRules.isValid(date2);
        return ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate());
    }
}
