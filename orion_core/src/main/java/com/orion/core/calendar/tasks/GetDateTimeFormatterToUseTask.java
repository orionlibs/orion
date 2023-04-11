package com.orion.core.calendar.tasks;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.time.format.DateTimeFormatter;

public class GetDateTimeFormatterToUseTask
{
    public static DateTimeFormatter run(String format)
    {

        if(!isBlank(format))
        {
            return DateTimeFormatter.ofPattern(format);
        }
        else
        {
            return DateTimeFormatter.ISO_DATE_TIME;
        }

    }
}
