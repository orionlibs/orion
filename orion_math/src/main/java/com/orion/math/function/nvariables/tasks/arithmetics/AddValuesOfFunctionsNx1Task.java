package com.orion.math.function.nvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class AddValuesOfFunctionsNx1Task extends Orion
{
    public static ANumber run(ANumber[] x, int numberOfVariables, FunctionNx1[] functions)
    {
        NumberRules.areNotNull(x);
        FunctionRules.doNumberOfVariablesMatch(functions);
        ANumber result = ANumber.of(0);
        Arrays.stream(functions).forEach(f -> result.add(f.run(x)));
        return result;
    }
}