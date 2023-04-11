package com.orion.math.function.tasks.onevariable.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class MultiplyValuesOfFunctions1x1Task extends Orion
{
    public static ANumber run(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        NumberRules.isNotNull(x);
        FunctionRules.areValid(functions);
        final ANumber result = ANumber.of(1);
        Arrays.stream(functions).forEach(f -> result.multiply(f.run(x)));
        return result;
    }
}