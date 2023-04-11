package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;

public class RunPipelineOfFunctions1x1Task extends Orion
{
    public static Object run(Function1x1<Object, Object>[] functions, Object valueForF1)
    {
        FunctionRules.areValid(functions);
        Object currentFValue = null;

        for(int i = 0; i < functions.length; i++)
        {

            if(i == 0)
            {
                currentFValue = functions[i].run(valueForF1);
            }
            else
            {
                currentFValue = functions[i].run(currentFValue);
            }

        }

        return currentFValue;
    }
}