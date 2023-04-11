package com.orion.math.function.tasks.checks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class CanFunctionRunWithGivenIntervalTask extends Orion
{
    public static boolean run(Function f, Interval intervalToCheck)
    {
        FunctionRules.isValid(f);
        IntervalRules.isValid(intervalToCheck);

        if(f.getDomain() == null)
        {
            return true;
        }
        else if(f.getDomain() != null)
        {

            if(((FunctionDomain1x1)f.getDomain()).getIntervalOfVariable1().isIntervalInside(intervalToCheck))
            {
                return true;
            }

        }

        throw new InvalidArgumentException("The given intervalToCheck = " + intervalToCheck + " is not inside the function's domain.");
    }
}