package com.orion.math.function.tasks.checks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.number.ANumber;

public class CanFunctionRunWithGivenValueTask extends Orion
{
    public static boolean run(Function f, Object value)
    {
        FunctionRules.isValid(f);
        Assert.notNull(value, "The value input cannot be null.");

        if(f.getDomain() == null)
        {
            return true;
        }
        else
        {

            if(value instanceof ANumber)
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain1x1)f.getDomain()).getIntervalOfVariable1() != null)
                    {

                        if(((FunctionDomain1x1)f.getDomain()).getIntervalOfVariable1().isPointInsideInterval((ANumber)value))
                        {
                            return true;
                        }

                    }

                }

            }
            else if(((FunctionDomain1x1)f.getDomain()).getAllowedValuesForVariable1().contains(value))
            {
                return true;
            }

        }

        throw new InvalidArgumentException("The given value = " + value + " does not belong to the function's domain.");
    }
}