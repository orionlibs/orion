package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetValueForComposedFunctions1x1Task extends Orion
{
    public static ANumber run(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        NumberRules.isNotNull(x);
        FunctionRules.areValid(functions);
        ANumber result = x.getCopy();

        for(int i = functions.length - 1; i >= 0; i--)
        {
            result = functions[i].run(result);
        }

        return result;
    }
}