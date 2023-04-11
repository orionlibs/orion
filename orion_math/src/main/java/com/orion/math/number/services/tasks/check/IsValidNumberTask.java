package com.orion.math.number.services.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.NumberRules;
import java.math.BigDecimal;

public class IsValidNumberTask extends Orion
{
    public static boolean run(String value)
    {
        NumberRules.isNotNull(value);

        if(value != null && ("NaN".equals(value) || "infinity".contains(value.toLowerCase())))
        {
            return false;
        }
        else
        {

            try
            {
                new BigDecimal(value);
                return true;
            }
            catch(NumberFormatException e)
            {
                //throw new InvalidArgumentException("Canont parse a nonnumeric string.");
                return false;
            }

        }

    }


    public static boolean run(Number value)
    {
        return run(value.toString());
    }
}