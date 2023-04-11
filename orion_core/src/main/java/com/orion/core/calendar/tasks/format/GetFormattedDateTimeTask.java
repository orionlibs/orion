package com.orion.core.calendar.tasks.format;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.FormattedDateTime;
import com.orion.core.calendar.FormattedDateTime.FormattedDateTimeBuilder;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.datetime.DateTimeRules;

public class GetFormattedDateTimeTask extends Orion
{
    public static FormattedDateTime run(DateTime datetime) throws InvalidDateException
    {
        DateTimeRules.isValid(datetime);
        FormattedDateTimeBuilder formattedDateTimeBuilder = FormattedDateTime.builder();

        if(datetime.getDate() != null)
        {
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitByHyphens(datetime.getDate().getDateStringSplitByHyphens());
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitByHyphensYearFirst(datetime.getDate().getDateStringSplitByHyphensYearFirst());
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitBySlashes(datetime.getDate().getDateStringSplitBySlashes());
            formattedDateTimeBuilder = formattedDateTimeBuilder.dateSplitBySlashesYearFirst(datetime.getDate().getDateStringSplitBySlashesYearFirst());
            formattedDateTimeBuilder = formattedDateTimeBuilder.longDate(datetime.getDate().getLongDateYearFirstString());
        }

        if(datetime.getTime() != null)
        {
            formattedDateTimeBuilder = formattedDateTimeBuilder.time(datetime.getTime().getTimeString());
            formattedDateTimeBuilder = formattedDateTimeBuilder.timeWithISOFormat(datetime.getTime().getTimeStringInISOFormat());
        }

        return formattedDateTimeBuilder.build();
    }
}