package com.orion.math.function.tasks.onevariable.checks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.array.ArraySortService;
import com.orion.core.exception.Assert;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class IsFunction1x1DecreasingForXValuesTask extends Orion
{
    public static boolean run(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        FunctionRules.isValid(f);
        NumberRules.areNotNull(xValues);
        Assert.hasLengthAtLeast(xValues, 2, "The xValues input should have more than 2 values.");
        ArraySortService.sort(xValues);
        ANumber yValue = f.run(xValues[0]);

        for(int i = 1; i < xValues.length; i++)
        {
            ANumber value = f.run(xValues[i]);

            if(value.isGreaterThan(yValue))
            {
                return false;
            }
            else
            {
                yValue = value;
            }

        }

        return true;
    }
}