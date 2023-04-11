package com.orion.core.calendar.tasks.format;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.string.StringsService;

public class FormatDateTimeUnitWith2CharactersTask extends Orion
{
    public static String run(long unit)
    {
        Assert.isNonNegative(unit, "The given unit input (day, month, hour, etc.) has to be >= 0.");
        String unitString = Long.toString(unit);

        if(unit < 10)
        {
            return StringsService.prefixString(unitString, "0");
        }
        else
        {
            return unitString;
        }

    }
}