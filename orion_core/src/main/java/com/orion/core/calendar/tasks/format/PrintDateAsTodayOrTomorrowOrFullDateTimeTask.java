package com.orion.core.calendar.tasks.format;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.date.Date;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;

public class PrintDateAsTodayOrTomorrowOrFullDateTimeTask extends Orion
{
    public static String run(DateTime datetime, boolean printYear) throws InvalidDateException
    {

        if(datetime != null)
        {
            Date currentDate = CalendarService.getCurrentDateAdjustingForDaylightSavings();
            String result = "";

            if(datetime.getDate().equals(currentDate))
            {
                result = "today @ " + datetime.printTimeAsIsWithoutSeconds();
            }
            else
            {

                if(datetime.getDate().equals(CalendarService.addDaysToCurrentDatetimeAdjustingForDaylightSavings(1).getDate()))
                {
                    result = "tomorrow @ " + datetime.printTimeAsIsWithoutSeconds();
                }
                else
                {

                    if(printYear)
                    {
                        result = datetime.printInInternationalFormatWithAtSymbolWithoutSeconds();
                    }
                    else
                    {
                        result = datetime.printLongDateWithoutYearWithAtSymbolWithoutSeconds();
                    }

                }

            }

            return result;
        }
        else
        {
            return "";
        }

    }
}