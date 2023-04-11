package com.orion.math.number.interval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.string.StringsService;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IntervalPrintTask extends Orion
{
    public static String run(Interval interval)
    {
        IntervalRules.isValid(interval);
        String middlePart = interval.getLeftEndpoint().printRealValue() + ", " + interval.getRightEndpoint().printRealValue();

        if(interval.isOpen())
        {
            return StringsService.surroundWithParentheses(middlePart);
        }
        else if(interval.isClosed())
        {
            return StringsService.surroundWithSquareBrackets(middlePart);
        }
        else if(interval.isLeftOpen())
        {
            return StringsService.surroundWithString(middlePart, "(", "]");
        }
        else if(interval.isRightOpen())
        {
            return StringsService.surroundWithString(middlePart, "[", ")");
        }

        return "";
    }
}