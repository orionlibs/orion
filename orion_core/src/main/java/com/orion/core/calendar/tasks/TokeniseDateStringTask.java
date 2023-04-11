package com.orion.core.calendar.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.date.DateRules;
import com.orion.core.calendar.date.InvalidDateException;

public class TokeniseDateStringTask extends Orion
{
    public static String[] run(String date) throws InvalidDateException
    {
        DateRules.isValid(date);

        if(date.indexOf("-") >= 0)
        {
            return date.split("-");
        }
        else if(date.indexOf("/") >= 0)
        {
            return date.split("/");
        }
        else
        {
            return null;
        }

    }
}