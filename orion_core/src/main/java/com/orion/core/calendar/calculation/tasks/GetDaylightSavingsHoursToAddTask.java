package com.orion.core.calendar.calculation.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.Calendar;
import java.time.Instant;
import java.time.ZoneId;
import java.util.TimeZone;

public class GetDaylightSavingsHoursToAddTask extends Orion
{
    public static int run(ZoneId zoneID)
    {

        if(zoneID != null)
        {

            if(zoneID.getRules().isDaylightSavings(Instant.now()))
            {
                return TimeZone.getTimeZone(zoneID).getDSTSavings() / Calendar.millisecondsInAnHour;
            }
            else
            {
                return 0;
            }

        }
        else
        {

            if(TimeZone.getDefault().inDaylightTime(new java.util.Date()))
            {
                return TimeZone.getDefault().getDSTSavings() / Calendar.millisecondsInAnHour;
            }
            else
            {
                return 0;
            }

        }

    }
}