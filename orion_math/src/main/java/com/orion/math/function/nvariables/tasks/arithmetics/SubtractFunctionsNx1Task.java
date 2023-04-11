package com.orion.math.function.nvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;

public class SubtractFunctionsNx1Task extends Orion
{
    public static FunctionNx1 run(FunctionNx1 f, FunctionNx1 g, int numberOfVariables)
    {
        FunctionRules.doNumberOfVariablesMatch(f, g);
        FunctionNx1IF<ANumber, ANumber> function = (ANumber[] x) ->
        {
            return f.run(x).subtractGET(g.run(x));
        };
        return FunctionNx1.of(function, numberOfVariables);
    }
}