package com.orion.core.calendar.calculation.tasks.difference;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.datetime.DateTimeRules;
import com.orion.core.exception.InvalidArgumentException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class GetDifferenceBetweenTwoDateTimesInMillisecondsTask extends Orion
{
    public static long run(DateTime dateTime1, DateTime dateTime2) throws InvalidArgumentException
    {
        DateTimeRules.areValid(Arrays.asList(dateTime1, dateTime2));

        if(dateTime1.getTime() == null || dateTime2.getTime() == null)
        {
            return CalendarService.getDifferenceBetweenTwoDatesInMilliseconds(dateTime1.getDate(), dateTime2.getDate());
        }
        else if(dateTime1.getDate() == null || dateTime2.getDate() == null)
        {
            return CalendarService.getDifferenceBetweenTwoTimesInMilliseconds(dateTime1.getTime(), dateTime2.getTime());
        }

        LocalDateTime localDateTime1 = dateTime1.toLocalDateTime();
        LocalDateTime localDateTime2 = dateTime2.toLocalDateTime();

        if(dateTime1.getZoneID() == null && dateTime2.getZoneID() == null)
        {
            return ChronoUnit.MILLIS.between(localDateTime1, localDateTime2);
        }
        else if(dateTime1.getZoneID() == null)
        {
            return ChronoUnit.MILLIS.between(dateTime1.toZonedDateTime(dateTime2.getZoneID()), dateTime2.toZonedDateTime());
        }
        else if(dateTime2.getZoneID() == null)
        {
            return ChronoUnit.MILLIS.between(dateTime1.toZonedDateTime(), dateTime2.toZonedDateTime(dateTime1.getZoneID()));
        }
        else
        {
            return ChronoUnit.MILLIS.between(dateTime1.toZonedDateTime(), dateTime2.toZonedDateTime());
        }

    }
}
