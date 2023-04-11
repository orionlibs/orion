package com.orion.core.calendar.conversion.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.Calendar;
import com.orion.core.calendar.DateTokens;

public class ConvertDateToLongFormatYearFirstTask extends Orion
{
    public static String run(DateTokens dateParts)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(dateParts.getYear());
        sb.append(" ");
        sb.append(Calendar.monthNumberToAbbreviatedNameMapper.get(dateParts.getMonth()));
        sb.append(" ");
        sb.append(dateParts.getDays());
        return sb.toString();
    }
}