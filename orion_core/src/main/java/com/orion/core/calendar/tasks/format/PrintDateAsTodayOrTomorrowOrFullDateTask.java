package com.orion.core.calendar.tasks.format;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.date.Date;

public class PrintDateAsTodayOrTomorrowOrFullDateTask extends Orion
{
    public static String run(Date date)
    {
        Date currentDate = CalendarService.getCurrentDateAdjustingForDaylightSavings();
        String result = "";

        if(date.equals(currentDate))
        {
            result = "today";
        }
        else
        {

            if(date.equals(CalendarService.addDaysToCurrentDatetimeAdjustingForDaylightSavings(1).getDate()))
            {
                result = "tomorrow";
            }
            else
            {
                result = date.getDateStringSplitByHyphensYearFirst();
            }

        }

        return result;
    }
}