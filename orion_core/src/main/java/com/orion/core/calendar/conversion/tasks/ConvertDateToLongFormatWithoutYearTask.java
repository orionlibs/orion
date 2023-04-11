package com.orion.core.calendar.conversion.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.Calendar;
import com.orion.core.calendar.DateTokens;

public class ConvertDateToLongFormatWithoutYearTask extends Orion
{
    public static String run(DateTokens dateParts)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(dateParts.getDays());
        sb.append(" ");
        sb.append(Calendar.monthNumberToAbbreviatedNameMapper.get(dateParts.getMonth()));
        return sb.toString();
    }
}