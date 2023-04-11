package com.orion.math.function.nvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class MultiplyValuesOfFunctionsNx1Task extends Orion
{
    public static ANumber run(ANumber[] x, int numberOfVariables, FunctionNx1[] functions)
    {
        NumberRules.areNotNull(x);
        FunctionRules.doNumberOfVariablesMatch(functions);
        final ANumber result = ANumber.of(1);
        Arrays.stream(functions).forEach(f -> result.multiply(f.run(x)));
        return result;
    }
}