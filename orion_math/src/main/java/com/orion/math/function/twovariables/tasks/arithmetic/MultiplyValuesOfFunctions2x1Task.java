package com.orion.math.function.twovariables.tasks.arithmetic;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class MultiplyValuesOfFunctions2x1Task extends Orion
{
    public static ANumber run(ANumber x, ANumber y, Function2x1<ANumber, ANumber, ANumber>[] functions)
    {
        NumberRules.areNotNull(x, y);
        FunctionRules.areValid(functions);
        final ANumber result = ANumber.of(1);
        Arrays.stream(functions).forEach(f -> result.multiply(f.run(x, y)));
        return result;
    }
}