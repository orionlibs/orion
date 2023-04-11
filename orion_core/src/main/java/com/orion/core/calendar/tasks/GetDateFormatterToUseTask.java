package com.orion.core.calendar.tasks;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.orion.core.calendar.date.DateRules;
import com.orion.core.calendar.date.InvalidDateException;
import java.time.format.DateTimeFormatter;

public class GetDateFormatterToUseTask
{
    public static DateTimeFormatter run(String dateString, String format) throws InvalidDateException
    {
        DateRules.isValid(dateString);

        if(!isBlank(format))
        {
            return DateTimeFormatter.ofPattern(format);
        }
        else
        {

            if(dateString.indexOf("-") >= 0)
            {
                return DateTimeFormatter.ofPattern("uuuu-MM-dd");
            }
            else
            {
                return DateTimeFormatter.ofPattern("uuuu/MM/dd");
            }

        }

    }
}
